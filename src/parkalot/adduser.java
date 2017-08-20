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
/**
 *
 * @author lll2yu
 */
public class adduser extends javax.swing.JFrame {

    /**
     * Creates new form adduser
     */
    public adduser() {
        initComponents();
    }
    void set_newdetails(){
    ResultSet rep;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement see=ce.createStatement();
			rep=see.executeQuery("insert into user_details(fname,login,address,pass) values ('"+s1+"'"+","+"'"+s2+"','"+s3+"','"+s4+"');");
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
        tf1 = new javax.swing.JTextField();
        pf1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(445, 120, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("parkalot"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Add new User");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 90, 150, 30);

        jLabel2.setText("Username :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 230, 140, 30);

        jLabel3.setText("Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 330, 130, 30);
        getContentPane().add(tf1);
        tf1.setBounds(260, 180, 170, 30);
        getContentPane().add(pf1);
        pf1.setBounds(260, 330, 170, 30);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 400, 100, 30);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 400, 100, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/if_user_318585.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(220, 30, 48, 48);

        jLabel6.setText("Address:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 280, 140, 30);
        getContentPane().add(tf3);
        tf3.setBounds(260, 280, 170, 30);

        jLabel7.setText("Full Name:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 180, 140, 30);
        getContentPane().add(tf2);
        tf2.setBounds(260, 230, 170, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/frame_bg_500.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String s1,s2,s3,s4;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      s1=tf1.getText();
        s2=tf2.getText();
        s3=tf3.getText();
        s4=pf1.getText();
        set_newdetails();
        dispose();
        new user_edit().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new user_edit().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adduser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    // End of variables declaration//GEN-END:variables
}
