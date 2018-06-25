/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.dao;

import edu.ijse.absd.onlnecmpshp.model.UserModel;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author dilin
 */
public interface UserDao extends SuperDao<UserModel> {

    UserModel select(UserModel t) throws ClassNotFoundException, SQLException, IOException;

    
}
