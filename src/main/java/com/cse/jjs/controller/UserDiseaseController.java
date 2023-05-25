package com.cse.jjs.controller;

import com.cse.jjs.auth.PrincipalDetails;
import com.cse.jjs.disease.UserDiseaseDTO;
import com.cse.jjs.disease.UserDiseaseService;
import com.cse.jjs.domain.UserDisease;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserDiseaseController {
    private final UserDiseaseService userDiseaseService;

    @PostMapping(value = "/disease/add")
    public ResponseEntity<?> addDiseaseUser(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody UserDiseaseDTO userDiseaseDTO) {
        log.info("username={} diseaseList={}", principalDetails.getUsername(), userDiseaseDTO);
        userDiseaseDTO.getDisease().forEach(d -> {
            log.info("disease={}", d.getDiseaseName());
            userDiseaseService.aUserDisease(d.getDiseaseName(), principalDetails.getUsername());
        });
        return ResponseEntity.ok().body("success add userDisease query");
    }

    @PatchMapping(value = "/disease/add")
    public ResponseEntity<?> updateDiseaseUser(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody UserDiseaseDTO userDiseaseDTO) {
        log.info("username={} diseaseList={}", principalDetails.getUsername(), userDiseaseDTO);
        userDiseaseDTO.getDelDisease().forEach(d -> {
            log.info("delete disease={}",d.getDiseaseName());
            userDiseaseService.dUserDisease(d.getDiseaseName(), principalDetails.getUsername());
        });
        userDiseaseDTO.getDisease().forEach(d->{
            log.info("add diseaeName={}", d.getDiseaseName());
            userDiseaseService.aUserDisease(d.getDiseaseName(), principalDetails.getUsername());
        });
        return ResponseEntity.ok().body("success update userDisease query");
    }

    @GetMapping(value = "/disease/user")
    public ResponseEntity<?> selectUserDiseases(@AuthenticationPrincipal PrincipalDetails principalDetails)
    {

        Map<String, Object> userDiseasesMap = new HashMap<>();
        List<UserDisease> userDiseases = userDiseaseService.selectUserDisease(principalDetails.getUsername());
        List<String> diseases = new ArrayList<>();
        userDiseases.forEach(d->{
            log.info("{} has {}", principalDetails.getUsername(), d.getDisease().getDiseaseName());
            diseases.add(d.getDisease().getDiseaseName());
        });
        userDiseasesMap.put("userDiseases", diseases);
        return ResponseEntity.ok().body(userDiseasesMap);
    }
}
