package com.cse.jjs.allergy;

import com.cse.jjs.domain.Allergy;
import com.cse.jjs.domain.User;
import com.cse.jjs.domain.UserAllergy;
import lombok.Data;

import java.util.List;

@Data
public class UserAllergyDTO {
    private List<Allergy> allergy;
    private List<Allergy> delAllergy;

}
