package com.filescan.controller;

import java.io.IOException;
import java.util.List;

import com.filescan.dto.Ping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.filescan.dto.FileScanResponse;
import com.filescan.dto.ScanResponse;
import com.filescan.service.FileScanService;


@RestController
@RequestMapping("/api/v1/scan")
public class SpamWordsController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(SpamWordsController.class);
	@Autowired
	FileScanService fileScanService;

	@PostMapping(value="/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ScanResponse<List<FileScanResponse>> uploadFiles(@RequestParam("files") MultipartFile files) throws IOException
	{
		return new ScanResponse<>(fileScanService.scanFiles(new MultipartFile[]
				{files}));
	}
	@GetMapping("/health")
	public Ping ping()  {
		return fileScanService.ping();
	}
	 
}










