package pro.cherkassy.rboyko.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.model.Dialed;
import pro.cherkassy.rboyko.repository.interfaces.DialedlistRepository;

import java.util.List;

/**
 * Created by rboyko on 11.04.17.
 */
@Repository
public class DialedlistRepositoryImpl implements DialedlistRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Dialed dial) {
        sessionFactory.getCurrentSession().save(dial);
    }

    @Override
    public void delete(Dialed dial) {
        sessionFactory.getCurrentSession().delete(dial);
    }

    @Override
    public Dialed findById(int id) {
        return sessionFactory.getCurrentSession().get(Dialed.class, id);
    }

    @Override
    public List<Dialed> getAllDial() {
        return sessionFactory.getCurrentSession().createQuery("from Dialed").list();
    }
}
