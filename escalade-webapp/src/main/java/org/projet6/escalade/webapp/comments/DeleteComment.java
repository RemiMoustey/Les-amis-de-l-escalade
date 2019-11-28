package org.projet6.escalade.webapp.comments;

import org.projet6.escalade.consumer.contract.dao.CommentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteComment {
    public void removeComment(int id) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        CommentDao commentDao = (CommentDao) vApplicationContext.getBean("commentDao");
        commentDao.deleteComment(id);
    }
}
