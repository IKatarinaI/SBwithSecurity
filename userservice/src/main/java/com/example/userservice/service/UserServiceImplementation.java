package com.example.userservice.service;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.repo.RoleRepo;
import com.example.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user from database");
        return userRepo.findByUsername(username);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role to the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role to the user and saving it to the database");
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching users from the database");
        return userRepo.findAll();
    }
}
