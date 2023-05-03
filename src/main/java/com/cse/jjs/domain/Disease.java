package com.cse.jjs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disease {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseId;
    @Column(nullable = false)
    private String diseaseName;
    @Column(length = 1024)
    private String diseaseDescribe;

    @OneToMany(mappedBy = "disease")
    private List<UserDisease> userDiseases = new ArrayList<>();
    @OneToMany(mappedBy = "disease")
    private List<ElementDisease> elementDiseases = new ArrayList<>();
}
