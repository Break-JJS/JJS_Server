package com.cse.jjs.controller;

import com.cse.jjs.allergy.AllergyDTO;
import com.cse.jjs.allergy.UserAllergyDTO;
import com.cse.jjs.allergy.UserAllergyService;
import com.cse.jjs.auth.PrincipalDetails;
import com.cse.jjs.domain.Allergy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserAllergyController {
    private final UserAllergyService userAllergyService;

    //json
    @PostMapping(value = "/allergy/add")
    public ResponseEntity<Object> addAllergyUser(@RequestBody UserAllergyDTO userAllergyDTO)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();

        log.info("username={} and allergyList={}", mPrincipalDetails.getUsername(), userAllergyDTO);


        userAllergyDTO.getAllergy().forEach(d->{
            log.info("id={} and name={}",mPrincipalDetails.getUsername(), d.getAllergyName());
            userAllergyService.aUserAllergy(d.getAllergyName(), mPrincipalDetails.getUsername());
        });


        return ResponseEntity.ok().body("success add userAllergy query");
    }

    @PatchMapping(value = "/allergy/add")
    public ResponseEntity<Object> updateAllergyUser(@RequestBody UserAllergyDTO userAllergyDTO){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
        log.info("username={} and allergyList={}", mPrincipalDetails.getUsername(), userAllergyDTO);

        userAllergyDTO.getDelAllergy().forEach(d->{
            log.info("name={}", d.getAllergyName());
            userAllergyService.dUserAllergy(d.getAllergyName(), mPrincipalDetails.getUsername());
        });
        userAllergyDTO.getAllergy().forEach(d->{
            log.info("id={} and name={}",d.getAllergyName(), d.getAllergyName());
            userAllergyService.aUserAllergy(d.getAllergyName(), mPrincipalDetails.getUsername());
        });


        return ResponseEntity.ok().body("success update userAllergy query");
    }
}
