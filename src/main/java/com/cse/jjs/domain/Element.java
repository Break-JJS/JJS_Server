package com.cse.jjs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Element {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementId;
    @Column(nullable = false)
    private String elementName;

    @OneToMany(mappedBy = "element")
    private List<ElementEfficacy> elementEfficacies = new ArrayList<>();
    @OneToMany(mappedBy = "element")
    private List<ElementAllergy> elementAllergies = new ArrayList<>();
    @OneToMany(mappedBy = "element")
    private List<ElementDisease> elementDiseases = new ArrayList<>();
    @OneToMany(mappedBy = "element")
    private List<ElementProduct> elementProducts = new ArrayList<>();
}
