package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entity.Course;
import com.learnSphere.services.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	private TrainerService trainerService;

	@PostMapping("/createCourse")
	public String createCourse(@RequestParam int courseId, @RequestParam String courseName,
			@RequestParam int coursePrice, Model model) {
		// TODO: process POST request
		String course = trainerService.createCourse(courseId, courseName, coursePrice);
		model.addAttribute("createCourseStatus", course);
		System.out.println(courseId + "" + courseName + "" + coursePrice);
		return "redirect:/createCourse";
	}

	@PostMapping("/addLesson")
	public String addLesson(@RequestParam(name = "courseId") int courseId,
			@RequestParam(name = "lessonId") int lessonId, @RequestParam(name = "lessonName") String lessonName,
			@RequestParam(name = "lessonTopics") String lessonTopics, @RequestParam(name = "link") String link,
			Model model) {
		// TODO: process POST request
		String addLessonStatus = trainerService.addLesson(courseId, lessonId, lessonName, lessonTopics, link);
		model.addAttribute("addLessonStatus", addLessonStatus);
		return "redirect:/addLesson";
	}

	@GetMapping("/showCourses")
	public String showCourses(Model model) {
		List<Course> courseList = trainerService.courseList();
		model.addAttribute("courses", courseList);
		System.out.println("course fetched successfully");
		return "redirect:/courses";
	}
}
