package com.cse.jjs.disease;

import com.cse.jjs.domain.Disease;
import com.cse.jjs.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDiseaseDTO {
    private User user;
    private List<Disease> delDisease;
    private List<Disease> disease;
}
