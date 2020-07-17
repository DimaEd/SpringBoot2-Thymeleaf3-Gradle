package com.ednach.miniInfoApp.service;

import com.ednach.miniInfoApp.model.Producer;

import java.util.List;

public interface ProducerService {
    List<Producer> findAll();

    List<Producer> findProducerByCompanyName(String companyName);

    Producer findByCompanyName(String companyName);

    Producer findById(Long id);

    Producer save(Producer producer);

    Producer update(Producer producer);

    void delete(Producer producer);

    void deleteById(Long id);
}
