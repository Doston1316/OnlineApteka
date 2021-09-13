package com.example.onlineApteka.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String productName;
    @Column(name = "qator")
    private String productRow;
    @Column(name = "joy")
    private String productPlace;
    @Column(name = "narx")
    private String productPrice;
    @Column(name = "tabletka")
    private String productTabletka;
    @Column(name = "ukol")
    private String productUkol;
}
