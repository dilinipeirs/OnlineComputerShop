/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.dao;

import edu.ijse.absd.onlnecmpshp.model.SuperModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dilin
 */
public interface SuperDao<T extends SuperModel> {

    int insert(T t) throws ClassNotFoundException, SQLException, IOException;

    int update(T t) throws ClassNotFoundException, SQLException, IOException;

    int delete(T t) throws ClassNotFoundException, SQLException, IOException;

    ArrayList<T> selectAll() throws ClassNotFoundException, SQLException, IOException;

}
