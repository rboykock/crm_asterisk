package pro.cherkassy.rboyko.service.interfaces;



import pro.cherkassy.rboyko.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(long id);
    Customer findByName(String name);
    Customer findByNumber(String number);
    Customer findByEmail(String email);
    void save(Customer customer);
    boolean delete(int id);
    void update(Customer customer);

}
