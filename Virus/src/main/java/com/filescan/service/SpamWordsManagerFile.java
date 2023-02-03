//package com.filescan.service;
//import com.filescan.dto.SpamWord;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//@Service
//@Getter
//public class SpamWordsManagerFile
//{
//    private final List<SpamWord> spamWords = new ArrayList<>();
//
//    public SpamWordsManagerFile(@Value("${sourceFile}") String filePath){
//        try {
//            Resource resourceLoader = new ClassPathResource(filePath);
//            InputStream words = resourceLoader.getInputStream();
//            Scanner scanner = new Scanner(words).useDelimiter("\\A");
//            String result = scanner.hasNext() ? scanner.next() : "";
//            Arrays.asList(result.split(";")).forEach(
//                    word -> this.spamWords.add(new SpamWord((long) this.spamWords.size(), word))
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<SpamWord> getSpamWords() { return this.spamWords; }
//}
