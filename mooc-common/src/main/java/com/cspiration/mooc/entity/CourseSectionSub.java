package com.cspiration.mooc.entity;

import java.util.ArrayList;
import java.util.List;


public class CourseSectionSub extends CourseSection {

    //小节
    private List<CourseSection> sections;

    public CourseSectionSub() {
        sections = new ArrayList<>();
    }

    public List<CourseSection> getSections() {
        return sections;
    }

    public void setSections(List<CourseSection> sections) {
        this.sections = sections;
    }
}
