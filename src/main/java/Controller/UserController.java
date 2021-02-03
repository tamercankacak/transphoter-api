package Controller;

import Entity.User;
import Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserRepository userRepository;

    @GetMapping(value = "check")
    public ResponseEntity<String> checklogin(@RequestParam String username, @RequestParam String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user == null)
            return new ResponseEntity<>("Login Failed", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Login Success", HttpStatus.OK);

    }

}
