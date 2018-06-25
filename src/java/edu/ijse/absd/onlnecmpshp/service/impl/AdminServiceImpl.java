/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service.impl;

import edu.ijse.absd.onlnecmpshp.dao.DaoFactory;
import edu.ijse.absd.onlnecmpshp.dao.ItemDao;
import edu.ijse.absd.onlnecmpshp.dao.UserDao;
import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import edu.ijse.absd.onlnecmpshp.dto.UserDto;
import edu.ijse.absd.onlnecmpshp.model.ItemModel;
import edu.ijse.absd.onlnecmpshp.model.UserModel;
import edu.ijse.absd.onlnecmpshp.service.AdminService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilin
 */
public class AdminServiceImpl implements AdminService {

    UserDao userDao;
    ItemDao itemDao;

    public AdminServiceImpl() {
        userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoEnum.USER);
        itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoEnum.ITEM);
    }

    @Override
    public boolean saveItem(ItemDto itemDto) {
        ItemModel itemModel = new ItemModel(itemDto.getItemCode(), itemDto.getDesc(), itemDto.getQtyOnHand(), itemDto.getUnitPrice());
        boolean res = false;
        try {
            res = (0 < itemDao.insert(itemModel));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }


    @Override
    public boolean editItem(ItemDto itemDto) {

        ItemModel itemModel = new ItemModel();
        itemModel.setDesc(itemDto.getDesc());
        itemModel.setQtyOnHand(itemDto.getQtyOnHand());
        itemModel.setUnitPrice(itemDto.getUnitPrice());

        boolean res = false;
        try {
            res = (0 < itemDao.update(itemModel));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean deleteItem(ItemDto itemDto
    ) {
        boolean res = false;
        try {

            ItemModel itemModel = new ItemModel();
            itemModel.setItemCode(itemDto.getItemCode());

            res = (0 < itemDao.delete(itemModel));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean saveUser(UserDto userDto) {
        int res = 0;
        try {
            UserModel userModel = new UserModel();
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(userDto.getPassword());
            userModel.setMobile(userDto.getMobile());

            res = userDao.insert(userModel);
            System.out.println("save user"+res);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (0 < res);
    }

    public boolean editUser(UserDto userDto) {
        int res = 0;
        try {
            UserModel userModel = new UserModel();
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(userDto.getPassword());
            userModel.setMobile(userDto.getMobile());

            res = userDao.update(userModel);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (0 < res);
    }

    public boolean removeUser(UserDto userDto) {
        int res = 0;
        try {
            UserModel userModel = new UserModel();
            userModel.setUsername(userDto.getUsername());

            res = userDao.delete(userModel);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (0 < res);
    }

    public ArrayList<UserDto> showUsers() {
        ArrayList<UserDto> users = null;
        try {
            ArrayList<UserModel> viewUsers = userDao.selectAll();
            users = new ArrayList<>();
            for (UserModel viewUser : viewUsers) {
                users.add(new UserDto(viewUser.getUsername(), viewUser.getPassword(), viewUser.getMobile()));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

}
