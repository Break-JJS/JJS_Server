package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class ElementAllergy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementAllergyId;

    @ManyToOne
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "ALLERGY_ID")
    private Allergy allergy;
}
