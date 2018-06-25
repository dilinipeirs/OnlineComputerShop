/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.dao;

import edu.ijse.absd.onlnecmpshp.dao.impl.ItemDaoImpl;
import edu.ijse.absd.onlnecmpshp.dao.impl.UserDaoImpl;

/**
 *
 * @author dilin
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    public enum DaoEnum {
        USER, ITEM
    }

    public static DaoFactory getDaoFactory() {
        if (null == daoFactory) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoEnum daoEnum) {
        switch (daoEnum) {
            case USER:
                return new UserDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
        }
        return null;
    }
}
