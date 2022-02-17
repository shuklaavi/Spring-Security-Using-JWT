package com.example.controllers;

import com.example.models.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/admin")
public class AdminController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/adminuser")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User> userAccess(Principal principal) {
        String name = principal.getName();
        Optional<User> user = repository.findByUsername(name);
        return user;
    }
}
