package com.cse.jjs.element;

import com.cse.jjs.domain.ElementDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElementDiseaseRepository extends JpaRepository<ElementDisease, Long> {

    @Query(value = "SELECT * FROM element_disease WHERE element_id=:elementName", nativeQuery = true)
    List<ElementDisease> findAllByElementName(String elementName);
}
