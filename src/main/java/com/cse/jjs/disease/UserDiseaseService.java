package com.cse.jjs.disease;

import com.cse.jjs.domain.UserDisease;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public List<UserDisease> selectUserDisease(String username){
        return userDiseaseRepository.findAllByUser_Name(username);
    }

}
