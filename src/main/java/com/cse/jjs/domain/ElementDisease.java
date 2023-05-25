package com.cse.jjs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElementDisease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementDiseaseId;
    private int action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISEASE_ID")
    private Disease disease;
}
