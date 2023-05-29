package com.cse.jjs.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer gender;
    @Column(nullable = false)
    private Double height;
    @Column(nullable = false)
    private Double weight;

//    @OneToMany(mappedBy = "user")
//    private List<UserAllergy> userAllergies = new ArrayList<>();
//    @OneToMany(mappedBy = "user")
//    private List<UserDisease> userDiseases = new ArrayList<>();
}
