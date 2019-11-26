package org.projet6.escalade.webapp.members;

import org.projet6.escalade.consumer.contract.dao.MemberDao;
import org.projet6.escalade.model.bean.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class ConnectedMember {
    public void connectMember(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        MemberDao memberDao = (MemberDao) vApplicationContext.getBean("memberDao");

        Member connectedMember = memberDao.getConnectedMember((String) request.getAttribute("login"), (String) request.getAttribute("password")).iterator().next();
        memberDao.connectMember(connectedMember);
    }
}
