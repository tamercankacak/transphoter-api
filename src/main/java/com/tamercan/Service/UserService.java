package com.tamercan.Service;

import com.tamercan.Entity.UserAuthenticate;
import com.tamercan.Repository.UserRepository;
import com.tamercan.exception.AuthenticateException;
import com.tamercan.exception.UserAlreadyExistsException;
import com.tamercan.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void Login(UserAuthenticate userAuthenticate) {
        if (userRepository.existsByUsernameAndPassword(userAuthenticate.getUsername(), userAuthenticate.getPassword())) {

        } else {
            throw new AuthenticateException();
        }
    }

    public void Update(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            userRepository.updatePasswordByUsername(username, password);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public void Create(UserAuthenticate userAuthenticate) {
        if (!userRepository.existsByUsername(userAuthenticate.getUsername())) {
            userRepository.createUser(userAuthenticate.getUsername(), userAuthenticate.getPassword());
        } else {
            throw new UserAlreadyExistsException(userAuthenticate.getUsername());
        }
    }

}
