package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class ElementProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementProductId;

    @ManyToOne
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
