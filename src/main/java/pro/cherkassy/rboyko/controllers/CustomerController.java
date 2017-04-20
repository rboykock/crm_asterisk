package pro.cherkassy.rboyko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.model.Customer;
import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.service.interfaces.CampaignsService;
import pro.cherkassy.rboyko.service.interfaces.CustomerService;
import pro.cherkassy.rboyko.service.interfaces.DiallistService;


import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DiallistService diallistService;


    @GetMapping
    public ResponseEntity<List> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        customerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (customerService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/campaign/{campaignId}/assigned")
    public ResponseEntity assigned(@PathVariable int campaignId,@RequestBody List<String> phoneNumbers){
        for(String phoneNumber:phoneNumbers){
            Customer customer=customerService.findByNumber(phoneNumber);
            Dial dial=new Dial(customer.getOrganizationName(),customer.getContactPerson(),customer.getPhoneNumber(),(int)customer.getId(),campaignId);
            diallistService.save(dial);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
