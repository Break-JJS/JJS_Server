package com.cse.jjs.controller;

import com.cse.jjs.domain.User;
import com.cse.jjs.user.UserDto;
import com.cse.jjs.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value="/users/join")
    public String createForm(){
        return "users/createUserForm";
    }

    @PostMapping(value = "/users/join")
    public String create(@Valid @RequestBody UserDto userDto){
        User user = userDto.toEntity();
        log.info(userDto.toString());
        userService.join(user);

        return "redirect:/login";
    }
}
