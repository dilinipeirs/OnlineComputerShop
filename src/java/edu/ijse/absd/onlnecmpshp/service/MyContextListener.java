/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author dilin
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CustomerService customerService = (CustomerService) ServiceFactory.getServiceFactory().getService(ServiceFactory.DaoEnum.CUSTOMER);
        List<ItemDto> showItems = customerService.showItems();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("itemList", showItems);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         sce.getServletContext().removeAttribute("itemList");
    }
}
