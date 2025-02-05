package com.example.Todo.service;

import com.example.Todo.payload.UserIdentityAvailability;
import com.example.Todo.payload.UserSummary;
import com.example.Todo.security.UserPrincipal;

public interface UserService {
    UserSummary getCurrentUser(UserPrincipal currentUser);
    UserIdentityAvailability checkUsernameAvailability(String userName);
}
