package project.spring.dao;

import java.util.Optional;
import project.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
