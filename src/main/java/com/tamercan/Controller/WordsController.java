package com.tamercan.Controller;

import com.tamercan.Entity.UserAuthenticate;
import com.tamercan.Entity.Words;
import com.tamercan.Entity.WordsCreate;
import com.tamercan.Repository.UserRepository;
import com.tamercan.Repository.WordsRepository;
import com.tamercan.Service.UserService;
import com.tamercan.Service.WordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/words")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class WordsController {

    private final WordsRepository wordsRepository;
    private final WordsService wordsService;

    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody WordsCreate wordsCreate) {
        wordsService.Create(wordsCreate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
