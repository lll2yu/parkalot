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
import java.text.SimpleDateFormat;
/**
 *
 * @author lll2yu
 */
public class exit_receipt extends javax.swing.JFrame implements Printable{

    /**
     * Creates new form exit_receipt
     */
    public exit_receipt() {
        initComponents();
        get_valuees();
    }
    String t;
    void get_temp(){
        ResultSet r;
        try{
			Class.forName("add your jdbc Driver");
			Connection cs=DriverManager.getConnection("add your connectin info");
			Statement s=cs.createStatement();
			r=s.executeQuery("Select * from tempe");
			while(r.next()){
				t=r.getString(1);
			}
		}
		catch(Exception e){}
    }
    
    public void get_valuees(){
        java.util.Date date = new java.util.Date( );
            SimpleDateFormat ft =new SimpleDateFormat ("HHmm");
        get_temp();
        ResultSet result;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			result=stat.executeQuery("Select * from entry where reg_no='"+t+"'");
			while(result.next()){
				l1.setText(result.getString(1));
                                l2.setText(result.getString(2));
                                l3.setText(result.getString(3));
                                l4.setText(result.getString(4));
                                l5.setText(result.getString(5));
                                l7.setText(result.getString(6));
			}
		}
		catch(Exception e){}
        l6.setText(ft.format(date));
        reg=l3.getText();
        time_fn();
        calculate();
        
    }
    int parktime;
    void time_fn(){
    String time1 =l5.getText();
    String time2 = l6.getText();
    String tm1 = String.format("%02d", Integer.parseInt(time1));
    String tm2 = String.format("%02d", Integer.parseInt(time2));

    String hrs1 = time1.substring(0, 2);
    String min1 = time1.substring(2, 4);
    String hrs2 = time2.substring(0, 2);
    String min2 = time2.substring(2, 4);

    if (Integer.parseInt(time1) < Integer.parseInt(time2)) {
        int minDiff = Integer.parseInt(min2) - Integer.parseInt(min1);
        int hrsDiff = Integer.parseInt(hrs2) - Integer.parseInt(hrs1);
        if (minDiff < 0) {
            minDiff += 60;
            hrsDiff--;
        }
            parktime=hrsDiff*60 +minDiff;
    } 
    else {
        int minDiff = Integer.parseInt(min1) - Integer.parseInt(min2);
        int hrsDiff = Integer.parseInt(hrs1) - Integer.parseInt(hrs2);
        if (minDiff < 0) {
            minDiff += 60;
            hrsDiff--;
        }
            parktime=hrsDiff*60 +minDiff;
    }
    }
    String reg;
    public void calculate(){
        float value;
        if("Hatchback".equals(reg)){
            lap="Hatchback";
            get_rates();
            value=(float) (((parktime))*ra);
        l8.setText(String.valueOf(value));
        }
        else if("Sedan".equals(reg)){
            lap="Sedan";
            get_rates();
        value=(float) (((parktime))*ra);
        l8.setText(String.valueOf(value));
    }
        else if("Suv".equals(reg)){
            lap="Suv";
            get_rates();
            value=(float) (((parktime))*ra);
        l8.setText(String.valueOf(value));
        }
        else if("Minivan".equals(reg)){
            lap="Minivan";
            get_rates();
            value=(float) (((parktime))*ra);
        l8.setText(String.valueOf(value));
        }        
    }
    String lap;
    float ra;
    void get_rates(){
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("select price from rates where name='"+lap+"'");
                        while(re.next()){
				ra=re.getFloat(1);
                            }
		}
		catch(Exception e){}
    }
    void empty_tempe(){
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("delete from tempe");
		}
		catch(Exception e){}
    }
    void empty_table(){
        get_temp();
        ResultSet re;
        try{
			Class.forName("add your jdbc Driver");
			Connection ce=DriverManager.getConnection("add your connectin info");
			Statement se=ce.createStatement();
			re=se.executeQuery("delete from entry where reg_no='"+t+"'");
		}
		catch(Exception e){}
        empty_tempe();
    }
    void fill_record(){
        String x1,x2,x3,x5,x6,x7;
        int x4;
        float x8;
        x1=l1.getText();
        x2=l2.getText();
        x3=l3.getText();
        x4=Integer.parseInt(l4.getText());
        x5=l5.getText();
        x6=l6.getText();
        x7=l7.getText();
        x8=Float.parseFloat(l8.getText());
        try{
            Class.forName("add your jdbc Driver ");
            Connection ham=DriverManager.getConnection("add your connectin info");
            PreparedStatement egg=ham.prepareStatement("insert record value(?,?,?,?,?,?,?,?)");
            egg.setString(1, x1);
            egg.setString(2, x2);
            egg.setString(3, x3);
            egg.setInt(4, x4);
            egg.setString(5, x5);
            egg.setString(6, x6);
            egg.setString(7, x7);
            egg.setFloat(8, x8);
            egg.executeUpdate();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(240, 90, 0, 0));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setName("parkalot"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Exit Receipt");
        jLabel1.setMaximumSize(new java.awt.Dimension(65, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(65, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 15));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 20, 110, 30);

        jLabel2.setText("Owner's name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 80, 130, 20);

        jLabel3.setText("Reg. No. :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 135, 100, 30);

        jLabel4.setText("Car Type :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 200, 100, 30);

        jLabel5.setText("Slot No :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 270, 100, 30);

        jLabel6.setText("Entry Time :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(170, 335, 90, 30);

        jLabel7.setText("Exit Time :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(170, 405, 90, 20);

        jLabel8.setText("Date :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(170, 465, 110, 20);
        getContentPane().add(l1);
        l1.setBounds(490, 80, 260, 30);
        getContentPane().add(l2);
        l2.setBounds(490, 135, 270, 30);
        getContentPane().add(l3);
        l3.setBounds(490, 205, 270, 30);
        getContentPane().add(l4);
        l4.setBounds(490, 275, 270, 30);
        getContentPane().add(l5);
        l5.setBounds(490, 345, 270, 30);
        getContentPane().add(l6);
        l6.setBounds(490, 405, 270, 30);
        getContentPane().add(l7);
        l7.setBounds(490, 465, 270, 30);

        jLabel9.setText("Amount payable :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 525, 120, 20);
        getContentPane().add(l8);
        l8.setBounds(490, 520, 270, 30);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 570, 120, 30);

        jLabel10.setText("Hours");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(770, 345, 90, 30);

        jLabel11.setText("Hours");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(770, 405, 60, 30);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(570, 570, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new exit_form().setVisible(true);
        fill_record();
        dispose();
        empty_table();
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
            java.util.logging.Logger.getLogger(exit_receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exit_receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exit_receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(exit_receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new exit_receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    // End of variables declaration//GEN-END:variables

}
