package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class UserAllergy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAllergyId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="ALLERGY_ID")
    private Allergy allergy;
}
