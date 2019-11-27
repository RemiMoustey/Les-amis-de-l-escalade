package org.projet6.escalade.webapp.sites;

import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class RegisterSite {
    public String addSector(HttpServletRequest request, String parameter, String listSectors) {
        if(request.getParameter(parameter) != null) {
            listSectors += ", " + request.getParameter(parameter);
        }
        return listSectors;
    }

    public void registerNewSite(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");
        Site newSite = new Site();
        newSite.setName(request.getParameter("name"));
        newSite.setDescription(request.getParameter("description"));
        newSite.setLength(Integer.parseInt(request.getParameter("length")));
        newSite.setPlace(request.getParameter("place"));
        newSite.setGrade(request.getParameter("grade"));
        newSite.setNumberOfWays(request.getParameter("numberOfWays"));
        newSite.setNumberOfSectors(Integer.parseInt(request.getParameter("numberOfSectors")));
        String sectors = request.getParameter("sector1");
        for(int i = 1; i < 5; i++) {
            sectors = addSector(request, "sector" + (i + 1), sectors);
        }
        newSite.setSectors(sectors);
        siteDao.insertSite(newSite);
    }
}
