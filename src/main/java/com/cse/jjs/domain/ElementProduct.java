package com.cse.jjs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElementProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
