package com.cse.jjs.element;

import com.cse.jjs.allergy.AllergyRepository;
import com.cse.jjs.domain.Allergy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementAllergyService {
    private final AllergyRepository allergyRepository;

    public Optional<Allergy> isAllergy(String allergyName){
        return allergyRepository.findByAllergyName(allergyName);
    }
}
