package com.cse.jjs.element;

import com.cse.jjs.domain.Disease;
import com.cse.jjs.domain.Element;
import lombok.Data;

import java.util.List;

@Data
public class ElementDiseaseDTO {
    private Element element;
    private List<Disease> diseases;
    private List<Integer> action;
}
