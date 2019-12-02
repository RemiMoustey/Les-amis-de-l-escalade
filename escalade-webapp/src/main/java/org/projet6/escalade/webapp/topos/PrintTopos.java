package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.AwaitingTopoDao;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintTopos {

    public void getToposMember(HttpServletRequest request, int memberId) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        List<Topo> topos = topoDao.getListToposMember(memberId);
        Iterator<Topo> it = topos.iterator();
        ArrayList<Topo> allTopos = new ArrayList<Topo>();
        while(it.hasNext()) {
            allTopos.add(it.next());
        }
        request.setAttribute("allTopos", allTopos);
    }

    public void getAvailableTopos(HttpServletRequest request, int memberId) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        List<Topo> topos = topoDao.getListAvailableTopos(memberId);
        Iterator<Topo> it = topos.iterator();
        ArrayList<Topo> availableTopos = new ArrayList<Topo>();
        while(it.hasNext()) {
            availableTopos.add(it.next());
        }
        request.setAttribute("availableTopos", availableTopos);
    }

    public void getAwaitingTopos(HttpServletRequest request, int memberId) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        List<Topo> topos = topoDao.getListAwaitingTopos(memberId);
        Iterator<Topo> it = topos.iterator();
        ArrayList<Topo> awaitingTopos = new ArrayList<Topo>();
        while(it.hasNext()) {
            awaitingTopos.add(it.next());
        }
        request.setAttribute("awaitingTopos", awaitingTopos);
    }

    public void
    getDataAwaitingTopos(HttpServletRequest request, int buyerId, String parameterQuery) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        AwaitingTopoDao awaitingTopoDao = (AwaitingTopoDao) vApplicationContext.getBean("awaitingTopoDao");
        List<AwaitingTopo> awaitingTopos = null;
        if(parameterQuery.equals("buyer")) {
            awaitingTopos = awaitingTopoDao.getListDataAwaitingToposBuyer(buyerId);
        }
        else if(parameterQuery.equals("member")) {
            awaitingTopos = awaitingTopoDao.getListDataAwaitingToposMember(buyerId);
        }
        Iterator<AwaitingTopo> it = awaitingTopos.iterator();
        ArrayList<AwaitingTopo> awaitingDataTopos = new ArrayList<AwaitingTopo>();
        while(it.hasNext()) {
            awaitingDataTopos.add(it.next());
        }
        request.setAttribute("awaitingDataTopos", awaitingDataTopos);
    }
}
