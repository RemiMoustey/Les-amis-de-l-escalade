package org.projet6.escalade.webapp.comments;

import org.projet6.escalade.consumer.contract.dao.CommentDao;
import org.projet6.escalade.model.bean.comment.Comment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegisterComment {
    public void registerNewComment(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        CommentDao commentDAO = (CommentDao) vApplicationContext.getBean("commentDao");
        Comment newComment = new Comment();
        newComment.setAuthor(request.getParameter("author"));
        newComment.setComment(request.getParameter("comment"));
        HttpSession session = request.getSession();
        newComment.setSiteId(Integer.parseInt((String) session.getAttribute("siteId")));
        commentDAO.insertComment(newComment);
    }
}
