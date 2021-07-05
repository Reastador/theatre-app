package project.spring.service.impl;

import static org.springframework.security.core.userdetails.User.UserBuilder;
import project.spring.exception.DataProcessingException;
import project.spring.model.User;
import project.spring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.findByEmail(email);
        } catch (DataProcessingException e) {
            throw new UsernameNotFoundException("Can't find user with email " + email, e);
        }
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(user.getPassword());
        builder.authorities(user.getRoles().stream()
                .map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
