package com.tucker.securitydemo.controller;

import com.tucker.securitydemo.entity.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String folder = "E:\\WorkSpace\\springsecurity01\\security-demo\\src\\main\\java\\com\\tucker\\securitydemo\\controller";

        File localFile = new File(folder,new Date().getTime()+".text");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

}
