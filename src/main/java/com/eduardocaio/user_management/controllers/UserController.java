package com.eduardocaio.user_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.UserDTO;
import com.eduardocaio.user_management.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void create(@RequestBody UserDTO user){
        userService.create(user);
    } 

    @PutMapping
    public UserDTO update (@RequestBody UserDTO user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
