package com.cse.jjs.domain;

import javax.persistence.*;

@Entity
public class UserDisease {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDiseaseId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="DISEASE_ID")
    private Disease disease;
}
