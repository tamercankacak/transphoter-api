package com.tamercan.Service;

import com.tamercan.Entity.User;
import com.tamercan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void update(String username, String password){
        User user = userRepository.findByUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

}
