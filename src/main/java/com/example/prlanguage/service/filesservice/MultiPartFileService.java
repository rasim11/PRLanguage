package com.example.prlanguage.service.filesservice;

import com.example.prlanguage.model.Dictionary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MultiPartFileService {

    public boolean imageVerification(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            return true;
        }
        return false;
    }
    public void saveImage(String fileName,MultipartFile multipartFile){

        System.out.println("Название файла: " + fileName);
        String uploadDir = "src/main/media/img/";
        Path fileAndPath = Paths.get(uploadDir, fileName);
        if (!Files.exists(fileAndPath)) {
            try {
                Files.write(fileAndPath, multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void audioVerification(){

    }

}
