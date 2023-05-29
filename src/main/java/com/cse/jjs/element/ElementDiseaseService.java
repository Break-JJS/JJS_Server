package com.cse.jjs.element;

import com.cse.jjs.domain.ElementDisease;
import com.cse.jjs.domain.UserDisease;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ElementDiseaseService {
    private final ElementDiseaseRepository elementDiseaseRepository;

    public List<ElementDisease> selectElementDiseases(String elementName){
        return elementDiseaseRepository.findAllByElementName(elementName);
    }

    public List<String> userDiseaseElement(List<UserDisease> userDiseases, List<ElementDisease> elementDiseases){
        List<String> userDiseaseElementList = new ArrayList<>();
        userDiseases.forEach(userDisease -> {
            elementDiseases.forEach(elementDisease -> {
                if(userDisease.getDisease().getDiseaseName().equals(elementDisease.getDisease().getDiseaseName())){
                    userDiseaseElementList.add(elementDisease.getDisease().getDiseaseName());
                }
            });
        });
        return userDiseaseElementList;
    }
}
