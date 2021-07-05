package project.spring.service;

import project.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
