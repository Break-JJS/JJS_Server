package com.cse.jjs.disease;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDiseaseService {
    private final UserDiseaseRepository userDiseaseRepository;

    @Transactional
    public void aUserDisease(String diseaseName, String userId){
        userDiseaseRepository.addUserDisease(diseaseName, userId);
    }

    @Transactional
    public void dUserDisease(String diseaseName, String userId){
        userDiseaseRepository.deleteUserDisease(diseaseName, userId);
    }
}
