package com.cse.jjs.auth;

import com.cse.jjs.domain.User;
import com.cse.jjs.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userEntity = userRepository.findByUsername(username);
        log.info("loadUserByUsername userID={}",username);

        if(userEntity.isEmpty()){
            return null;
        }
        else{
            return new PrincipalDetails(userEntity.get());
        }
    }
}
