package com.cspiration.mooc.service;

import com.cspiration.mooc.entity.Comment;

import java.util.List;

public interface ICommentService {

    Boolean insert(Comment comment);


    List<Comment> query(Comment comment);
}
