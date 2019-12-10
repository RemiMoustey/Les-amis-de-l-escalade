package org.projet6.escalade.model.bean.comment;

import java.sql.Date;

public class Comment {
    private Integer id;
    private Date date;
    private String author;
    private String comment;
    private Integer siteId;

    public Comment() {

    }

    public Comment(Integer pId) {
        id = pId;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
