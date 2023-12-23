package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entity.Course;

public interface TrainerService {
	String createCourse(int courseId,String courseName,int coursePrice);
	Course getCourse(int courseId);
	String addLesson(int courseId,int lessonId,String lessonName,String lessonTopics,String link);
	List<Course> courseList();
}
