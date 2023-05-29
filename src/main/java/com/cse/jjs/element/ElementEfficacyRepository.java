package com.cse.jjs.element;

import com.cse.jjs.domain.ElementEfficacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElementEfficacyRepository extends JpaRepository<ElementEfficacy, Long> {

    @Query(value = "SELECT * FROM element_efficacy WHERE element_id=:elementName", nativeQuery = true)
    List<ElementEfficacy> findAllByElementName(String elementName);
}
