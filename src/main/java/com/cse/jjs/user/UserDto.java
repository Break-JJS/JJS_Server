package com.cse.jjs.user;

import com.cse.jjs.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @Size(min = 2, max = 40) @NotBlank
    private String userID;
    @NotBlank
    private String passWord;
    private String name;
    private Integer gender;
    private Double height;
    private Double weight;

    public User toEntity(){
        return User.builder()
                .userID(userID)
                .passWord(passWord)
                .name(name)
                .gender(gender)
                .height(height)
                .weight(weight)
                .build();
    }
}
