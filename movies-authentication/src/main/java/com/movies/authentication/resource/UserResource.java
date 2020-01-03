package com.movies.authentication.resource;

import com.movies.authentication.dto.SignUpRequest;
import com.movies.authentication.entity.User;
import com.movies.authentication.response.JwtAuthenticationResponse;
import com.movies.authentication.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> createUser(@Valid @RequestBody SignUpRequest userRequest) {
        User newUser = userService.createUser(userRequest);
        return ResponseEntity.ok(newUser);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> signInUser(@Valid @RequestBody SignUpRequest userRequest) {
        JwtAuthenticationResponse response = userService.signInUser(userRequest);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User deleteUser = userService.removeUser(id);
        return ResponseEntity.ok(deleteUser);
    }
}
