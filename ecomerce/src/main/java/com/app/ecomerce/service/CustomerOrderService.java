package com.app.ecomerce.service;

import com.app.ecomerce.model.Customer;
import com.app.ecomerce.model.CustomerOrders;
import com.app.ecomerce.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public List<CustomerOrders> getOrderes(Customer customer){
        return customerOrderRepository.findByCustomer(customer);
    }
}
