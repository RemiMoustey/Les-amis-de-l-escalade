package org.projet6.escalade.consumer.contract.dao;

import org.projet6.escalade.model.bean.comment.Comment;

import java.util.List;

/**
 * Defines all the interactions with the database
 */
public interface CommentDao {
    public void insertComment(Comment pComment);
    public List<Comment> getListComments(int siteId);
    public Comment getSelectedComment(int id);
    public void updateComment(int id, String author, String comment);
    public void deleteComment(int id);
}
