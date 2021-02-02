package Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> checklogin() {
       return new ResponseEntity<>("Başarılı.",HttpStatus.OK);
    }

}
