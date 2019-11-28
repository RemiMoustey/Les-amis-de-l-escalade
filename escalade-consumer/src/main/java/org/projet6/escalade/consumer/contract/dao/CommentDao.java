package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.comment.Comment;

import java.util.List;

public interface CommentDao {
    public void insertComment(Comment pComment);
    public List<Comment> getListComments(int siteId);
}
