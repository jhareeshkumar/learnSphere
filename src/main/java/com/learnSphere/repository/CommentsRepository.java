package com.learnSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	List<Comments> findAllByOrderByCommentIdDesc();
}