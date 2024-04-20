package com.app.ecomerce.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "customerorder")
@Component
public class CustomerOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<OrderQuantity> quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderQuantity> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<OrderQuantity> quantity) {
        this.quantity = quantity;
    }
}
