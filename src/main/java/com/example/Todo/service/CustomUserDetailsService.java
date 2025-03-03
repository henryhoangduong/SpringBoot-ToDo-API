package com.example.Todo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {
    UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException;
    UserDetails loadUserById(Long id);
}
