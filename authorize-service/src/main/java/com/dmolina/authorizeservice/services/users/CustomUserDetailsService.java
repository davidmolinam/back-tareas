package com.dmolina.authorizeservice.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityService userEntityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityService.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username + " no encontrado"));
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        return userEntityService.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario con ID: " + id + " no encontrado"));

    }

}