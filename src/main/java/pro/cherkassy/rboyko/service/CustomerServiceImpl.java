package pro.cherkassy.rboyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.cherkassy.rboyko.model.Customer;
import pro.cherkassy.rboyko.repository.interfaces.CustomerRepository;
import pro.cherkassy.rboyko.service.interfaces.CustomerService;


import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer findByNumber(String number) {
        return customerRepository.findByNumber(number);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean delete(int id) {
        Customer customer=customerRepository.findById(id);
        if(customer!=null){
            customerRepository.delete(customer);
            return true;
        }
        return false;
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }
}
