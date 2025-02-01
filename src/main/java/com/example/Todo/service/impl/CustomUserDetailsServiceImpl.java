package com.example.Todo.service.impl;

import com.example.Todo.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService  {
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return null;
    }
}
