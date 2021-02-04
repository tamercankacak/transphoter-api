package com.tamercan.Service;

import com.tamercan.Entity.User;
import com.tamercan.Repository.UserRepository;
import com.tamercan.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void Update(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            userRepository.updatePasswordByUsername(username, password);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public void Create(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            userRepository.createUser(user.getUsername(),user.getPassword());
        } else {
            throw new UserNotFoundException(user.getUsername());
        }
    }

}
