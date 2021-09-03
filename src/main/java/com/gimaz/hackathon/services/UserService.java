package com.gimaz.hackathon.services;

import com.gimaz.hackathon.entity.Role;
import com.gimaz.hackathon.entity.User;
import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    void addRoleToUser(String username, String roleName);

    User findById(Long id);

    void delete(Long id);

    Role addRole(Role role);

}
