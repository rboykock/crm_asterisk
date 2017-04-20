package pro.cherkassy.rboyko.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.enums.Role;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.repository.interfaces.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rboyko on 20.03.17.
 */
@Repository
public class UsersRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void delete(User user) {
       sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public boolean contains(User user) {
        return sessionFactory.getCurrentSession().contains(user);
    }


}
