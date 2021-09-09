package com.example.prlanguage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pamirWord;
    private String rusEquivalent;
    private String wordImage;

}
