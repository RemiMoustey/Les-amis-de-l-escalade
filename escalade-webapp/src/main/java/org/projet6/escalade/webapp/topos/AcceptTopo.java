package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.TopoDao;
import org.projet6.escalade.model.bean.topo.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AcceptTopo {
    public void acceptTopo(int idTopo) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        TopoDao topoDao = (TopoDao) vApplicationContext.getBean("topoDao");

        topoDao.updateReservation(idTopo);
    }
}
