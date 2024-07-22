package com.eduardocaio.user_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.ProfileDTO;
import com.eduardocaio.user_management.services.ProfileService;

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
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<ProfileDTO> findAll(){
        return profileService.findAll();
    }

    @PostMapping
    public void create(@RequestBody ProfileDTO profile){
        profileService.create(profile);
    }

    @PutMapping
    public ProfileDTO update(@RequestBody ProfileDTO profile){
        return profileService.update(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        profileService.delete(id);
        return ResponseEntity.ok().build();
    }
}
