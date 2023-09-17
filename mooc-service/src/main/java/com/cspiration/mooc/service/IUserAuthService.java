package com.cspiration.mooc.service;

import com.cspiration.mooc.entity.UserAuth;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserAuthService {

    Boolean insert(UserAuth userAuth);
    Boolean getByUsername(String username);
    Boolean getByUserEmail(String email);

    UserAuth auth(String username, String password);
    Boolean update(UserAuth userAuth);

    List<UserAuth> query(UserAuth userAuth);
    String authREST(UserAuth userAuth);
    UserAuth getByUserId(long id);
}
