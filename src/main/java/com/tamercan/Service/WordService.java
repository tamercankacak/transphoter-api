package com.tamercan.Service;

import com.tamercan.Entity.Word;

import com.tamercan.Entity.WordCreate;
import com.tamercan.Repository.WordRepository;
import com.tamercan.exception.WordAlreadyExistsException;
import com.tamercan.exception.WordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    WordRepository wordRepository;

    public void Create(WordCreate wordCreate) {
        if (!wordRepository.existsByEnglishwordAndTurkishword(wordCreate.getEnglishword(), wordCreate.getTurkishword())) {
            wordRepository.createWord(wordCreate.getEnglishword(), wordCreate.getTurkishword());
        } else {
            throw new WordAlreadyExistsException(wordCreate.getEnglishword());
        }
    }

    public Word Get(long id) {

        if (wordRepository.existsById(id)) {
            return wordRepository.findById(id);
        } else {
            throw new WordNotFoundException();
        }
    }


}
