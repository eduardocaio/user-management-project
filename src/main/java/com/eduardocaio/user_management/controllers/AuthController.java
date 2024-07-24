package com.eduardocaio.user_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.AuthenticationDTO;
import com.eduardocaio.user_management.dto.UserDTO;
import com.eduardocaio.user_management.services.AuthenticationService;
import com.eduardocaio.user_management.services.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authentication){
        return ResponseEntity.ok(authenticationService.login(authentication));
        
    }

    @PostMapping(value = "/signup")
    public void signUp(@RequestBody UserDTO newUser){
            userService.signUp(newUser);
    }

    @GetMapping(value = "/verifyRegister/{uuid}")
    public String verifyRegister(@PathVariable("uuid") String uuid){
        userService.verifyRegister(uuid);
        return null;
    }

}
