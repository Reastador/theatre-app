package project.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import project.spring.dao.AbstractDao;
import project.spring.dao.PerformanceDao;
import project.spring.model.Performance;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
