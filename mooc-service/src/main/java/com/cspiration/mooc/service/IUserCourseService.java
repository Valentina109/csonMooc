package com.cspiration.mooc.service;


import com.cspiration.mooc.entity.UserCourse;

import java.util.List;

public interface IUserCourseService {

    List<UserCourse> query(UserCourse userCourse);
}
