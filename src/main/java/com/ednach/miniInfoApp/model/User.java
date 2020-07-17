package com.ednach.miniInfoApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Product> products;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", email='" + email + '\'' +
                '}';
    }
}
