package com.wings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wings.wrapper.Product;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    
    @GetMapping
    public String sayHello(){
        return "Welcome to SpringBoot & Spring Cloud & Microservice";
    }

    @GetMapping("/product")
    public Product getOneProduct(){

        Product product = new Product();
        product.setNama("Komputer");
        product.setHarga(10000000);

        return product;
    }


    @GetMapping("/products")
    public List<Product> getAllProduct(){
        
        Product product1 = new Product();
        product1.setNama("Komputer1");
        product1.setHarga(10000000);

        Product product2 = new Product();
        product2.setNama("Komputer2");
        product2.setHarga(10000000);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        return products;
    }

}
