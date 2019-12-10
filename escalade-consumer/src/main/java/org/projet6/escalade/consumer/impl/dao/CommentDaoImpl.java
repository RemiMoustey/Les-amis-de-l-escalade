package org.projet6.escalade.consumer.impl.dao;

import org.projet6.escalade.consumer.contract.dao.CommentDao;
import org.projet6.escalade.consumer.impl.rowmapper.CommentMapper;
import org.projet6.escalade.model.bean.comment.Comment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.ManagedBean;
import java.sql.Types;
import java.util.List;

import org.apache.logging.log4j.Logger;

/**
 * Implements all the interactions with the database
 */
@ManagedBean
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao {

    private Logger LOGGER;

    /**
     * Inserts a comment in the database (table comment), with the entered data in the form
     */
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

    /**
     * Catches all the comments corresponding to a site
     */
    @Override
    public List<Comment> getListComments(int siteId) {
        String vSQL = "SELECT * FROM comment WHERE siteId=:siteId";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("siteId", siteId);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new CommentMapper());
    }

    /**
     * Catches the selected comment to modify or delete it
     */
    @Override
    public Comment getSelectedComment(int id) {
        String vSQL = "SELECT * FROM comment WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        return new NamedParameterJdbcTemplate(getDataSource()).query(vSQL, vParams, new CommentMapper()).iterator().next();
    }

    /**
     * Updates a modified comment
     */
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

    /**
     * Deletes a comment from the database
     */
    @Override
    public void deleteComment(int id) {
        String vSQL = "DELETE FROM comment WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}