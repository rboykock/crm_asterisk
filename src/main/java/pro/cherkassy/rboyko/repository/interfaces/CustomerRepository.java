package pro.cherkassy.rboyko.repository.interfaces;



import pro.cherkassy.rboyko.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(long id);
    Customer findByName(String name);
    Customer findByNumber(String number);
    Customer findByEmail(String email);
    void save(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);


}
