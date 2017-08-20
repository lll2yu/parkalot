/*
 * Copyright (C) 2017 lll2yu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package parkalot;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lll2yu
 */
public class park_edit extends javax.swing.JFrame {

    /**
     * Creates new form park_edit
     */
    public park_edit() {
        add_box();
        initComponents();
    }
    void add_box(){
        get_car();
        cb1.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
         getContentPane().add(cb1);
         cb1.setBounds(170, 200, 180, 30);
    }
    
    ArrayList<String> list=new ArrayList<String>();
    void get_car(){
        ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select name from rates ");			
 				while (rlt.next()) {      
  					 list.add(rlt.getString(1));                                 
				}
		}
		catch(Exception e){}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(445, 120, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Set Parking Rules");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 40, 200, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/settings-19-64.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 30, 64, 64);

        jLabel3.setText("Set Parking Rates :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 200, 150, 30);

        jButton1.setText("Add/Remove car types");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 110, 190, 50);

        jButton2.setText("Set Rate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 260, 120, 30);

        jButton3.setText("Set Slots");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(210, 380, 120, 30);

        jLabel4.setText("Set no. of parking slots available");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 330, 250, 30);
        getContentPane().add(tf1);
        tf1.setBounds(360, 200, 60, 30);

        jLabel5.setText("per hour");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 200, 80, 30);
        getContentPane().add(tf2);
        tf2.setBounds(310, 330, 81, 30);

        jButton4.setText("Done");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(230, 430, 80, 30);

        label.setForeground(new java.awt.Color(255, 39, 0));
        getContentPane().add(label);
        label.setBounds(40, 300, 430, 24);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/frame_bg_500.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        set_rate();
    }//GEN-LAST:event_jButton2ActionPerformed
    float x1;
String x2;
    void set_rate(){
        x1=(Float.parseFloat(tf1.getText()));
        Object sI=cb1.getSelectedItem();
        if (sI != null)
			{
    				x2 = sI.toString();
                        }
        try{
            ResultSet re;
            Class.forName("add your jdbc Driver");
		Connection ce=DriverManager.getConnection("add your connectin info");
		Statement se=ce.createStatement();
		re=se.executeQuery("update rates set price="+x1+"where name='"+x2+"'");
                tf1.setText("Done");
            }
        catch(Exception e){}  
    }
    
    String s1;
    void set_slots(){
        empty();
        s1=tf2.getText();
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("insert into slots(no) values('"+s1+"')");
		}
	catch(Exception e){}
        tf2.setText("Done");
    }
    void empty(){
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("delete from slots");
		}
	catch(Exception e){}
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new set_car().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       set_slots(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new conf_page().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        get_oldRate();
    }
    String oldRate;
    void get_oldRate(){
        Object sI=cb1.getSelectedItem();
        String su = null;
        if (sI != null)
			{
    				su = sI.toString();
                        }
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("select price from rates where name='"+su+"'");
                            while(re.next()){
                                oldRate=re.getString(1);
                            }
                        label.setText("Present rate is "+oldRate);
		}
	catch(Exception e){}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(park_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(park_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(park_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(park_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new park_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<String> cb1 = new javax.swing.JComboBox <String>();
}
