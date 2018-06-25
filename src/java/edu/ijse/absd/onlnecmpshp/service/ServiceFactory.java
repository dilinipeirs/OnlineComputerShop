/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service;

import edu.ijse.absd.onlnecmpshp.service.impl.AdminServiceImpl;
import edu.ijse.absd.onlnecmpshp.service.impl.CustomerServiceImpl;

/**
 *
 * @author dilin
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public enum DaoEnum {
        ADMIN, CUSTOMER
    }

    public static ServiceFactory getServiceFactory() {
        if (null == serviceFactory) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(DaoEnum daoEnum) {
        switch (daoEnum) {
            case ADMIN:
                return new AdminServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
        }
        return null;
    }
}
