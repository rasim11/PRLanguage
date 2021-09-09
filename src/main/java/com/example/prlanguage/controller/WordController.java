package com.example.prlanguage.controller;

import com.example.prlanguage.model.Dictionary;
import com.example.prlanguage.service.PRLanguageService;
import com.example.prlanguage.service.filesservice.MultiPartFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Controller
@Slf4j
public class WordController {
    @Autowired
    PRLanguageService prLanguageService;
    @Autowired
    MultiPartFileService multiPartFileService;
    @GetMapping("/add-new-word-form")
    public String addWordForm(){
        log.info("it works");
        return "add-new-word";
    }
    @PostMapping("/add-new-word")
    public void addNewWord(@ModelAttribute("dictionaryData")Dictionary dictionary,
                           @RequestParam("image") MultipartFile multipartFile){
//        try (InputStream in = url.openStream();
//             ReadableByteChannel rbc = Channels.newChannel(in);
//             FileOutputStream fos = new FileOutputStream(dictionary.getRusEquivalent()+".wav")) {
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Audio: "+audio.getOriginalFilename());
        if(multiPartFileService.imageVerification(multipartFile)){
            String fileName = dictionary.getPamirWord() + "_" + multipartFile.getOriginalFilename().trim();
            multiPartFileService.saveImage(fileName,multipartFile);
            dictionary.setWordImage(fileName);
        }
        prLanguageService.addNewWord(dictionary);
    }
    @GetMapping("/get-all-words")
    public String getAllWords(Model model){
        model.addAttribute("words",prLanguageService.getAllWords());
        return "print-words";
    }
}
