/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oops;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author tulaib pc
 */
public class redistribute {
    
   connectDrv cn=new connectDrv();
   Connection con=cn.con;
   PreparedStatement pst=null;
   ResultSet rs=null; 
   
   driver drv=new driver();
   int ind;
   //driver drv=new driver();
      String[] location;
      int[] count=new int[5];
      redistribute(String[] location){
          this.location=location;          
      }
      
      protected void redis(){
        try {
            String sql="SELECT COUNT(indx) FROM driverinfo WHERE location='A'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            count[0]=rs.getInt("COUNT(indx)");
            //JOptionPane.showMessageDialog(null,"count of A "+count[0]);
            String sql1="SELECT COUNT(indx) FROM driverinfo WHERE location='B'";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            rs.next();
            count[1]=rs.getInt("COUNT(indx)");
            //JOptionPane.showMessageDialog(null,"count of B "+count[1]);
            String sql2="SELECT COUNT(indx) FROM driverinfo WHERE location='C'";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            rs.next();
            count[2]=rs.getInt("COUNT(indx)");
            //JOptionPane.showMessageDialog(null,"count of C "+count[2]);
            String sql3="SELECT COUNT(indx) FROM driverinfo WHERE location='D'";
            pst = con.prepareStatement(sql3);
            rs = pst.executeQuery();
            rs.next();
            count[3]=rs.getInt("COUNT(indx)");
            //JOptionPane.showMessageDialog(null,"count of D "+count[3]);
            String sql4="SELECT COUNT(indx) FROM driverinfo WHERE location='E'";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();
            rs.next();
            count[4]=rs.getInt("COUNT(indx)");
            //JOptionPane.showMessageDialog(null,"count of E "+count[4]);
        } catch (SQLException ex) {
            Logger.getLogger(redistribute.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<4;i++){
            ind=-1;
            if(count[i]!=2){
                for(int j=i+1;j<5;j++){
                    if(count[j]!=2){
                        if(count[i]>count[j]){
                            drv=new driver(location,i,j);
                            ind=drv.getIndex(location[i]);
                            if(ind!=-1){
                            drv.assign(ind,i,j);}
                        }
                        else if(count[j]>count[i]){
                            drv=new driver(location,j,i);
                            ind=drv.getIndex(location[j]);
                            if(ind!=-1){
                            drv.assign(ind, j, i);}
                        }
                        
                    }
                }
            }
        }
      }
}
