/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.dao.impl;

import edu.ijse.absd.onlnecmpshp.conn.ResourceConnection;
import edu.ijse.absd.onlnecmpshp.conn.ResourceFactory;
import edu.ijse.absd.onlnecmpshp.dao.UserDao;
import edu.ijse.absd.onlnecmpshp.model.UserModel;
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
public class UserDaoImpl implements UserDao {

    @Override
    public int insert(UserModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection conn = connection.getConnection();
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO USER VALUES(?,SHA1(?),?);");
            prepareStatement.setObject(1, t.getUsername());
            prepareStatement.setObject(2, t.getPassword());
            prepareStatement.setObject(3, t.getMobile());
            res = prepareStatement.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int update(UserModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();

            Connection con = connection.getConnection();
            String sql = "UPDATE USER SET PASSWORD=SHA1(?), MOBILE=? WHERE USERNAME=?";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setObject(1, t.getPassword());
            prepareStatement.setObject(2, t.getMobile());
            prepareStatement.setObject(3, t.getUsername());
            res = prepareStatement.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int delete(UserModel t) throws ClassNotFoundException, SQLException, IOException {
        int res = -1;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection con = connection.getConnection();
            Statement stm = con.createStatement();
            res= stm.executeUpdate("DELETE FROM USER WHERE USERNAME='" + t.getUsername() + "'");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public ArrayList<UserModel> selectAll() throws ClassNotFoundException, SQLException, IOException {
        ArrayList<UserModel> users = null;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection con = connection.getConnection();
            Statement stm = con.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM USER");
            users = new ArrayList<>();
            while (i.next()) {
                users.add(new UserModel(i.getString(1), i.getString(2), i.getString(3)));
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return users;
    }

    @Override
    public UserModel select(UserModel t) throws ClassNotFoundException, SQLException, IOException {
        UserModel user = null;
        try {
            ResourceConnection connection = (ResourceConnection) ResourceFactory.getResourceConnection();
            Connection con = connection.getConnection();

            PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM USER WHERE USERNAME=?");
            prepareStatement.setObject(1, t.getUsername());
            ResultSet i = prepareStatement.executeQuery();
            if (null != i) {
                while (i.next()) {
                    user = new UserModel(i.getString(1), i.getString(2), i.getString(3));
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (IOException ex) {
            Logger.getLogger(UserDaoImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return user;
    }

}
