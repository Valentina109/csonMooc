package com.cspiration.mooc.dao;

import com.cspiration.mooc.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserCourseDao {


    List<UserCourse> query(@Param("userCourse") UserCourse userCourse);
}
