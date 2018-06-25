/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author dilin
 */
public interface ResourceConnection {
    Connection getConnection() throws ClassNotFoundException, IOException, SQLException ;
}
