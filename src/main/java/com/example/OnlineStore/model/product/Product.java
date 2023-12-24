package com.example.OnlineStore.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer countInWarehouse;
    private String size;
    private String color;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String advancedOptions;
}
