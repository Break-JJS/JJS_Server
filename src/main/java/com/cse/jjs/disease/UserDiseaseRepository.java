package com.cse.jjs.disease;

import com.cse.jjs.domain.UserDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDiseaseRepository extends JpaRepository<UserDisease, Long> {

    @Modifying
    @Query(value = "INSERT INTO user_disease(disease_id, user_id) VALUES(:diseaseName, :userId)", nativeQuery = true)
    void addUserDisease(String diseaseName, String userId);

    @Modifying
    @Query(value = "DELETE FROM user_disease WHERE disease_id=:diseaseName AND user_id=:userId", nativeQuery = true)
    void deleteUserDisease(String diseaseName, String userId);
}
