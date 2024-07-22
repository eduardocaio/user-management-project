package com.eduardocaio.user_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.ProfileUserDTO;
import com.eduardocaio.user_management.entities.ProfileUserEntity;
import com.eduardocaio.user_management.repositories.ProfileUserRepository;

@Service
public class ProfileUserService {

    @Autowired
    ProfileUserRepository profileUserRepository;

    public List<ProfileUserDTO> findAll(){
        List<ProfileUserEntity> profileUser = profileUserRepository.findAll();
        return profileUser.stream().map(ProfileUserDTO::new).toList();
    }

    public void create(ProfileUserDTO profileUser){
        ProfileUserEntity profileUserEn = new ProfileUserEntity(profileUser);
        profileUserRepository.save(profileUserEn);
    }

    public ProfileUserDTO update(ProfileUserDTO profileUser){
        ProfileUserEntity profileUserEn = new ProfileUserEntity(profileUser);
        return new ProfileUserDTO(profileUserRepository.save(profileUserEn));
    }

    public void delete(Long id){
        ProfileUserEntity profileUser = profileUserRepository.findById(id).get();
        profileUserRepository.delete(profileUser);
    }

    public ProfileUserDTO findById(Long id){
        ProfileUserDTO profileUser = new ProfileUserDTO(profileUserRepository.findById(id).get());
        return profileUser;
    }

}
