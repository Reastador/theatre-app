package project.spring.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.spring.dao.UserDao;
import project.spring.exception.DataProcessingException;
import project.spring.model.User;
import project.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserDao userDao;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(
                () -> new DataProcessingException("User with id " + id + " not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("User with email " + email + " not found"));
    }
}
