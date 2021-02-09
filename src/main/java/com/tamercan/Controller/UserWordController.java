package com.tamercan.Controller;

import com.tamercan.Entity.UserWord;
import com.tamercan.Service.UserWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userword")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
//UserWord controller.It's that connecting word and user process.
public class UserWordController {

    //It contains methods. Using for database process.
    private final UserWordService userWordService;

    //Create controller. It creates userword with user reference an word reference. Requeries wordId and wordId.
    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody UserWord userWord) {
        userWordService.Create(userWord);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
