package com.example.Todo.service.impl;

import com.example.Todo.model.user.User;
import com.example.Todo.payload.*;
import com.example.Todo.repository.PostRepository;
import com.example.Todo.repository.UserRepository;
import com.example.Todo.security.UserPrincipal;
import com.example.Todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public UserSummary getCurrentUser(UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getFirstName(),
                currentUser.getLastName());
    }

    @Override
    public UserIdentityAvailability checkUsernameAvailability(String username) {
        Boolean isAvailable = !userRepository.existsByUserName(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @Override
    public UserIdentityAvailability checkEmailAvailability(String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @Override
    public UserProfile getUserProfile(String username) {
        User user = userRepository.getUserByName(username);
        Long postCount = postRepository.countByCreatedBy(user.getId());
        return new UserProfile(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(),
                user.getCreatedAt(), user.getEmail(), user.getAddress(), user.getPhone(), user.getWebsite(),
                user.getCompany(), postCount);
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User newUser, String username, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public ApiResponse deleteUser(String username, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public ApiResponse giveAdmin(String username) {
        return null;
    }

    @Override
    public ApiResponse removeAdmin(String username) {
        return null;
    }

    @Override
    public UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest) {
        return null;
    }
}
