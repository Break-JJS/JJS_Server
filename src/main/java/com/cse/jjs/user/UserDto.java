package com.cse.jjs.user;

import com.cse.jjs.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @Size(min = 2, max = 40) @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String name;
    private Integer gender;
    private Double height;
    private Double weight;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .gender(gender)
                .height(height)
                .weight(weight)
                .build();
    }
}
