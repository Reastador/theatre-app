package project.spring.dao.impl;

import java.util.Optional;
import project.spring.dao.AbstractDao;
import project.spring.dao.RoleDao;
import project.spring.exception.DataProcessingException;
import project.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role r "
                    + "WHERE r.roleName = :roleName", Role.class)
                    .setParameter("roleName", Role.RoleName.valueOf(roleName))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role. Role: " + roleName, e);
        }
    }
}
