package com.ednach.miniInfoApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String productName;

    private double cost;
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "products_producers",
            joinColumns = {@JoinColumn(name = "product_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "producer_id")})
    private Set<Producer> producers;

    public Product(Long id) {
        this.id = id;
    }
    public Product() {
    }

    public Product(User user, String productName, double cost, Set<Producer> producers) {
        this.user = user;
        this.productName = productName;
        this.cost = cost;
        this.producers = producers;
    }
}
