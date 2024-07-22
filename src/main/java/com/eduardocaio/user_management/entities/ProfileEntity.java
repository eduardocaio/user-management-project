package com.eduardocaio.user_management.entities;

import org.springframework.beans.BeanUtils;

import com.eduardocaio.user_management.dto.ProfileDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_profile")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    public ProfileEntity(ProfileDTO profile){
        BeanUtils.copyProperties(profile, this);
    }

}
