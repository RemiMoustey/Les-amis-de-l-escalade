package org.projet6.escalade.consumer.impl.rowmapper;

import org.projet6.escalade.model.bean.comment.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Gathers the caught comments
 */
public final class CommentMapper implements RowMapper<Comment> {
    public Comment mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Comment vComment = new Comment(pRS.getInt("id"));
        vComment.setAuthor(pRS.getString("author"));
        vComment.setComment(pRS.getString("comment"));
        vComment.setSiteId(pRS.getInt("siteId"));

        return vComment;
    }
}
