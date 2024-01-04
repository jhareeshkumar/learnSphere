package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Comments;
import com.learnSphere.repository.CommentsRepository;

@Service
public class CommentsServiceImplementation implements CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public List<Comments> commentsList() {
		// TODO Auto-generated method stub
		return commentsRepository.findAllByOrderByCommentIdDesc();
	}

	@Override
	public String addComment(Comments comment) {
		// TODO Auto-generated method stub
		commentsRepository.save(comment);
		return "Comment added Successfully";
	}

}
