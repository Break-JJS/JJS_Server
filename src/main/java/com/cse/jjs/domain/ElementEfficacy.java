package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class ElementEfficacy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementEfficacyId;
    private String body;


    @ManyToOne
    @JoinColumn(name="ELEMENT_ID")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "EFFICACY_ID")
    private Efficacy efficacy;
}
