package com.app.ecomerce.service;

import com.app.ecomerce.api.model.RegistrationBody;
import com.app.ecomerce.model.Customer;
import com.app.ecomerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
   @Autowired
    private Customer customer;
    public Customer registerUser(RegistrationBody registrationBody){
        customer.setEmail(registrationBody.getEmail());
        customer.setUserName(registrationBody.getUserName());
        customer.setFirstName(registrationBody.getFirstName());
        customer.setLastName(registrationBody.getLastName());
        customer.setPassword(registrationBody.getPassword());


        return customerRepository.save(customer);
    }
}
