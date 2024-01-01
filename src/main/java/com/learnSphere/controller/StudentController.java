package com.learnSphere.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnSphere.entity.Comments;
import com.learnSphere.entity.Lesson;
import com.learnSphere.services.CommentsService;
import com.learnSphere.services.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes(names = "lesson")
public class StudentController {
	@Autowired
	StudentService studentService;

	@Autowired
	CommentsService commentsService;

	@PostMapping("/getLesson")
	public String getLesson(@RequestParam int lessonId, Model model, HttpSession httpSession) {
		// TODO: process POST request

		Lesson lesson = studentService.getLesson(lessonId);
		if (lesson != null) {
			System.out.println("Lesson fetching ended");
			System.out.println("Adding element to the sesssion");
			httpSession.setAttribute("lesson", lesson);
			model.addAttribute("lesson", lesson);
			model.addAttribute("commentsList", commentsService.commentsList());
			return "myLesson";
		} else {
			model.addAttribute("lesson", "Please give correct Lesson ID!");
			System.out.println(lessonId + " Not Found");
			return "myCourses";
		}
	}

	@PostMapping("/addComment")
	public String addComment(@RequestParam String comment, Model model, HttpSession httpSession) {
		// TODO: process POST request
		Comments comments = new Comments();

		System.out.println("comment added successfully");
		System.out.println("collection element from the sesssion");
		Lesson attribute = (Lesson) httpSession.getAttribute("lesson");
		comments.setComment(comment);
		model.addAttribute("success", true);
		String commentMessage = commentsService.addComment(comments);
		model.addAttribute("commentMessage", commentMessage);
		// Fetch the lesson and commentsList again if needed
		int lessonId = attribute.getLessonId();// You need to determine the lessonId based on
																			// your application logic
		Lesson lesson = studentService.getLesson(lessonId);
		if (lesson != null) {
			model.addAttribute("lesson", lesson);
			model.addAttribute("commentsList", commentsService.commentsList());
		}
		return "myLesson";
	}
}
