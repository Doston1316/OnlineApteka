package com.example.onlineApteka.repository;

import com.example.onlineApteka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


      @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%"
              + " OR p.productRow LIKE %?1%"
              + " OR p.productPlace LIKE %?1%"
              + " OR CONCAT(p.productPrice, '') LIKE %?1%")
         List<Product> findByProductName( String productName);
    }


