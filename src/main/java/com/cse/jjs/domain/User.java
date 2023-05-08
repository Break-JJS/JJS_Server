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
    private String userID;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer gender;
    @Column(nullable = false)
    private Double height;
    @Column(nullable = false)
    private Double weight;

    @OneToMany(mappedBy = "user")
    private List<UserAllergy> userAllergies = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserDisease> userDiseases = new ArrayList<>();

    public void setPassWord(String passWord)
    {
        this.passWord=passWord;
    }

    public String getPassWord()
    {
        return this.passWord;
    }
    public String getUserID(){return this.userID;}
}
