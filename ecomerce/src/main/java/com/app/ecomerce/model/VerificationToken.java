package com.app.ecomerce.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="verification_token")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "token",nullable = false)
    private String token;

    @Column(name = "time_stamp",nullable = false)
    private Timestamp timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }
}
