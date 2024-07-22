package com.eduardocaio.user_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.ResourceDTO;
import com.eduardocaio.user_management.entities.ResourceEntity;
import com.eduardocaio.user_management.repositories.ResourceRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceDTO> findAll(){
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    public void create(ResourceDTO res){
        ResourceEntity resEn = new ResourceEntity(res);
        resourceRepository.save(resEn);
    }

    public ResourceDTO update(ResourceDTO res){
        ResourceEntity resEn = new ResourceEntity(res);
        return new ResourceDTO(resourceRepository.save(resEn));
    }

    public void delete(Long id){
        ResourceEntity resource = resourceRepository.findById(id).get();
        resourceRepository.delete(resource);
    }

    public ResourceDTO findById(Long id){
        ResourceDTO resource = new ResourceDTO(resourceRepository.findById(id).get());
        return resource;
    }

}
