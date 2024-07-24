package com.eduardocaio.user_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.eduardocaio.user_management.dto.AcessDTO;
import com.eduardocaio.user_management.dto.AuthenticationDTO;
import com.eduardocaio.user_management.security.jwt.JwtUtils;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDTO){

        try{
        //Cria mecanismo de credencial para o spring
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

        //Prepara mecanismo para autenticacao
        Authentication authentication = authenticationManager.authenticate(userAuth);

        //Busca usuario logado
        UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
        
        String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

        AcessDTO acess = new AcessDTO(token);

        return acess;

        }catch(BadCredentialsException e){

        }
        return null;
    }

}
