package com.learnSphere.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Lesson;
import com.learnSphere.repository.LessonRepository;

@Service
public class StudentImplementation implements StudentService {

	@Autowired
	LessonRepository lessonRepository;

	@Override
	public Lesson getLesson(int lessonId) {
		// TODO Auto-generated method stub
		

		Optional<Lesson> byId = lessonRepository.findById(lessonId);
		if (byId.isPresent()) {
			System.out.println("lesson fetched started");
			return byId.get();
		}
		return null;
	}

}
