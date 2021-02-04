package com.tamercan.Controller;

import com.tamercan.Entity.User;
import com.tamercan.Entity.UserAuthenticate;
import com.tamercan.Repository.UserRepository;
import com.tamercan.Service.UserService;
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
    private final UserService userService;


    @PostMapping(value = "/login")
    public ResponseEntity Login(@RequestBody UserAuthenticate userAuthenticate) {

        if (userRepository.existsByUsernameAndPassword(userAuthenticate.getUsername(), userAuthenticate.getPassword()))
            return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);

    }

    @PostMapping(value = "/create")
    public ResponseEntity Create(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return ResponseEntity.ok(HttpStatus.IM_USED);
        userRepository.save(user);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity Update(@RequestBody UserAuthenticate userAuthenticate) {
        if (userRepository.existsByUsername(userAuthenticate.getUsername())) {
            userService.update(userAuthenticate.getUsername(),userAuthenticate.getPassword());
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

}
