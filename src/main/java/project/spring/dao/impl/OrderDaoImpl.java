package project.spring.dao.impl;

import java.util.List;
import project.spring.dao.AbstractDao;
import project.spring.dao.OrderDao;
import project.spring.exception.DataProcessingException;
import project.spring.model.Order;
import project.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory factory) {
        super(factory, Order.class);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = factory.openSession()) {
            Query<Order> getByUser = session.createQuery(
                    "SELECT DISTINCT o FROM orders o "
                            + "join fetch o.tickets t "
                            + "left join fetch t.performanceSession ps "
                            + "left join fetch ps.theatreStage "
                            + "left join fetch ps.performance "
                            + "WHERE o.user = :user", Order.class);
            getByUser.setParameter("user", user);
            return getByUser.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Not found shopping cart for user " + user, e);
        }
    }
}
