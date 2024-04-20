package com.app.ecomerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderquantity")
public class OrderQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name="order_id",nullable = false)
    private CustomerOrders orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CustomerOrders getOrders() {
        return orders;
    }

    public void setOrders(CustomerOrders orders) {
        this.orders = orders;
    }
}
