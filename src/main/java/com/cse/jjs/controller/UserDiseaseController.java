package com.cse.jjs.controller;

import com.cse.jjs.auth.PrincipalDetails;
import com.cse.jjs.disease.UserDiseaseDTO;
import com.cse.jjs.disease.UserDiseaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
