package com.cspiration.mooc.dao;

import com.cspiration.mooc.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommentDao {

    Integer insert(Comment comment);

    List<Comment> query(@Param("comment") Comment comment);
}
