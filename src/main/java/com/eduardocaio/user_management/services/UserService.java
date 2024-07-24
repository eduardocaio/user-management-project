package com.eduardocaio.user_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.UserDTO;
import com.eduardocaio.user_management.entities.UserEntity;
import com.eduardocaio.user_management.entities.enums.StatusUser;
import com.eduardocaio.user_management.repositories.UserRepository;

@Service 
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    EmailService emailService;

    public List<UserDTO> findAll(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public void create(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    public void signUp(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setStatus(StatusUser.PENDENTE);
        userEntity.setId(null);
        userRepository.save(userEntity);

        emailService.sendEmailText(userEntity.getEmail(), "Confirmar email", "Voce está recebendo um email de cadastro");
    }

    public UserDTO update(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(Long id){
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public UserDTO findById(Long id){
        return new UserDTO(userRepository.findById(id).get());
    }
}
