package com.cse.jjs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barcode;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String productName;

    @OneToMany(mappedBy = "product")
    private List<ElementProduct> elementProducts = new ArrayList<>();
}
