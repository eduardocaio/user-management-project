package com.eduardocaio.user_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.PermissionProfileResourceDTO;
import com.eduardocaio.user_management.entities.PermissionProfileResourceEntity;
import com.eduardocaio.user_management.repositories.PermissionProfileResourceRepository;

@Service
public class PermissionProfileResourceService {

    @Autowired
    PermissionProfileResourceRepository permissionRepository;

    public List<PermissionProfileResourceDTO> findAll(){
        List<PermissionProfileResourceEntity> permission = permissionRepository.findAll();
        return permission.stream().map(PermissionProfileResourceDTO::new).toList();
    }

    public void create(PermissionProfileResourceDTO permission){
        PermissionProfileResourceEntity permissionEn = new PermissionProfileResourceEntity(permission);
        permissionRepository.save(permissionEn);
    }

    public PermissionProfileResourceDTO update(PermissionProfileResourceDTO permission){
        PermissionProfileResourceEntity permissionEn = new PermissionProfileResourceEntity(permission);
        return new PermissionProfileResourceDTO(permissionRepository.save(permissionEn));
    }

    public void delete(Long id){
        PermissionProfileResourceEntity permission = permissionRepository.findById(id).get();
        permissionRepository.delete(permission);
    }

    public PermissionProfileResourceDTO findById(Long id){
        PermissionProfileResourceDTO permission = new PermissionProfileResourceDTO(permissionRepository.findById(id).get());
        return permission;
    }

}
