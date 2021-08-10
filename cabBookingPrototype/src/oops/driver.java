/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oops;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tulaib pc
 */
public class driver {
    String[] loc;
    int initial;
    int finl;
    int ind;
    int ct;
    int dist[]={0,5,13,23,30};
     int walletmoney;
   connectDrv cn=new connectDrv();
   Connection con=cn.con;
   Connection conn=null;
   PreparedStatement pst=null;
   PreparedStatement pst1=null;
   ResultSet rs=null;
   
   
    public driver(){}
    public driver(String[] location,int initial,int finl){
        this.initial=initial;
        this.finl=finl;
        loc=location;
        ct=0;
        ind=-1;
        conn=signup.ConnectDb();
    }
    public void assign(int ind,int initial,int finl){   
          try {
                    String sql1 = "UPDATE driverinfo set "
                            + "" + "flag='" + 0 + "'"
                            + "where indx='" + ind + "'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.executeUpdate();                   
                    //JOptionPane.showMessageDialog(null, "updated flag to 0");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "flag not set to 0");
                }
        UpdateFlag(ind,Math.abs(ind-initial)+Math.abs(initial-finl));
        UpdateDriverLocation(loc[finl],ind);
    }
    public void assign1(int ind,int initial,int finl,String per,int cost){   
          try {
                    String sql1 = "UPDATE driverinfo set "
                            + "" + "flag='" + 0 + "'"
                            + "where indx='" + ind + "'";
                    pst1 = con.prepareStatement(sql1);
                    pst1.executeUpdate();                   
                    //JOptionPane.showMessageDialog(null, "updated flag to 0");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "flag not set to 0");
                }
        UpdateWallet(per,cost);  
        UpdateFlag1(ind,Math.abs(initial-finl),per,walletmoney);
        UpdateDriverLocation(loc[finl],ind);
    }
    public int cost(int ind,int initial,int finl){
        if(ind==-1)
            return 0;
        else{ 
            int cst=(Math.abs(initial-finl))*100;
            return cst;
        }    
    }
    int flag;
    public int getIndex(String in){                                              //gives the index of available driver
        
        try {
            String sql = "select * from driverinfo where location='" + in + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                flag=rs.getInt("flag");
                if(flag==1){
                    ind = rs.getInt("indx");                
                }
            }
        } catch (Exception ie) {
            JOptionPane.showMessageDialog(null, "no driver available");
        }
        return ind;
    }
    public void UpdateFlag(int ind,int duration){        
        newthread newt=new newthread(ind,duration);                    
    }
    public void UpdateFlag1(int ind,int duration,String per,int walletmoney){        
        newthread1 newt=new newthread1(ind,duration,per,walletmoney);                    
    }
    
    public void UpdateDriverLocation(String dest,int index){
        try {
            String sql1 = "UPDATE driverinfo set "
                    + "" + "location='" +dest+ "'"
                    + "where indx='" + ind + "'";
            pst1 = con.prepareStatement(sql1);
            pst1.executeUpdate();                   
            //JOptionPane.showMessageDialog(null, "updated driver dest");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Did not update the driver destination");
        }  
    }
    public int getDrvIndex(String in){
         try {
            String sql = "select * from driverinfo where location='" + in + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                flag=rs.getInt("flag");
                if(flag==1){
                    ind = rs.getInt("indx");                
                }
            }
        } catch (Exception ie) {
            JOptionPane.showMessageDialog(null, "no driver available");
        }
         return ind;
    }
    public void UpdateWallet(String userId,int cost){        
        try{
               
                String sql1="select * from userinfo where userId='"+userId+"'";
                pst=conn.prepareStatement(sql1);                    
                rs=pst.executeQuery();
                if(rs.next()){
                    walletmoney=rs.getInt("money");
                    walletmoney-=cost;
                }                
                String sql="UPDATE userinfo set "
                        + ""+"money='"+walletmoney+"'" + 
                        "where userId='"+userId+"'";
                pst=conn.prepareStatement(sql);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"money added sucessfully!!");                                         
                }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                }
    }
}

class newthread implements Runnable{
    int ind;
    int duration;
    public newthread(int ind,int duration){
        this.ind=ind;
        this.duration=duration;
        t=new Thread(this,"driverThread");
        t.start();
    }
    
    connectDrv cn=new connectDrv();
    Connection con=cn.con;
    PreparedStatement pst1=null;
    
    Thread t;
    @Override
    public void run(){
            
           try {
            Thread.sleep(duration*5000);   
            String sql1 = "UPDATE driverinfo set "
                    + "" + "flag='" + 1 + "'"
                    + "where indx='" + ind + "'";
            pst1 = con.prepareStatement(sql1);
            pst1.executeUpdate();                   
            //JOptionPane.showMessageDialog(null, "updated flag to 1");
        }catch(InterruptedException ie){
            JOptionPane.showMessageDialog(null, ie);
        }    
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "flag not set to 1");
        } 
    }
}


class newthread1 implements Runnable{
    int ind;
    int duration;
    String per;
    int cost;
    
    
    public newthread1(int ind,int duration,String per,int walletmoney){
        this.ind=ind;
        this.duration=duration;
        this.per=per;
        this.cost=walletmoney;
        t=new Thread(this,"driverThread");
        t.start();
    }
    
    connectDrv cn=new connectDrv();
    Connection con=cn.con;
    PreparedStatement pst1=null;
    
    Thread t;
    @Override
    public void run(){ 
           rideconfirm rc=new rideconfirm(1,per,cost);
           rc.setVisible(true);
           try {
            Thread.sleep(duration*5000);   
            String sql1 = "UPDATE driverinfo set "
                    + "" + "flag='" + 1 + "'"
                    + "where indx='" + ind + "'";
            pst1 = con.prepareStatement(sql1);
            pst1.executeUpdate();                   
            //JOptionPane.showMessageDialog(null, "YOUR RIDE HAS BEEN COMPLETED");
            rc.jButton2.setText("Your Ride has been Completed.Click Here to Exit");
        }catch(InterruptedException ie){
            JOptionPane.showMessageDialog(null, ie);
        }    
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "flag not set to 1");
        } 
    }
}