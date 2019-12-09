package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.AwaitingTopoDao;
import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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

    public void makeAvailable(int id, boolean setAvailable) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        topoDao.updateAvailable(id, setAvailable);
        topoDao.deleteAwaiting(id);
    }

    public boolean checkIfIdAndMemberIdMatch(HttpServletRequest request) {
        PrintTopos printTopos = new PrintTopos();
        printTopos.getToposMember(request, Integer.parseInt(request.getParameter("member_id")));
        for(Topo topo : (ArrayList<Topo>) request.getAttribute("allTopos")) {
            if(topo.getId() == Integer.parseInt(request.getParameter("id")) && topo.getMemberId() == Integer.parseInt(request.getParameter("member_id")) && topo.getIsAvailable()) {
                return true;
            }
        }
        return false;
    }
}
