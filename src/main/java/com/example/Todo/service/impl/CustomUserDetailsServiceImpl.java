package com.example.Todo.service.impl;

import com.example.Todo.model.user.User;
import com.example.Todo.repository.UserRepository;
import com.example.Todo.security.UserPrincipal;
import com.example.Todo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService  {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with this username or email: %s", userNameOrEmail)));
        System.out.println(user);
    return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return null;
    }
}
