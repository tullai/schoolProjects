/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oops;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author tulaib pc
 */
public class connectDrv {
        Connection con;
        public connectDrv(){
            con=ConnectDrv();
        }
        public static Connection ConnectDrv(){
        try{
            String url="jdbc:mysql://localhost:3306/driverinfo?useLegacyDatetimeCode=false&serverTimezone=Asia/Kolkata";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,"root","");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
