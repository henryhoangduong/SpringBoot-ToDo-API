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

    public UserProfile() {
    }

    public UserProfile(Long id, String username, String firstName, String lastName, Instant joinedAt, String email, Address address, String phone, String website, Company company, Long postCount) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedAt = joinedAt;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
        this.postCount = postCount;
    }
}
