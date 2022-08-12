package com.example.laurentino.controllers;

import com.example.laurentino.models.User;
import com.example.laurentino.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
public class UserController {
     private UserService userService;
     @GetMapping("/login")
     public String login(){
          return "login";
     }
     @GetMapping("/registration")
     public String registration(){
          return "registration";
     }
     @PostMapping("/registration")
     public String createUser(User user){
          userService.createUser(user);
          return "redirect:/login";
     }
     @GetMapping("/hello")
     public String securityUrl(){
          return "hello";
     }




}
