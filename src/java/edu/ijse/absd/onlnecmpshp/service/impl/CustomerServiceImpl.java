/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.service.impl;

import edu.ijse.absd.onlnecmpshp.dao.DaoFactory;
import edu.ijse.absd.onlnecmpshp.dao.ItemDao;
import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import edu.ijse.absd.onlnecmpshp.model.ItemModel;
import edu.ijse.absd.onlnecmpshp.service.CustomerService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilin
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public boolean purchaseGoods(List<ItemDto> items) {
        ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoEnum.ITEM);
        System.out.println("items size"+items.size());
        int itemCount = items.size();
        int i = 0;
        for (ItemDto item : items) {
            try {
                ItemModel itemModel = new ItemModel(item.getItemCode(), item.getDesc(), item.getQtyOnHand(), item.getUnitPrice());
                i += itemDao.update(itemModel);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return itemCount==i;
    }

}
