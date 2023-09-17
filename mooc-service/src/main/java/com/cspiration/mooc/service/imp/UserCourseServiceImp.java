package com.cspiration.mooc.service.imp;

import com.cspiration.mooc.dao.UserCourseDao;
import com.cspiration.mooc.entity.UserCourse;
import com.cspiration.mooc.service.IUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserCourseServiceImp implements IUserCourseService {

    @Autowired
    private UserCourseDao userCourseDao;

    @Override
    public List<UserCourse> query(UserCourse userCourse) {
        List<UserCourse> list = userCourseDao.query(userCourse);
        return list;
    }
}
