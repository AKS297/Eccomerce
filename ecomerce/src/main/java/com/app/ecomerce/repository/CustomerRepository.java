package com.app.ecomerce.repository;

import com.app.ecomerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUserName(String userName);
    Optional<Customer> findCustomerByEmail(String email);
}
