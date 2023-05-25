package com.cse.jjs.allergy;

import com.cse.jjs.domain.User;
import com.cse.jjs.domain.UserAllergy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAllergyService {

    private final UserAllergyRepository userAllergyRepository;

    @Transactional
    public void aUserAllergy(String allergyName, String userId) {
            userAllergyRepository.addUserAllergy(allergyName, userId);
    }

    @Transactional
    public void dUserAllergy(String allergyName, String userId){
        userAllergyRepository.deleteUserAllergy(allergyName, userId);
    }

    @Transactional
    public List<?> dAllByUserId(String userId){
        return userAllergyRepository.deleteAllByUserId(userId);
    }

    public boolean isUser(User user){
        Optional<UserAllergy> userAllergy = userAllergyRepository.findByUser(user);
        return userAllergy.isPresent();
    }
}
