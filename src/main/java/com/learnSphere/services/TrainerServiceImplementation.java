package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.CourseRepository;
import com.learnSphere.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	LessonRepository lessonRepository;

	@Override
	public String createCourse(int courseId, String courseName, int coursePrice) {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);

		courseRepository.save(course);

		return "Course created successfully";

	}

	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		return courseRepository.findById(courseId).get();
	}

	@Override
	public String addLesson(int courseId, int lessonId, String lessonName, String lessonTopics, String link) {
		// TODO Auto-generated method stub
		Course course = getCourse(courseId);
		Lesson lesson = new Lesson(lessonId, lessonName, lessonTopics, link, course);
		lessonRepository.save(lesson);

		course.getLessons().add(lesson);
		
		courseRepository.save(course);
		
		return "lesson added Successfully";
	}

	@Override
	public List<Course> courseList() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

}
