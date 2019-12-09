package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.awaiting_topo.AwaitingTopo;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AcceptTopo {
    public void acceptTopo(int idTopo) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");

        topoDao.updateReservation(idTopo);
    }

    public boolean checkIfIsAuthorizedToAccept(HttpServletRequest request) {
        PrintTopos printTopos = new PrintTopos();
        printTopos.getAwaitingTopos(request, Integer.parseInt(request.getParameter("member_id")));
        printTopos.getDataAwaitingTopos(request, Integer.parseInt(request.getParameter("buyer_id")), "buyer");
        for(Topo topo : (ArrayList<Topo>) request.getAttribute("awaitingTopos")) {
            if(topo.getId() == Integer.parseInt(request.getParameter("id"))
                    && topo.getMemberId() == Integer.parseInt(request.getParameter("member_id"))) {
                for(AwaitingTopo awaitingTopo : (ArrayList<AwaitingTopo>) request.getAttribute("awaitingDataTopos")) {
                    if(awaitingTopo.getBuyerId() == Integer.parseInt(request.getParameter("buyer_id"))
                            && awaitingTopo.getMemberId() == Integer.parseInt(request.getParameter("member_id"))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkIfIsAuthorizedToUpdateAvailable(HttpServletRequest request) {
        PrintTopos printTopos = new PrintTopos();
        printTopos.getToposMember(request, (int) request.getSession().getAttribute("memberId"));
        for(Topo topo : (ArrayList<Topo>) request.getAttribute("allTopos")) {
            if(topo.getId() == Integer.parseInt(request.getParameter("id"))) {
                return true;
            }
        }
        return false;
    }
}
