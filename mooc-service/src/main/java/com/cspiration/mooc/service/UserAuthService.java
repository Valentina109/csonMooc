package com.cspiration.mooc.service;

import com.cspiration.mooc.entity.UserAuth;
import com.cspiration.mooc.dao.UserAuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserAuthService {

    @Autowired
    private UserAuthDao userAuthDao;

    public List<UserAuth> getUserAuth() {
        return userAuthDao.selectUserAuth();
    }
}
