package org.projet6.escalade.model.bean.comment;

public class Comment {
    private Integer id;
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
