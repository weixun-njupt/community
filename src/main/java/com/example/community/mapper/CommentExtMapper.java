package com.example.community.mapper;

import com.example.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}