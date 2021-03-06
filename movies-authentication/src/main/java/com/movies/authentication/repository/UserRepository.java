package com.movies.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.movies.authentication.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Nullable
    User findUserByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
