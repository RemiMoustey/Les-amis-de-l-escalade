package org.projet6.escalade.webapp.sites;

import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficialSites {
    public void makeOfficial(int id, boolean setOfficial) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");
        siteDao.updateOfficial(id, setOfficial);
    }
}
