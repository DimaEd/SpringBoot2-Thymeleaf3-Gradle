package com.ednach.miniInfoApp.repository;

import com.ednach.miniInfoApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ProductRepository provides the necessary search operations
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.producers")
    List<Product> findAll();

    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.producers WHERE p.productName=:productName")
    Product findByProductName(@Param("productName") String productName);

}
