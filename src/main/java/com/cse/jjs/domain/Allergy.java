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
public class Allergy {

    @Id
    @Column(nullable = false)
    private String allergyName;

//    @OneToMany(mappedBy = "allergy")
//    private List<UserAllergy> userAllergies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "allergy")
//    private List<ElementAllergy> elementAllergies = new ArrayList<>();
}
