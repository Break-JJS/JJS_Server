package com.cse.jjs.allergy;

import com.cse.jjs.domain.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllergyRepository extends JpaRepository<Allergy, String> {
    Optional<Allergy> findByAllergyName(String allergyName);
}
