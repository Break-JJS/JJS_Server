package com.cse.jjs.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String userID;
    private String passWord;
    private String name;
    private Integer gender;
    private Double height;
    private Double weight;


}
