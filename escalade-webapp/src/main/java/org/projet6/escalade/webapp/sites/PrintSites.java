package org.projet6.escalade.webapp.sites;

import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintSites {

    public void getSites(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");
        List<Site> sites = siteDao.getListSites();
        Iterator<Site> it = sites.iterator();
        ArrayList<Site> allSites = new ArrayList<Site>();
        while(it.hasNext()) {
            allSites.add(it.next());
        }
        request.setAttribute("allSites", allSites);
    }

    public void getSearchedSites(HttpServletRequest request) {
        String search = request.getParameter("search");
        String field = request.getParameter("field");

        request.setAttribute("search", search);
        request.setAttribute("field", field);

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");
        List<Site> sites = siteDao.getListSearchedSites(search, field);
        request.setAttribute("sites", sites);
    }

    public void getOneSite(HttpServletRequest request) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");
        Site site =  siteDao.getSearchedSite(request.getParameter("site"));
        request.setAttribute("site", site);
    }
}
