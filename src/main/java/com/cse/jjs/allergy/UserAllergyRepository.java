package com.cse.jjs.allergy;

import com.cse.jjs.domain.User;
import com.cse.jjs.domain.UserAllergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserAllergyRepository extends JpaRepository<UserAllergy, Long> {




    @Modifying
    @Query(value = "INSERT INTO user_allergy(allergy_id, user_id) VALUES(:allergyName, :userId)", nativeQuery = true)
    void addUserAllergy(String allergyName, String userId);

    @Modifying
    @Query(value = "DELETE FROM user_allergy WHERE allergy_id=:allergyName AND user_id=:userId", nativeQuery = true)
    void deleteUserAllergy(String allergyName, String userId);



}
