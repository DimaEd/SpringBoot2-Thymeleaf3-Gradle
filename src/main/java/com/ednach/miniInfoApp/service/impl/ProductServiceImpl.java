package com.ednach.miniInfoApp.service.impl;

import com.ednach.miniInfoApp.model.Product;
import com.ednach.miniInfoApp.repository.ProductRepository;
import com.ednach.miniInfoApp.service.ProducerService;
import com.ednach.miniInfoApp.service.ProductService;
import com.ednach.miniInfoApp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private UserService userService;
    private ProductRepository productRepository;
    private ProducerService producerService;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, ProducerService producerService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.producerService = producerService;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Product findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }


    @Override
    public Product save(Product product) {
        return saveAndFlush(product);
    }

    @Override
    public Product update(Product product) {
        final Long id = product.getId();
        findById(id);
        return saveAndFlush(product);
    }

    @Override
    public void delete(Product product) {
        final Long id = product.getId();
        deleteById(id);
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    private Product saveAndFlush(Product product) {
        product.setUser(userService.findById(product.getUser().getId()));
        product.getProducers().forEach(producer -> {
            producer.setCompanyName(producerService.findById(producer.getId()).getCompanyName());
            producer.setEmail(producerService.findById(producer.getId()).getEmail());
            producer.setCountry(producerService.findById(producer.getId()).getCountry());
        });

        return productRepository.saveAndFlush(product);
    }
}
