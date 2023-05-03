package com.cse.jjs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Efficacy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long efficacyId;
    @Column(nullable = false)
    private int action;
    @Column(nullable = false)
    private String efficacyName;

    @OneToMany(mappedBy = "efficacy")
    private List<ElementEfficacy> elementEfficacies = new ArrayList<>();
}
