package com.example.Todo.service;

import com.example.Todo.model.user.User;
import com.example.Todo.payload.*;
import com.example.Todo.security.UserPrincipal;

public interface UserService {
    UserSummary getCurrentUser(UserPrincipal currentUser);
    UserIdentityAvailability checkUsernameAvailability(String userName);
    UserIdentityAvailability checkEmailAvailability(String email);
    UserProfile getUserProfile(String username);
    User addUser(User user);
    User updateUser(User newUser, String username, UserPrincipal currentUser);
    ApiResponse deleteUser(String username, UserPrincipal currentUser);
    ApiResponse giveAdmin(String username);
    ApiResponse removeAdmin(String username);
    UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}
