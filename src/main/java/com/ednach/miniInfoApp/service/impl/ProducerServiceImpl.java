package com.ednach.miniInfoApp.service.impl;

import com.ednach.miniInfoApp.model.Producer;
import com.ednach.miniInfoApp.repository.ProducerRepository;
import com.ednach.miniInfoApp.service.ProducerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {
    private ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producer findByCompanyName(String companyName) {
        return producerRepository.findByCompanyName(companyName);
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Producer findById(Long id) {
        return producerRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Producer> findProducerByCompanyName(String companyName) {
        return producerRepository.findProducerByCompanyName(companyName);
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.saveAndFlush(producer);
    }

    @Override
    public Producer update(Producer producer) {
        final Long id = producer.getId();
        findById(id);
        return producerRepository.saveAndFlush(producer);
    }

    @Override
    public void delete(Producer producer) {
        final Long id = producer.getId();
        findById(id);
        producerRepository.delete(producer);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        producerRepository.deleteById(id);

    }
}
