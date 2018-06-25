/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service;

import edu.ijse.absd.onlnecmpshp.dao.DaoFactory;
import edu.ijse.absd.onlnecmpshp.dao.ItemDao;
import edu.ijse.absd.onlnecmpshp.dao.UserDao;
import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import edu.ijse.absd.onlnecmpshp.dto.UserDto;
import edu.ijse.absd.onlnecmpshp.model.ItemModel;
import edu.ijse.absd.onlnecmpshp.model.UserModel;
import edu.ijse.absd.onlnecmpshp.service.impl.AdminServiceImpl;
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
public interface SuperService {

    default boolean login(UserDto dto) throws ClassNotFoundException, SQLException, IOException {
        try {
            UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoEnum.USER);
            UserModel user = new UserModel(dto.getUsername(), dto.getPassword(), null);
            UserModel select = userDao.select(user);
            if (null != select) {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuperService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SuperService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    default public List<ItemDto> showItems() {
        ArrayList<ItemDto> items = new ArrayList<>();
        try {
            ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoEnum.ITEM);
            List<ItemModel> viewItems = itemDao.selectAll();

            for (ItemModel viewItem : viewItems) {
                items.add(new ItemDto(viewItem.getItemCode(), viewItem.getDesc(), viewItem.getQtyOnHand(), viewItem.getUnitPrice()));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
}
