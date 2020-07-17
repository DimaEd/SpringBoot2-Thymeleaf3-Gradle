package com.ednach.miniInfoApp.repository;

import com.ednach.miniInfoApp.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    @Query("SELECT DISTINCT p FROM Producer p JOIN FETCH p.products")
    List<Producer> findAll();

    @Query("SELECT DISTINCT p FROM Producer p JOIN FETCH p.products WHERE p.companyName=:companyName")
    List<Producer> findProducerByCompanyName(@Param("companyName") String companyName);

    Producer findByCompanyName(String companyName);

}
