package com.tamercan.Controller;

import com.tamercan.Entity.Word;
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
//Word controller.It's that connecting word and user process.
public class WordController {

    //It contains methods. Using for database process.
    private final WordService wordService;

    //Create controller. It creates word. Requeries englishword and turkishword.
    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody Word word) {
        wordService.Create(word);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Get controller. It getting english and turkish word. Requeries word id.
    @GetMapping(value = "/get")
    public ResponseEntity<Word> GetById(@Param("id") long id) {
        return new ResponseEntity<>(wordService.GetById(id), HttpStatus.OK);
    }

    //Get controller. It getting english and turkish word, We're using for getting id. Requeries english and turkish word.
    @GetMapping(value = "/getByWords")
    public ResponseEntity<Word> GetByWords(@Param("englishword") String englishword,@Param("turkishword") String turkishword) {
        return new ResponseEntity<>(wordService.GetByEnglishWordAndTurkishWord(englishword,turkishword), HttpStatus.OK);
    }

}
