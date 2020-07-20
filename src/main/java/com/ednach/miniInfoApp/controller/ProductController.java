package com.ednach.miniInfoApp.controller;


import com.ednach.miniInfoApp.service.ProducerService;
import com.ednach.miniInfoApp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private ProducerService producerService;

    public ProductController(ProductService productService, ProducerService producerService) {
        this.productService = productService;
        this.producerService = producerService;
    }
}
