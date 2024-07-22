package com.eduardocaio.user_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.ProfileUserDTO;
import com.eduardocaio.user_management.services.ProfileUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/profile-user")
@CrossOrigin
public class ProfileUserController {

    @Autowired
    ProfileUserService profileUserService;

    @GetMapping
    public List<ProfileUserDTO> findAll(){
        return profileUserService.findAll();
    }

    @PostMapping
    public void create(@RequestBody ProfileUserDTO profileUser){
        profileUserService.create(profileUser);
    }

    @PutMapping
    public ProfileUserDTO update(@RequestBody ProfileUserDTO profileUser){
        return profileUserService.update(profileUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        profileUserService.delete(id);
        return ResponseEntity.ok().build();
    }
}
