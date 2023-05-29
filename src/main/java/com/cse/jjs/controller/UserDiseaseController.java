package com.cse.jjs.controller;

import com.cse.jjs.auth.PrincipalDetails;
import com.cse.jjs.disease.UserDiseaseDTO;
import com.cse.jjs.disease.UserDiseaseService;
import com.cse.jjs.domain.UserDisease;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<Object> addDiseaseUser(@RequestBody UserDiseaseDTO userDiseaseDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();


        log.info("username={} diseaseList={}", mPrincipalDetails.getUsername(), userDiseaseDTO);
        userDiseaseDTO.getDisease().forEach(d -> {
            log.info("disease={}", d.getDiseaseName());
            userDiseaseService.aUserDisease(d.getDiseaseName(), mPrincipalDetails.getUsername());
        });
        return ResponseEntity.ok().body("success add userDisease query");
    }

    @PatchMapping(value = "/disease/add")
    public ResponseEntity<Object> updateDiseaseUser(@RequestBody UserDiseaseDTO userDiseaseDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();


        log.info("username={} diseaseList={}", mPrincipalDetails.getUsername(), userDiseaseDTO);
        userDiseaseDTO.getDelDisease().forEach(d -> {
            log.info("delete disease={}",d.getDiseaseName());
            userDiseaseService.dUserDisease(d.getDiseaseName(), mPrincipalDetails.getUsername());
        });
        userDiseaseDTO.getDisease().forEach(d->{
            log.info("add diseaeName={}", d.getDiseaseName());
            userDiseaseService.aUserDisease(d.getDiseaseName(), mPrincipalDetails.getUsername());
        });
        return ResponseEntity.ok().body("success update userDisease query");
    }

    @GetMapping(value = "/disease/user")
    public ResponseEntity<Object> selectUserDiseases()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();

        Map<String, Object> userDiseasesMap = new HashMap<>();
        List<UserDisease> userDiseases = userDiseaseService.selectUserDisease(mPrincipalDetails.getUsername());
        List<String> diseases = new ArrayList<>();
        userDiseases.forEach(d->{
            log.info("{} has {}", mPrincipalDetails.getUsername(), d.getDisease().getDiseaseName());
            diseases.add(d.getDisease().getDiseaseName());
        });
        userDiseasesMap.put("userDiseases", diseases);
        return ResponseEntity.ok().body(userDiseasesMap);
    }
}
