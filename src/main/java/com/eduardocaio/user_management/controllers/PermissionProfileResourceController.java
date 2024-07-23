package com.eduardocaio.user_management.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.eduardocaio.user_management.dto.PermissionProfileResourceDTO;
import com.eduardocaio.user_management.services.PermissionProfileResourceService;

@RestController
@RequestMapping(value = "/permissions")
@CrossOrigin
public class PermissionProfileResourceController {

    @Autowired
    PermissionProfileResourceService permissionService;

    @GetMapping
    public List<PermissionProfileResourceDTO> findAll(){
        return permissionService.findAll();
    }

    @PostMapping
    public void create(@RequestBody PermissionProfileResourceDTO permission){
        permissionService.create(permission);
    }

    @PutMapping
    public PermissionProfileResourceDTO update(@RequestBody PermissionProfileResourceDTO permission){
        return permissionService.update(permission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        permissionService.delete(id);
        return ResponseEntity.ok().build();
    }


}
