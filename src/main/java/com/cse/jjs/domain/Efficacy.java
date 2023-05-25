package com.cse.jjs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Efficacy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long efficacyId;
    @Column(nullable = false)
    private int action;
    @Column(nullable = false)
    private String efficacyName;

    @OneToMany(mappedBy = "efficacy")
    private List<ElementEfficacy> elementEfficacies = new ArrayList<>();
}
