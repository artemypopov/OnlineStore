package com.example.OnlineStore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateRegistration;
    private String dateReceipt;
    private String status;
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
