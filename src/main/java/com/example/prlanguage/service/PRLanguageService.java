package com.example.prlanguage.service;

import com.example.prlanguage.model.Dictionary;
import com.example.prlanguage.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRLanguageService {
    @Autowired
    DictionaryRepository repository;

    public void addNewWord(Dictionary dictionary){
        repository.save(dictionary);
    }
    public List<Dictionary> getAllWords(){
        return  repository.findAll();
    }
}
