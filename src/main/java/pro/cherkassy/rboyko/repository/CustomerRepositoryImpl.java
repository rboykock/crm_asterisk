package pro.cherkassy.rboyko.repository;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.cherkassy.rboyko.model.Customer;
import pro.cherkassy.rboyko.repository.interfaces.CustomerRepository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
    }

    @Override
    public Customer findById(long id) {
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
        return customer;
    }

    @Override
    public Customer findByName(String name) {
        return (Customer) sessionFactory.getCurrentSession().createCriteria(Customer.class, name).uniqueResult();
    }

    @Override
    public Customer findByNumber(String phoneNumber) {
        String hql="FROM Customer WHERE phoneNumber=:phoneNumber";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return (Customer)query.setString("phoneNumber",phoneNumber).uniqueResult();
    }

    @Override
    public Customer findByEmail(String email) {
        return (Customer) sessionFactory.getCurrentSession().createCriteria(Customer.class, email).uniqueResult();
    }

    @Override
    public void save(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public void delete(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }
}
