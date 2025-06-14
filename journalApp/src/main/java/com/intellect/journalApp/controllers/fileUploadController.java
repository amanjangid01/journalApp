//package com.intellect.journalApp.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.http.HttpResponse;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//@RestController
//public class fileUploadController {
//
//    @PostMapping("/file")
//    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) throws IOException {
//        String fileName= file.getName();
//
//
//        try{
//
//            System.out.println(fileName);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
