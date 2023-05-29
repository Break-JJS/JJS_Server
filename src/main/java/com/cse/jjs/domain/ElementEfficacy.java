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
public class ElementEfficacy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementEfficacyId;
    private Integer action; //이름 action으로 교체할 예정


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ELEMENT_ID")
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EFFICACY_ID")
    private Efficacy efficacy;
}
