package com.eduardocaio.user_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.ProfileDTO;
import com.eduardocaio.user_management.entities.ProfileEntity;
import com.eduardocaio.user_management.repositories.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<ProfileDTO> findAll(){
        List<ProfileEntity> profiles = profileRepository.findAll();
        return profiles.stream().map(ProfileDTO::new).toList();
    }

    public void create(ProfileDTO profile){
        ProfileEntity profileEn = new ProfileEntity(profile);
        profileRepository.save(profileEn);
    }

    public ProfileDTO update(ProfileDTO profile){
        ProfileEntity profileEn = new ProfileEntity(profile);
        return new ProfileDTO(profileRepository.save(profileEn));
    }

    public void delete(Long id){
        ProfileEntity profile = profileRepository.findById(id).get();
        profileRepository.delete(profile);
    }

    public ProfileDTO findById(Long id){
        ProfileDTO profile = new ProfileDTO(profileRepository.findById(id).get());
        return profile;
    }

}
