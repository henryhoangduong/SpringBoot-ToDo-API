package com.example.Todo.model.user;

import com.example.Todo.model.audit.DateAudit;
import com.example.Todo.model.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})

public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column
    @Getter
    @Setter
    private String firstName;
    @Column
    @Getter
    @Setter
    private String userName;
    @Column
    @Getter
    @Setter
    private String lastName;
    @Column
    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column
    @Getter
    @Setter
    private String email;
    @Column
    @Getter
    @Setter
    private Address address;

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


    public User(String firstName, String userName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.userName = userName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }




}
