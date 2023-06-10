package com.cse.jjs.controller;

import com.cse.jjs.auth.PrincipalDetails;
import com.cse.jjs.disease.UserDiseaseService;
import com.cse.jjs.domain.Element;
import com.cse.jjs.domain.ElementDisease;
import com.cse.jjs.domain.ElementEfficacy;
import com.cse.jjs.domain.UserDisease;
import com.cse.jjs.element.ElementAllergyService;
import com.cse.jjs.element.ElementDTO;
import com.cse.jjs.element.ElementDiseaseService;
import com.cse.jjs.element.ElementEfficacyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@Api(value = "성분API")
public class ElementController {

    private final ElementAllergyService elementAllergyService;
    private final ElementEfficacyService elementEfficacyService;
    private final UserDiseaseService userDiseaseService;
    private final ElementDiseaseService elementDiseaseService;

    @ApiOperation(value = "성분-알러지 조회")
    @GetMapping(value = "/element/allergy")
    public ResponseEntity<Object> selectElementAllergy(@RequestParam(value = "element") String[] elements){
        log.info("elementDTO={}", elements);

        List<String> allergy = new ArrayList<>();
        Map<String, Object> allergyMap = new HashMap<>();

        for (String d : elements) {
            log.info("element={}",d);
            if(elementAllergyService.isAllergy(d).isPresent()){
                allergy.add(d);
            }
        }

        allergyMap.put("allergies", allergy);
        return ResponseEntity.ok().body(allergyMap);
    }

    @ApiOperation(value = "성분-효능 조회")
    @GetMapping(value = "/element/efficacy")
    public ResponseEntity<Object> selectElementEfficacies(@RequestParam(value = "element") String[] elements){
        log.info("elementDTO={}", elements);
        List<Object> result = new ArrayList<>();
        Map<String, Object> jsonMap = new HashMap<>();
        Long id = 0L;

        for (String d : elements) {
            Map<String,Object> elementEfficacyMap = new HashMap<>();
            List<String> goodEfficacy = new ArrayList<>();
            List<String> badEfficacy = new ArrayList<>();
            log.info("element={}", d);
            List<ElementEfficacy> elementEfficacies = elementEfficacyService.selectElementEfficacy(d);
            //System.out.println(elementEfficacies);
            if(!elementEfficacies.isEmpty())
            {
                for (ElementEfficacy efficacy: elementEfficacies) {

                    if(efficacy.getEfficacy().getAction()==1){
                        goodEfficacy.add(efficacy.getEfficacy().getEfficacyName());
                    }
                    else{
                        badEfficacy.add(efficacy.getEfficacy().getEfficacyName());
                    }
                }

                elementEfficacyMap.put("id", id++);
                elementEfficacyMap.put("element", d);
                elementEfficacyMap.put("goodEfficacy", goodEfficacy);
                elementEfficacyMap.put("goodEfficacyCnt", goodEfficacy.size());
                elementEfficacyMap.put("badEfficacy", badEfficacy);
                elementEfficacyMap.put("badEfficacyCnt", badEfficacy.size());
                result.add(elementEfficacyMap);
            }
        }

        jsonMap.put("RelationElementEfficacy", result);
        return ResponseEntity.ok().body(jsonMap);
    }

    @ApiOperation(value = "성분-질병(유저) 조회")
    @GetMapping(value = "/element/disease")
    public ResponseEntity<Object> selectUserDiseaseElement(@RequestParam(value = "element") String[] elements){

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();

        Map<String, Object> userDiseaseElementMap= new HashMap<>();
        List<Map<String,Object>> corrDisease = new ArrayList<>();
        List<UserDisease> userDiseases = userDiseaseService.selectUserDisease(mPrincipalDetails.getUsername());
        Long id = 0L;

        for(String element : elements){
            List<ElementDisease> elementDiseases = elementDiseaseService.selectElementDiseases(element);
            for (UserDisease userDisease : userDiseases) {
                for (ElementDisease elementDisease : elementDiseases) {

                    if(userDisease.getDisease().getDiseaseName().equals(elementDisease.getDisease().getDiseaseName())){
                        Map<String, Object> diseaseElementMap = new HashMap<>();
                        diseaseElementMap.put("id", id++);
                        diseaseElementMap.put("element", element);
                        diseaseElementMap.put("disease", userDisease.getDisease().getDiseaseName());
                        diseaseElementMap.put("action", elementDisease.getAction());
                        corrDisease.add(diseaseElementMap);
                    }
                }
            }
        }

        userDiseaseElementMap.put("RelationUserDisease", corrDisease);
        return ResponseEntity.ok().body(userDiseaseElementMap);
    }
}
