package com.cse.jjs.allergy;

import com.cse.jjs.domain.Allergy;
import lombok.Data;
import lombok.NonNull;

@Data
public class AllergyDTO {

    private Long allergyId;
    private String allergyName;

    public Allergy toEntity(){
        return Allergy.builder()
                .allergyName(allergyName)
                .build();
    }
}
