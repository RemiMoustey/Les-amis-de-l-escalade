package org.projet6.escalade.webapp.topos;

import org.projet6.escalade.consumer.contract.dao.AwaitingTopoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefuseTopo {
    public void refuseTopo(int idAwaitingTopo) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        AwaitingTopoDao awaitingTopoDao = (AwaitingTopoDao) vApplicationContext.getBean("awaitingTopoDao");

        awaitingTopoDao.deleteAwaitingTopo(idAwaitingTopo);
    }
}
