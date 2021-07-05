package project.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import project.spring.dao.AbstractDao;
import project.spring.dao.TheatreStageDao;
import project.spring.model.TheatreStage;

@Repository
public class TheatreStageDaoImpl extends AbstractDao<TheatreStage> implements TheatreStageDao {
    public TheatreStageDaoImpl(SessionFactory factory) { super(factory, TheatreStage.class); }
}
