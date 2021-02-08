package com.tamercan.Service;

import com.tamercan.Entity.UserWord;
import com.tamercan.Repository.UserWordRepository;
import com.tamercan.exception.UserWordAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWordService {

    @Autowired
    UserWordRepository userWordRepository;

    public void Create(UserWord userWord) {
        if (!userWordRepository.existsByUserIdAndWordId(userWord.getUserId(), userWord.getWordId())) {
            userWordRepository.createUserWord(userWord.getUserId(), userWord.getWordId());
        } else {
            throw new UserWordAlreadyExistsException();
        }
    }
}
