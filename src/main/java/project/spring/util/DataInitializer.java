package project.spring.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import project.spring.model.Role;
import project.spring.model.User;
import project.spring.service.RoleService;
import project.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        User bob = new User();
        bob.setEmail("bob@i.ua");
        bob.setPassword("admin123");
        bob.setRoles(Set.of(adminRole));
        userService.add(bob);

        User alice = new User();
        alice.setEmail("alice@i.ua");
        alice.setPassword("user1234");
        alice.setRoles(Set.of(userRole));
        userService.add(alice);
    }
}
