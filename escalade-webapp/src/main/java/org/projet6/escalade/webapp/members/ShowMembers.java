package org.projet6.escalade.webapp.members;

import org.projet6.escalade.consumer.contract.dao.MemberDao;
import org.projet6.escalade.model.bean.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowMembers {
    public ArrayList<Member> getListMembers() {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        MemberDao memberDao = (MemberDao) vApplicationContext.getBean("memberDao");
        List<Member> members = memberDao.getListMembers();
        Iterator<Member> it = members.iterator();
        ArrayList<Member> allMembers = new ArrayList<Member>();
        while(it.hasNext()) {
            allMembers.add(it.next());
        }
        return allMembers;
    }
}
