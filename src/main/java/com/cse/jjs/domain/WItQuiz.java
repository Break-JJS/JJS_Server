package com.cse.jjs.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class WItQuiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long witId;
    @Column(nullable = false)
    private String witQuiz;
    @Column(nullable = false, length = 1024)
    private String witContent;
    private String iconURL1;
    private String iconURL2;
    private String iconURL3;
    @Column(nullable = false)
    private int question;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private int answer;
    @CreatedDate
    private LocalDateTime date;
}
