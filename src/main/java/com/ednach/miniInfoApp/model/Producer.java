package com.ednach.miniInfoApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String email;
    private String country;

    @ManyToMany(mappedBy = "producers", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Producer() {
    }

    public Producer(Long id) {
        this.id = id;
    }

    public Producer(Long id, String companyName, String email, String country) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.country = country;
    }

}
