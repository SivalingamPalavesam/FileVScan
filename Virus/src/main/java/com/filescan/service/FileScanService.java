package com.filescan.service;

import com.filescan.dto.FileScanResponse;
import com.filescan.dto.Ping;
import fi.solita.clamav.ClamAVClient;
import fi.solita.clamav.ClamAVSizeLimitException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileScanService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileScanService.class);
    ClamAVClient clamAVClient = new ClamAVClient("192.168.20.94", 3310, 10000);

    public List<FileScanResponse> scanFiles(MultipartFile[] files) {

        LOGGER.info("File received = {} ", (files != null ? files.length : null));
        return Arrays.stream(files).map(multipartFile -> {
            FileScanResponse fileScanResponse = new FileScanResponse();
            long startTime = System.currentTimeMillis();
            fileScanResponse.setUploadTime(startTime);

            if (!multipartFile.isEmpty()) {

                try {
                    byte[] response = clamAVClient.scan(multipartFile.getInputStream());
                    Boolean status = ClamAVClient.isCleanReply(response);
                    String r = new String(response, StandardCharsets.US_ASCII);
                    LOGGER.info(r);
                    fileScanResponse.setDetected(status != null ? !status : status);
                    LOGGER.info("File Scanned = {} Clam AV Response = {} ", multipartFile.getOriginalFilename(), (status != null ? status : null));

                } catch (ClamAVSizeLimitException e) {
                    LOGGER.error("Exception occurred while scanning using clam av = {} ", e.getMessage());
                    fileScanResponse.setErrorMessage(e.getMessage());

                } catch (Exception e) {
                    LOGGER.error("Exception occurred while scanning using clam av = {} ", e.getMessage(), e.fillInStackTrace());
                    fileScanResponse.setErrorMessage(e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("empty file");
            }
            fileScanResponse.setFileName(multipartFile.getOriginalFilename());
            fileScanResponse.setFileType(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
            fileScanResponse.setSize(multipartFile.getSize());
            fileScanResponse.setScanTimeInMilliSec(System.currentTimeMillis() - startTime);

            return fileScanResponse;

        }).collect(Collectors.toList());
    }

    public Ping ping() {
        try {
            return Ping.PingBuilder.aPing().withClamavAvailable(clamAVClient.ping()).withTime(System.currentTimeMillis()).build();
        } catch (IOException e) {
            LOGGER.error("unable to ping clamav daemon", e);
            return Ping.PingBuilder.aPing().withClamavAvailable(false).withTime(System.currentTimeMillis()).build();
        }
    }
}