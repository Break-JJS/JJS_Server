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
public class ElementAllergy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementAllergyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELEMENT_ID")
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALLERGY_ID")
    private Allergy allergy;
}
