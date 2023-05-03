package com.cse.jjs.user;

import com.cse.jjs.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findByUserId(String userId);
    List<User> findAll();
}
