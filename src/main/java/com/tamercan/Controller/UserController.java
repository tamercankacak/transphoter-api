package com.tamercan.Controller;

import com.tamercan.Entity.UserAuthenticate;
import com.tamercan.Repository.UserRepository;
import com.tamercan.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
public class UserController {

    private final UserService userService;


    @PostMapping(value = "/login")
    public ResponseEntity Login(@RequestBody UserAuthenticate userAuthenticate) {
        userService.Login(userAuthenticate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody @Valid UserAuthenticate userAuthenticate) {
        userService.Create(userAuthenticate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity Update(@RequestBody UserAuthenticate userAuthenticate) {
        userService.Update(userAuthenticate.getUsername(), userAuthenticate.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
