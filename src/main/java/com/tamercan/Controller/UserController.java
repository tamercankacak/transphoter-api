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
//User controller.It's that doing user create, update and login process.
public class UserController {

    //It contains methods. Using for database process.
    private final UserService userService;

    //Login controller. Requeries username and password. When you send this, it asks the database and returns Http Code
    @PostMapping(value = "/login")
    public ResponseEntity Login(@RequestBody UserAuthenticate userAuthenticate) {
        userService.Login(userAuthenticate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Create controller. It creates user. Requeries username and password.
    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody @Valid UserAuthenticate userAuthenticate) {
        userService.Create(userAuthenticate);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Update controller. It updates user. Requeries username and password.
    @PutMapping(value = "/update")
    public ResponseEntity Update(@RequestBody UserAuthenticate userAuthenticate) {
        userService.Update(userAuthenticate.getUsername(), userAuthenticate.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
