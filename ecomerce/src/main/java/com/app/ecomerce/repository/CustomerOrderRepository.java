package com.app.ecomerce.repository;

import com.app.ecomerce.model.Customer;
import com.app.ecomerce.model.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrders,Long> {

    List<CustomerOrders> findByCustomer(Customer customer);
}
