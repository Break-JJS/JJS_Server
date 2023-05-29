package com.cse.jjs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barcode;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String productName;

//    @OneToMany(mappedBy = "product")
//    private List<ElementProduct> elementProducts = new ArrayList<>();
}
