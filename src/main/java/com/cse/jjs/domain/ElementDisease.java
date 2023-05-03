package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class ElementDisease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementDiseaseId;
    private int action;

    @ManyToOne
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "DISEASE_ID")
    private Disease disease;
}
