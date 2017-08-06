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
import java.text.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lll2yu
 */
public class entry_form extends javax.swing.JFrame {
    Connection ham;
    PreparedStatement egg;
    /**
     * Creates new form entry_form
     */
    public entry_form() {
        slot_sorter();
        add_box();
        initComponents();
    }
    public void add_box(){
        cb2.setModel(new DefaultComboBoxModel<Integer>(two.toArray(new Integer[0])));
        getContentPane().add(cb2);
        cb2.setBounds(510, 320, 280, 25);
    }
    Connection dum;
            PreparedStatement dang;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cb1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setBounds(new java.awt.Rectangle(530, 240, 250, 50));
        jDialog1.setMinimumSize(new java.awt.Dimension(350, 200));
        jDialog1.getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel6.setText("      Sure to continue?");
        jLabel6.setBounds(20,30,100,30);
        jDialog1.getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 30, 400, 30);

        jButton3.setText("Yes");
        jButton3.setMinimumSize(new java.awt.Dimension(58, 25));
        jButton3.setPreferredSize(new java.awt.Dimension(58, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton3);
        jButton3.setBounds(50, 100, 58, 25);

        jButton4.setText("No");
        jButton4.setMinimumSize(new java.awt.Dimension(58, 25));
        jButton4.setPreferredSize(new java.awt.Dimension(58, 25));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton4);
        jButton4.setBounds(220, 100, 58, 25);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(240, 90, 0, 0));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setName("parkalot"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setText("Entry Form");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 20, 160, 31);

        jLabel2.setText("Owner's Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 110, 150, 30);

        jLabel3.setText("Vehicle Reg. No");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 180, 140, 30);

        jLabel4.setText("Car Type");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 250, 120, 30);

        jLabel5.setText("Slot No.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 320, 130, 30);
        getContentPane().add(tf1);
        tf1.setBounds(510, 110, 280, 30);
        getContentPane().add(tf2);
        tf2.setBounds(510, 180, 280, 30);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 480, 170, 29);

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 480, 170, 29);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select one--", "Sedan", "Suv", "Hatchback", "Minivan" }));
        getContentPane().add(cb1);
        cb1.setBounds(510, 250, 280, 27);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/frame_bg.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 900, 640);

        jMenu2.setText("Actions");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Jump to exit form");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tf1.setText("");
        tf2.setText("");
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.setVisible(true);
        temp();
    }//GEN-LAST:event_jButton1ActionPerformed
    ArrayList<Integer> list=new ArrayList<Integer>();
    ArrayList<Integer> two =new ArrayList<Integer>();
    void set_two(){
        get_i();
        for(int j=1;j<=i;j++){
            two.add(j);
        }
    }
    int i;
    void get_i(){
        ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select * from slots ");			
 				while (rlt.next()) {      
  					 i=(Integer.parseInt(rlt.getString(1)));                                 
				}
		}
		catch(Exception e){}
    }
	void slot_sorter(){
            set_two();
        ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select slot_no from entry ");			
 				while (rlt.next()) {      
  					 list.add(Integer.parseInt(rlt.getString(1)));                                 
				}
		}
		catch(Exception e){}
        two.removeAll(list);
}
        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        perma();
        jDialog1.dispose();
        new confirmation_page().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed
    String sIs,sIs2;
    void perma(){
        String x1,x2,x3,x5,x6;
        int x4;
        x1=tf1.getText();
        x2=tf2.getText();
        Object sI=cb1.getSelectedItem();
        if (sI != null)
			{
    				sIs = sI.toString();
                        }
        x3=sIs;
        Object sI2=cb2.getSelectedItem();
        if (sI2 != null)
			{
    				sIs2 = sI2.toString();
                        }
        x4=Integer.parseInt(sIs2);
        
        java.util.Date date = new java.util.Date( );
            SimpleDateFormat ft =new SimpleDateFormat ("HHmm");
            SimpleDateFormat fft =new SimpleDateFormat ("yyyy.MM.dd");
            x5=ft.format(date);
            x6=fft.format(date);
        try{
            Class.forName("add your jdbc Driver");
            ham=DriverManager.getConnection("add your connectin info");
            egg=ham.prepareStatement("insert entry value(?,?,?,?,?,?)");
            egg.setString(1, x1);
            egg.setString(2, x2);
            egg.setString(3, x3);
            egg.setInt(4, x4);
            egg.setString(5, x5);
            egg.setString(6, x6);
            egg.executeUpdate();
        }
        catch(Exception e){}  
    }
    
  void temp(){
        try{
            int s;
            Object sI2=cb2.getSelectedItem();
        if (sI2 != null)
			{
    				sIs2 = sI2.toString();
                        }
        s=Integer.parseInt(sIs2);
            Class.forName("add your jdbc Driver");
            dum=DriverManager.getConnection("add your connectin info");
            dang=dum.prepareStatement("insert into temp(no) values ("+s+")");
            dang.executeUpdate();
            
        }
        catch(Exception e){} 
        
        
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jDialog1.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new exit_form().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new login_page().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entry_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entry_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<Integer> cb2 = new javax.swing.JComboBox <Integer>();
}