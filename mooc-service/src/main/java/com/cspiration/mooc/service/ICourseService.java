package com.cspiration.mooc.service;

import com.cspiration.mooc.entity.Course;
import com.cspiration.mooc.entity.CourseSectionSub;

import java.util.List;

public interface ICourseService {

    List<Course> query(Course course);

    List<CourseSectionSub> queryCourseSection(Long courseId);
}
