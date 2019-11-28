package org.projet6.escalade.consumer.impl.dao;

import org.projet6.escalade.consumer.contract.dao.CommentDao;
import org.projet6.escalade.model.bean.comment.Comment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.logging.log4j.Logger;

@ManagedBean
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao {

    private Logger LOGGER;

    @Override
    public void insertComment(Comment pComment) {
        String vSQL = "INSERT INTO comment (author, comment, siteId) VALUES (:author, :comment, :siteId)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pComment);
        vParams.registerSqlType("author", Types.VARCHAR);
        vParams.registerSqlType("comment", Types.LONGVARCHAR);
        vParams.registerSqlType("siteId", Types.INTEGER);

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Le commentaire existe déjà ! id=" + pComment.getId(), vEx);
        }
    }

    @Override
    public List<Comment> getListComments(int siteId) {
        String vSQL = "SELECT * FROM comment WHERE siteId = " + "'" + siteId + "'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new CommentMapper());
    }

    @Override
    public Comment getSelectedComment(int id) {
        String vSQL = "SELECT * FROM comment WHERE id='" + id + "'";

        return new JdbcTemplate(getDataSource()).query(vSQL, new CommentMapper()).iterator().next();
    }

    @Override
    public void updateComment(int id, String author, String comment) {
        String vSQL = "UPDATE comment SET author=:author, comment=:comment WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("author", author);
        vParams.addValue("comment", comment);
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void deleteComment(int id) {
        String vSQL = "DELETE FROM comment WHERE id=" + id;

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    private static final class CommentMapper implements RowMapper<Comment> {
        public Comment mapRow(ResultSet pRS, int pRowNum) throws SQLException {
            Comment vComment = new Comment(pRS.getInt("id"));
            vComment.setAuthor(pRS.getString("author"));
            vComment.setComment(pRS.getString("comment"));
            vComment.setSiteId(pRS.getInt("siteId"));

            return vComment;
        }
    }
}