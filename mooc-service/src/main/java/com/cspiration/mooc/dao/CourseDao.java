package com.cspiration.mooc.dao;

import com.cspiration.mooc.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CourseDao {

    List<Course> query(@Param("course")Course course);
}
