package com.eduardocaio.user_management.entities;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.dto.ProfileUserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_profile_user")
@Getter
@Setter
@NoArgsConstructor
public class ProfileUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private ProfileEntity profile;

    public ProfileUserEntity(ProfileUserDTO profileUser) {
        BeanUtils.copyProperties(profileUser, this);
        if (profileUser != null && profileUser.getUser() != null) {
            this.user = new UserEntity(profileUser.getUser());
        }
        if (profileUser != null && profileUser.getProfile() != null) {
            this.profile = new ProfileEntity(profileUser.getProfile());
        }
    }

}
