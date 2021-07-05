package project.spring.service;

import project.spring.model.PerformanceSession;
import project.spring.model.ShoppingCart;
import project.spring.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
