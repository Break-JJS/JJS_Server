package com.cse.jjs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disease {

    @Id
    @Column(nullable = false)
    private String diseaseName;
    @Column(length = 1024)
    private String diseaseDescribe;

//    @OneToMany(mappedBy = "disease")
//    private List<UserDisease> userDiseases = new ArrayList<>();
//    @OneToMany(mappedBy = "disease")
//    private List<ElementDisease> elementDiseases = new ArrayList<>();
}
