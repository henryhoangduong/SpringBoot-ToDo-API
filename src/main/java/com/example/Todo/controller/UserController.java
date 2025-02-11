package com.example.Todo.controller;

import com.example.Todo.model.Album;
import com.example.Todo.payload.PagedReponse;
import com.example.Todo.payload.UserIdentityAvailability;
import com.example.Todo.payload.UserProfile;
import com.example.Todo.payload.UserSummary;
import com.example.Todo.security.CurrentUser;
import com.example.Todo.security.UserPrincipal;
import com.example.Todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserSummary> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = userService.getCurrentUser(currentUser);

        return new ResponseEntity< >(userSummary, HttpStatus.OK);
    }


    @GetMapping("/checkUsernameAvailability")
    public ResponseEntity<UserIdentityAvailability> checkUsernameAvailability(@RequestParam(value = "username") String username) {
        UserIdentityAvailability userIdentityAvailability = userService.checkUsernameAvailability(username);
        return new ResponseEntity< >(userIdentityAvailability, HttpStatus.OK);
    }

    @GetMapping("checkEmailAvailability")
    public ResponseEntity<UserIdentityAvailability> checkEmailAvailability(@RequestParam(value = "email") String email){
        UserIdentityAvailability userIdentityAvailability = userService.checkEmailAvailability(email);
        return new ResponseEntity< >(userIdentityAvailability, HttpStatus.OK);
    }

    @GetMapping("/{username}/profile")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable(value ="username") String username){
        UserProfile userProfile = userService.getUserProfile(username);
        return new ResponseEntity< >(userProfile, HttpStatus.OK);
    }

}
