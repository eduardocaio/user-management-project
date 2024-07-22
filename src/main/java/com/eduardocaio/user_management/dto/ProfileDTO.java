package com.eduardocaio.user_management.dto;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.entities.ProfileEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private Long id;
    private String description;

    public ProfileDTO(ProfileEntity profile){
        BeanUtils.copyProperties(profile, this);
    }

}
