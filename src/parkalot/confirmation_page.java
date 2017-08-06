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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.sql.*;
/**
 *
 * @author lll2yu
 */
public class confirmation_page extends javax.swing.JFrame implements Printable{

    /**
     * Creates new form confirmation_page
     */
    public confirmation_page() {
        initComponents();
        get_values();
    }
     String t;
    void get_temp(){
        ResultSet r;
        try{
			Class.forName("add your jdbc Driver");
			Connection cs=DriverManager.getConnection("add your connectin info");
			Statement s=cs.createStatement();
			r=s.executeQuery("Select * from temp");
			while(r.next()){
				t=r.getString(1);
			}
		}
		catch(Exception e){}
    } 
    void get_values(){
        get_temp();
        ResultSet result;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			result=stat.executeQuery("Select * from entry where slot_no="+t);
			while(result.next()){
				l1.setText(result.getString(1));
                                l2.setText(result.getString(2));
                                l3.setText(result.getString(3));
                                l4.setText(result.getString(4));
                                l5.setText(result.getString(5));
                                l6.setText(result.getString(6));
			}
		}
		catch(Exception e){}
    }
    void empty_temp(){
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("delete from temp");
            }
		catch(Exception e){}
    }
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        getContentPane().printAll(g);

        return PAGE_EXISTS;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(380, 90, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(600, 640));
        setPreferredSize(new java.awt.Dimension(600, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("     Reciept*");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 20, 201, 30);

        jLabel2.setText("Owner's Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 90, 130, 20);

        jLabel3.setText("Vehicle Reg. No : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 150, 140, 20);

        jLabel4.setText("Car Type :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 210, 110, 20);

        jLabel5.setText("Slot No. :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 270, 110, 20);

        jLabel6.setText("Entry Time :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 330, 120, 20);
        getContentPane().add(l1);
        l1.setBounds(360, 90, 190, 30);
        getContentPane().add(l2);
        l2.setBounds(360, 150, 150, 20);
        getContentPane().add(l3);
        l3.setBounds(360, 210, 170, 20);
        getContentPane().add(l4);
        l4.setBounds(360, 270, 140, 20);
        getContentPane().add(l5);
        l5.setBounds(360, 330, 90, 30);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 510, 100, 29);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 510, 100, 29);

        jLabel7.setText("Date :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 380, 130, 30);
        getContentPane().add(l6);
        l6.setBounds(360, 380, 220, 30);

        jLabel8.setText("Hours");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(460, 330, 180, 30);

        jLabel9.setText("* this reciept is valid for 24 hours only.");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 440, 300, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new entry_form().setVisible(true);
        empty_temp();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {}
         }
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
            java.util.logging.Logger.getLogger(confirmation_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmation_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmation_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmation_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confirmation_page().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    // End of variables declaration//GEN-END:variables

}
