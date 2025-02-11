package com.example.Todo.payload;

import com.example.Todo.model.user.Address;
import com.example.Todo.model.user.Company;
import lombok.Data;

import java.time.Instant;

@Data
public class UserProfile {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Instant joinedAt;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    private Long postCount;
}
