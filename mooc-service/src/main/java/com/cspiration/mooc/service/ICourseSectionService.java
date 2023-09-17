package com.cspiration.mooc.service;

import com.cspiration.mooc.entity.CourseSection;

import java.util.List;

public interface ICourseSectionService {

    List<CourseSection> query(CourseSection userCourse);
}
