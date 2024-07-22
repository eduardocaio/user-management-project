package com.eduardocaio.user_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.ResourceDTO;
import com.eduardocaio.user_management.services.ResourceService;

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
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> findAll(){
        return resourceService.findAll();
    }

    @PostMapping
    public void create(@RequestBody ResourceDTO resource){
        resourceService.create(resource);
    }

    @PutMapping
    public ResourceDTO update(@RequestBody ResourceDTO resource){
        return resourceService.update(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        resourceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
