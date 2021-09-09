package com.example.prlanguage.repository;

import com.example.prlanguage.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
}
