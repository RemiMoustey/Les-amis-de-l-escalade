package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.AwaitingTopoDao;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class ReserveTopo {

    public void updateAvailableTopo(String id) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        topoDao.reserveTopo(Integer.parseInt(id));
    }

    public void createAwaitingTopo(int topoId, int memberId, int buyerId) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        AwaitingTopoDao awaitingTopoDao = (AwaitingTopoDao) vApplicationContext.getBean("awaitingTopoDao");
        AwaitingTopo newAwaitingTopo = new AwaitingTopo();
        newAwaitingTopo.setTopoId(topoId);
        newAwaitingTopo.setMemberId(memberId);
        newAwaitingTopo.setBuyerId(buyerId);
        awaitingTopoDao.insertAwaitingTopo(newAwaitingTopo);
    }
}
