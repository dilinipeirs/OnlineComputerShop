/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.dao.impl;

import edu.ijse.absd.onlnecmpshp.conn.ResourceConnection;
import edu.ijse.absd.onlnecmpshp.conn.ResourceFactory;
import edu.ijse.absd.onlnecmpshp.dao.ItemDao;
import edu.ijse.absd.onlnecmpshp.model.ItemModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilin
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public int insert(ItemModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection conn = connection.getConnection();
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO ITEM VALUES(?,?,?,?);");
            prepareStatement.setObject(1, t.getItemCode());
            prepareStatement.setObject(2, t.getDesc());
            prepareStatement.setObject(3, t.getQtyOnHand());
            prepareStatement.setObject(4, t.getUnitPrice());
            res = prepareStatement.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int update(ItemModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();

            Connection con = connection.getConnection();
            String sql = "UPDATE ITEM SET DESCRIP=?, QTYONHAND=?, UNITPRICE=? WHERE ITEMCODE=?";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setObject(1, t.getDesc());
            prepareStatement.setObject(2, t.getQtyOnHand());
            prepareStatement.setObject(3, t.getUnitPrice());
            prepareStatement.setObject(4, t.getItemCode());
            res = prepareStatement.executeUpdate();
            System.out.println(res+"update");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int delete(ItemModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection con = connection.getConnection();
            Statement stm = con.createStatement();
            res = stm.executeUpdate("DELETE FROM ITEM WHERE ITEMCODE='" + t.getItemCode() + "'");
            System.out.println(res+"delete");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public ArrayList<ItemModel> selectAll() throws ClassNotFoundException, SQLException, IOException {
        ArrayList<ItemModel> items = null;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection con = connection.getConnection();
            Statement stm = con.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM ITEM");
            items = new ArrayList<>();
            while (i.next()) {
                items.add(new ItemModel(i.getString(1), i.getString(2), i.getInt(3), i.getDouble(4)));
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return items;
    }

}
