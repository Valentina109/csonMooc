package com.cspiration.mooc.dao;

import com.cspiration.mooc.entity.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAuthDao {
    public List<UserAuth> selectUserAuth();

    Integer insert(UserAuth userAuth);

    List<UserAuth> query(@Param("userAuth")UserAuth userAuth);

    Integer update(@Param("userAuth")UserAuth userAuth);
}