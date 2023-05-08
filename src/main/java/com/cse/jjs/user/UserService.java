package com.cse.jjs.user;

import com.cse.jjs.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public User join(User user){
        validateDuplicateUser(user);
        System.out.println("호출완료!");
        String rawPassword = user.getPassWord();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassWord(encPassword);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user){
        userRepository.findByUserID(user.getUserID())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
