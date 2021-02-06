package com.tamercan.Controller;

import com.tamercan.Entity.Word;
import com.tamercan.Entity.WordCreate;
import com.tamercan.Service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/word")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class WordController {

    private final WordService wordService;

    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody WordCreate wordCreate) {
        wordService.Create(wordCreate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Word> Get(@Param("id") long id) {
        return new ResponseEntity<>(wordService.Get(id), HttpStatus.OK);
    }

}
