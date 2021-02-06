package com.tamercan.Service;

import com.tamercan.Entity.WordsCreate;
import com.tamercan.Repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsService {

    @Autowired
    WordsRepository wordsRepository;

    public void Create(WordsCreate wordsCreate) {
        if (!wordsRepository.existsByEnglishwordAndTurkishword(wordsCreate.getEnglishword(), wordsCreate.getTurkishword())) {
            wordsRepository.createWords(wordsCreate.getEnglishword(), wordsCreate.getTurkishword());
        } else {
            //throw new UserAlreadyExistException(wor.getUsername());
        }
    }


}
