package org.projet6.escalade.webapp.comments;

import org.projet6.escalade.consumer.contract.dao.CommentDao;
import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.comment.Comment;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintComments {

    public void getComments(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        CommentDao commentDao = (CommentDao) vApplicationContext.getBean("commentDao");
        HttpSession session = request.getSession();
        List<Comment> comments = commentDao.getListComments(Integer.parseInt((String) session.getAttribute("siteId")));
        Iterator<Comment> it = comments.iterator();
        ArrayList<Comment> allComments = new ArrayList<Comment>();
        while(it.hasNext()) {
            allComments.add(it.next());
        }
        request.setAttribute("allComments", allComments);
    }

    public void getOneCommment(HttpServletRequest request, int id) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        CommentDao commentDao = (CommentDao) vApplicationContext.getBean("commentDao");
        Comment comment =  commentDao.getSelectedComment(id);
        HttpSession session = request.getSession();
        session.setAttribute("commentId", comment.getId());
        request.setAttribute("comment", comment);
    }
}
