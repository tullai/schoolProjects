/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oops;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class loginbut extends javax.swing.JFrame {
   int i=0;
   int a=0;
   String  walletmoney;
   String per="";
   String[] location={"A","B","C","D","E"};
   
   connectDrv cn=new connectDrv();
   Connection con=cn.con;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public loginbut() {
        initComponents();
    }
    public loginbut(String p,int money){
        a+=money;
        walletmoney=Integer.toString(a);
        per=per+p;
        initComponents();
        conn=signup.ConnectDb();
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel19.setText("jLabel19");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cab booking");
        setMinimumSize(new java.awt.Dimension(500, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("ENTER PICK UP POINT:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("ENTER DROP LOCATION:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 109, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 109, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("WALLET MONEY:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 29, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(walletmoney);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 29, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 0, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("BOOK RIDE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 109, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText(per);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 6, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setText("Hi");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Following are the available locations for our service:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 64, 379, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("location 1");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("location 2");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("location 3");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("location 4");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("location 5");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setText("A");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 145, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 153));
        jLabel15.setText("B");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 145, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 204, 0));
        jLabel16.setText("C");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 145, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 102));
        jLabel17.setText("D");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 145, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("E");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 145, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\tulaib pc\\Downloads\\Pics\\map-icon-png-5.jpg")); // NOI18N
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 130, 130));

        jMenu1.setForeground(new java.awt.Color(204, 0, 204));
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tulaib pc\\Downloads\\Pics\\edit.png")); // NOI18N
        jMenu1.setText("My Profile");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\tulaib pc\\Downloads\\Pics\\addemployee.png")); // NOI18N
        jMenuItem1.setText("view profile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\tulaib pc\\Downloads\\Pics\\add.png")); // NOI18N
        jMenuItem3.setText("add money");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\tulaib pc\\Downloads\\Pics\\exit.png")); // NOI18N
        jMenuItem4.setText("Log out");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
               try{
            String sql="SELECT * FROM userinfo where userId='"+per+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String ae=rs.getString("username");
                String b=rs.getString("userId");
                String c=rs.getString("phoneNumber");
                String d=rs.getString("emailId");
                int money=rs.getInt("money");
                setVisible(false);
                new viewProfile(ae,b,c,d,money).setVisible(true);
            }
        }catch(Exception e){}    
        
       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            try{
            String sql="SELECT * FROM userinfo where userId='"+per+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String b=rs.getString("userId");
                int money=rs.getInt("money");
                new addMoney(b,money).setVisible(true);
                setVisible(false);                
            }
        }catch(Exception e){} 
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       try {
           String sql="update userinfo set "
                   + ""+"flag='"+1+"'"+
                   "where userId='"+per+"'";
           pst=conn.prepareStatement(sql);
           pst.executeUpdate();
           setVisible(false);
          // new mainpage().setVisible(true);
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
       }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
           String sql="update userinfo set "
                   + ""+"flag='"+1+"'"+
                   "where userId='"+per+"'";
           pst=conn.prepareStatement(sql);
           pst.executeUpdate();
           //setVisible(false);
          // new mainpage().setVisible(true);
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
       }
    }//GEN-LAST:event_formWindowClosed
    String loci,locf;
    int j,k,in=-1,fn=-1,cost,val,index,t=0;
    int booking=0,drvindex;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
           if(!jTextField1.getText().equals(jTextField2.getText()) && !jTextField1.getText().equals("") && !jTextField2.getText().equals("")){   
                for(i =0; i<location.length; i++){
                    if(jTextField1.getText().equals(location[i])){
                         loci = location[i];
                         in = i;
                    } 
                    if(jTextField2.getText().equals(location[i])){
                        locf = location[i];
                        fn = i;
                    }    
                }
                if(in==-1 ||fn==-1){
                    JOptionPane.showMessageDialog(null, "enter a valid location");
                    t=32;
                }
             driver drv=new driver(location,in,fn);
             index=drv.getIndex(loci);
             cost=drv.cost(index,in,fn);
            
             if(cost==0 && t!=32){
                 redistribute r= new redistribute(location);
                 r.redis();
                 JOptionPane.showMessageDialog(null, "no Driver is available\nInconvinece is regretted");
             }
             else if(cost!=0 && cost>a){
                 JOptionPane.showMessageDialog(null, "You do not have enough money in your wallet for the ride!!");
             }
             else if(cost!=0 && cost<=a){
                 drvindex=drv.getDrvIndex(loci);
                 
                 val=JOptionPane.showConfirmDialog(null,"The expected cost of the ride is "+cost+"\n click yes to confirm ride");
                 if(val==0){
                        try {
                         String sql = "select * from driverinfo where indx='" + drvindex + "'";
                         pst = con.prepareStatement(sql);                     
                         rs = pst.executeQuery();
                         if (rs.next()) {
                             String as = rs.getString("drivername");
                             String b = rs.getString("rating");
                             String c = rs.getString("VehicleId");
                             String d = rs.getString("mobileNo.");
                             JOptionPane.showMessageDialog(null,"you have been assigned a driver \n the name of driver is : "+as+
                                "\n Rating : "+ b +"\n Vehicle Id :"+c+"\nMobile Number :"+d);
                         }
                     } catch (SQLException e) {
                             JOptionPane.showMessageDialog(null, "waquar ka code");
                     } 
                    booking++;
                     if(booking==1){
                        booking=0;
                        redistribute r= new redistribute(location);
                        r.redis();
                    }
                    setVisible(false); 
                    drv.assign1(index,in, fn,per,cost);                                        
                                     
                 }
             }
             
        }
        else JOptionPane.showMessageDialog(null,"Error!!Please enter a valid location");
    }//GEN-LAST:event_jButton6ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
