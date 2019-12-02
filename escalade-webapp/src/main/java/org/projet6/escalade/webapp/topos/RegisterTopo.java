package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class RegisterTopo {
    public void createNewTopo(HttpServletRequest request, int memberId) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");
        Topo newTopo = new Topo();

        newTopo.setName(request.getParameter("name"));
        newTopo.setDescription(request.getParameter("description"));
        newTopo.setPlace(request.getParameter("place"));
        newTopo.setDate(request.getParameter("date"));
        if(request.getParameter("isAvailable") == null) {
            newTopo.setIsAvailable(false);
        }
        else {
            newTopo.setIsAvailable(true);
        }
        newTopo.setMemberId(memberId);

        topoDao.insertTopo(newTopo);
    }
}
