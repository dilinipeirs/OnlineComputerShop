/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.conn.impl;

import edu.ijse.absd.onlnecmpshp.conn.ResourceConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dilin
 */
public class MysqlResouceConnection implements ResourceConnection {

    private Connection conn;

    @Override
    public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        FileReader fileReader = null;
        try {
            Properties properties=new Properties();
            InputStream inputStream=null;
            inputStream=new FileInputStream("F:\\IJSE\\IJSE - Semester 3\\Namal Sir\\Projects\\Mid Semester Evaluation\\Online Computer Shop\\Project\\OnlineComputerShop\\settings\\dbProperties.properties");
            properties.load(inputStream);
//            System.out.println(new File("src").isDirectory());
//            fileReader = new FileReader(new File("/settings/dbProperties.properties"));
//            System.out.println(fileReader);
            Class.forName("com.mysql.jdbc.Driver");
//            Properties properties = new Properties();
//            properties.load(fileReader);
            String url = "jdbc:mysql://" + properties.getProperty("ip") + "/" + properties.getProperty("database");
            conn = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlResouceConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MysqlResouceConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(MysqlResouceConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(MysqlResouceConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(MysqlResouceConnection.class.getName()).log(Level.SEVERE, null, ex);
//                throw ex;
//            }
        }
        return conn;
    }

}
