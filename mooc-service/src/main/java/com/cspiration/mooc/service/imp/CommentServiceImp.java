package com.cspiration.mooc.service.imp;

import com.cspiration.mooc.dao.CommentDao;
import com.cspiration.mooc.entity.Comment;
import com.cspiration.mooc.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements ICommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Boolean insert(Comment comment) {
        if (commentDao.insert(comment) <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<Comment> query(Comment comment) {
        return commentDao.query(comment);
    }
}
