package com.example.onlineApteka.service;

import com.example.onlineApteka.model.Product;
import com.example.onlineApteka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  {
    @Autowired
    private ProductRepository productRepository;



    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }


    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }



    public void save(Product product) {
        this.productRepository.save(product);
    }


    public void deleteById(Long id) {
    productRepository.deleteById(id);
    }

    public List<Product> listAll(String productName) {
        if (productName != null) {
            return productRepository.findByProductName(productName);
        }
        return productRepository.findAll();
    }



}
