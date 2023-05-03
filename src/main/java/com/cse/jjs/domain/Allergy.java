package com.cse.jjs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Allergy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allergyId;
    @Column(nullable = false)
    private String allergyName;

    @OneToMany(mappedBy = "allergy")
    private List<UserAllergy> userAllergies = new ArrayList<>();

    @OneToMany(mappedBy = "allergy")
    private List<ElementAllergy> elementAllergies = new ArrayList<>();
}
