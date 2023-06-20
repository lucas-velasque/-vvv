/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lgcp1
 */
public class MysqlConnection {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (Exception e) {
            e.printStackTrace();  
        }
        
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scvp","root","admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
        
    }
}
