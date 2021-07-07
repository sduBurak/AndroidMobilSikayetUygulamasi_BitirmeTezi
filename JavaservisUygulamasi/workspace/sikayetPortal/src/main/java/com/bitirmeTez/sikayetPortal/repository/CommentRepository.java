package com.bitirmeTez.sikayetPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bitirmeTez.sikayetPortal.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
