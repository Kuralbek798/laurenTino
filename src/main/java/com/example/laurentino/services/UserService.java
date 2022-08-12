package com.example.laurentino.services;

import com.example.laurentino.models.User;
import com.example.laurentino.models.enums.Role;
import com.example.laurentino.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

@Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null){
            return false;
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email:{}", email);
        userRepository.save(user);
            return true;


    }
}
