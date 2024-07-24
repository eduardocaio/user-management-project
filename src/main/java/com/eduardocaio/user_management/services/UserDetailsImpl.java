package com.eduardocaio.user_management.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eduardocaio.user_management.entities.UserEntity;

public class UserDetailsImpl implements UserDetails{

    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;

    

    public UserDetailsImpl(Long id, String name, String username, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
                super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.authorities = authorities;
        this.password = password;
    }

    public static UserDetailsImpl build(UserEntity user){
        return new UserDetailsImpl(user.getId(), user.getName(), user.getLogin(), user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
