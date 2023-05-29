package com.cse.jjs.element;

import com.cse.jjs.domain.Efficacy;
import com.cse.jjs.domain.Element;
import lombok.Data;

import java.util.List;

@Data
public class ElementEfficacyDTO {
    private Element element;
    private List<Efficacy> efficacies;
}
