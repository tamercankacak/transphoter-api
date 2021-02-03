package com.tamercan.Controller;

import com.tamercan.Entity.User;
import com.tamercan.Entity.UserAuthenticate;
import com.tamercan.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserRepository userRepository;


    @PostMapping(value = "/login")
    public ResponseEntity<?> Login(@RequestBody UserAuthenticate userAuthenticate) {

        boolean result = userRepository.existsByUsernameAndPassword(userAuthenticate.getUsername(), userAuthenticate.getPassword());

        if (result == false)
            return  new ResponseEntity<>("notfound",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("ok",HttpStatus.OK);

    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> Create(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
