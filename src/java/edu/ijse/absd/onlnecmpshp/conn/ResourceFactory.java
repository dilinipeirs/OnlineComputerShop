/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.conn;

import edu.ijse.absd.onlnecmpshp.conn.impl.MysqlResouceConnection;

/**
 *
 * @author dilin
 */
public class ResourceFactory {

    private static ResourceConnection resourceConnection;

    public static ResourceConnection getResourceConnection() {
        if (null == resourceConnection) {
            resourceConnection = new MysqlResouceConnection();
        }
        return resourceConnection;
    }

}
