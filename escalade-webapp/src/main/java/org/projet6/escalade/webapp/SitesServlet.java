package org.projet6.escalade.webapp;

import org.projet6.escalade.consumer.contract.dao.SiteDao;
import org.projet6.escalade.model.bean.site.Site;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class SitesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/org.projet6.escalade.webapp/applicationContext.xml");
        SiteDao siteDao = (SiteDao) vApplicationContext.getBean("siteDao");

        this.getServletContext().getRequestDispatcher("/jsp/sites.jsp").forward(request, response);

    }
}
