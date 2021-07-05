package project.spring.service.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import project.spring.model.Role;
import project.spring.model.User;
import project.spring.service.AuthenticationService;
import project.spring.service.RoleService;
import project.spring.service.ShoppingCartService;
import project.spring.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.USER.name())));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
