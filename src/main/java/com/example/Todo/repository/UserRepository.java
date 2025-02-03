package com.example.Todo.repository;

import com.example.Todo.model.user.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(@NotBlank String username);
    Optional<User>  findByEmail(@NotBlank String email);
    Boolean existsByUserName(@NotBlank String username);
    Boolean existsByEmail(@NotBlank String email);

}
