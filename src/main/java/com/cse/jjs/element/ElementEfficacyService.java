package com.cse.jjs.element;

import com.cse.jjs.domain.ElementEfficacy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementEfficacyService {

    private final ElementEfficacyRepository elementEfficacyRepository;

    public List<ElementEfficacy> selectElementEfficacy(String elementName){
        return elementEfficacyRepository.findAllByElementName(elementName);
    }
}
