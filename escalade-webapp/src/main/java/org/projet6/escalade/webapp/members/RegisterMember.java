package org.projet6.escalade.webapp.members;

import org.projet6.escalade.consumer.contract.dao.MemberDao;
import org.projet6.escalade.model.bean.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class RegisterMember {
    public void registerNewMember(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        MemberDao memberDao = (MemberDao) vApplicationContext.getBean("memberDao");
        Member newMember = new Member();
        newMember.setLogin(request.getParameter("login"));
        newMember.setPassword(request.getParameter("password"));
        newMember.setEmail(request.getParameter("email"));
        newMember.setPhoneNumber(request.getParameter("phoneNumber"));
        newMember.setAddress(request.getParameter("address"));
        newMember.setPostalCode(request.getParameter("postalCode"));
        newMember.setTown(request.getParameter("town"));
        memberDao.insertMember(newMember);
    }
}
