package com.example.userservice.service;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    List<User> getUsers();
}
