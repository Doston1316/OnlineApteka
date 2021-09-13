package com.example.onlineApteka.service;

import com.example.onlineApteka.model.Product;

import java.util.List;


public interface ProductService {

    List<Product>getAll();

    Product findById(Long id);

    Product updateProduct(Product product);

    void save(Product product);

    void deleteById(Long id);

    List<Product> findByName(String name);



}
