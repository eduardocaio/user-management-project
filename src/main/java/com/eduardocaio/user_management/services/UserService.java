package com.eduardocaio.user_management.services;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.UserDTO;
import com.eduardocaio.user_management.entities.UserEntity;
import com.eduardocaio.user_management.entities.VerificationUserEntity;
import com.eduardocaio.user_management.entities.enums.StatusUser;
import com.eduardocaio.user_management.repositories.UserRepository;
import com.eduardocaio.user_management.repositories.VerificationUserRepository;

@Service 
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private VerificationUserRepository verificationUserRepository;

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

        VerificationUserEntity verification = new VerificationUserEntity();
        verification.setUser(userEntity);
        verification.setUuid(UUID.randomUUID());
        verification.setExpiration(Instant.now().plusMillis(900000));
        verificationUserRepository.save(verification);

        emailService.sendEmailText(userEntity.getEmail(), "Confirmar email", "Voce está recebendo um email de cadastro. O número para validação é: " + verification.getUuid());
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
