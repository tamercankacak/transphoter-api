package com.tamercan.Service;

import com.tamercan.Entity.Word;

import com.tamercan.Repository.WordRepository;
import com.tamercan.exception.WordAlreadyExistsException;
import com.tamercan.exception.WordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    WordRepository wordRepository;

    public void Create(Word word) {
        if (!wordRepository.existsByEnglishwordAndTurkishword(word.getEnglishword(), word.getTurkishword())) {
            wordRepository.createWord(word.getEnglishword(), word.getTurkishword());
        } else {
            throw new WordAlreadyExistsException(word.getEnglishword());
        }
    }

    public Word GetById(long id) {

        if (wordRepository.existsById(id)) {
            return wordRepository.findById(id);
        } else {
            throw new WordNotFoundException();
        }
    }

    public Word GetByEnglishWordAndTurkishWord(String englishword, String turkishword) {
        if (wordRepository.existsByEnglishwordAndTurkishword(englishword, turkishword)) {
            return wordRepository.findByEnglishwordAndTurkishword(englishword, turkishword);
        } else {
            throw new WordNotFoundException();
        }
    }


}
