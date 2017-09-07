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

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lll2yu
 */
public class record_show extends javax.swing.JFrame {

    /**
     * Creates new form record_show
     */
    public record_show() {
        initComponents();   
    }
    
    public ArrayList<forRecord> forRecord(){
        ArrayList<forRecord> ilist=new ArrayList<>();
            ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select * from record where "+s2+"= '"+s3+"';");	
                        forRecord list;
 				while (rlt.next()) {      
  					 list=new forRecord(rlt.getString("owner_name"),rlt.getString("reg_no"),rlt.getString("car_type"),rlt.getInt("slot_no"),rlt.getString("entry_time") ,rlt.getString("exit_time"),rlt.getString("date"),rlt.getFloat("amount_payed"));                                 
                                         ilist.add(list);
				}
		}
		catch(Exception e){}
        return ilist;
    }
    
    public ArrayList<forLot> forLot(){
        ArrayList<forLot> llist=new ArrayList<>();
            ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select * from entry where "+s2+"= '"+s3+"';");	
                        forLot list;
 				while (rlt.next()) {      
  					 list=new forLot(rlt.getString("owner_name"),rlt.getString("reg_no"),rlt.getString("car_type"),rlt.getInt("slot_no"),rlt.getString("time") ,rlt.getString("date"));                                 
                                         llist.add(list);
				}
		}
		catch(Exception e){}
        return llist;
    }
    public void draw_rTable(){
        ArrayList<forRecord> rlist=forRecord();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[10];
        for(int i=0;i<rlist.size();i++){
            row[0]=rlist.get(i).owner_name();
            row[1]=rlist.get(i).reg_no();
            row[2]=rlist.get(i).car_type();
            row[3]=rlist.get(i).slot_no();
            row[4]=rlist.get(i).entry_time();
            row[5]=rlist.get(i).exit_time();
            row[6]=rlist.get(i).date();
            row[7]=rlist.get(i).amount_payed();
            model.addRow(row);
        }
    }
    public void draw_lTable(){
        ArrayList<forLot> slist=forLot();
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        Object[] row=new Object[10];
        for(int i=0;i<slist.size();i++){
            row[0]=slist.get(i).owner_name();
            row[1]=slist.get(i).reg_no();
            row[2]=slist.get(i).car_type();
            row[3]=slist.get(i).slot_no();
            row[4]=slist.get(i).time();
            row[5]=slist.get(i).date();
            model.addRow(row);
        }
    }
    private void rTable(){
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Owner Name", "Registration No", "Car Type", "Slot No", "Entry Time", "Exit Time", "Date ", "Amount Payed"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 330, 870, 170);
    } 
    private void lTable(){
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Owner Name", "Registration No", "Car Type", "Slot No", "Entry Time", "Date "
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 330, 870, 170);
    } 
    String s1,s2,s3,s4;
    void get_searchTerm(){
        
        Object SI=jComboBox1.getSelectedItem();
        if (SI!=null)
                s1=SI.toString();
        switch (s1) {
            case "Registration No":
                s2="reg_no";
                break;
            case "Owner Name":
                s2="owner_name";
                break;
            case "Car Type":
                s2="car_type";
                break;
            case "Entry Time":
                s2="entry_time";
                break;
            case "Exit Time":
                s2="exit_time";
                break;
            case "Date ":
                s2="date";
                break;
            default:
                break;
        }
    }
    void get_searchItem(){
        switch (s2) {
            case "reg_no":
            case "owner_name":
                String temp;
                temp=jTextField1.getText();
                if(temp.isEmpty())
                    jTextField1.setText("This field can't be empty");
                else{
                    s3=temp;
                    if (s4.equals("Records")){
                        rTable();
                        draw_rTable();
                    }
                    else if(s4.equals("Lot")){
                        lTable();
                        draw_lTable();
                    }
                }   break;
            case "date":
                {
                    Object day = jComboBox3.getSelectedItem();
                    Object mon = jComboBox4.getSelectedItem();
                    Object year = jComboBox5.getSelectedItem();
                    String d=day.toString();
                    String m=mon.toString();
                    String y=year.toString();
                    s3=d+"."+m+"."+y;
                    if (s4.equals("Records")){
                        rTable();
                        draw_rTable();
                    }
                    else if(s4.equals("Lot")){
                        lTable();
                        draw_lTable();
                    }   break;
                }
            case "entry_time":
            case "exit_time":
                {
                    Object hours = jComboBox6.getSelectedItem();
                    Object min = jComboBox7.getSelectedItem();
                    String h=hours.toString();
                    String m=min.toString();
                    s3=h+m;
                    if (s4.equals("Records")){
                        rTable();
                        draw_rTable();
                    }
                    else if(s4.equals("Lot")){
                        lTable();
                        draw_lTable();
                    }   break;
                }
            case "car_type":
                Object car = jComboBox8.getSelectedItem();
                String c=car.toString();
                s3=c;
                if (s4.equals("Records")){
                    rTable();
                    draw_rTable();
                }
                else if(s4.equals("Lot")){
                    lTable();
                    draw_lTable();
                }
                break;
            default:
                break;
        }
    }
    void set_boxes(){
        Object W=jComboBox2.getSelectedItem();
        if(W!=null)
            s4=W.toString();
        if(s4.equals("Lot")){
        getContentPane().remove(jComboBox1);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registration No", "Owner Name", "Date", "Entry Time", "Car Type" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(250, 110, 150, 25);
        }
        else{
        getContentPane().remove(jComboBox1);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registration No", "Owner Name", "Date", "Entry Time","Exit Time", "Car Type" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(250, 110, 150, 25);
        }
    }
    void setInputMethods(){
        Object selectedItem = jComboBox1.getSelectedItem();
        String temp=selectedItem.toString();
        switch (temp) {
            case "Date":
                removeComponents();
                addDateSelector();
                break;
            case "Entry Time":
            case "Exit Time":
                removeComponents();
                addTimeChooser();
                break;
            case "Car Type":
                removeComponents();
                addCarChooser();
                break;
            default:
                removeComponents();
                addTextBox();
                break;
        }
    }
    void removeComponents(){
        Component componentAt = getContentPane().getComponentAt(680, 110);
                if(componentAt!=null){
                    getContentPane().remove(componentAt);
                    getContentPane().repaint();
                }
                Component componentAt2 = getContentPane().getComponentAt(610, 110);
                Component componentAt3 = getContentPane().getComponentAt(680, 110);
                Component componentAt4 = getContentPane().getComponentAt(750, 110);
                if(componentAt2!=null){
                    getContentPane().remove(componentAt2);
                    getContentPane().remove(componentAt3);
                    getContentPane().remove(componentAt4);
                    getContentPane().repaint();
                }
    }
    void addDateSelector(){
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        ArrayList<Integer> day =new ArrayList<>();
        for(int j=1;j<=31;j++){
            day.add(j);
        }
        jComboBox3.setModel(new DefaultComboBoxModel<>(day.toArray(new Integer[0])));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(610, 110, 65, 30);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }));
        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(680, 110, 65, 30);
        
        ArrayList<Integer> year =new ArrayList<>();
        for(int j=2017;j<=2117;j++){
            year.add(j);
        }
        jComboBox5.setModel(new DefaultComboBoxModel<>(year.toArray(new Integer[0])));
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(750, 110, 65, 30);
    }
    void addTimeChooser(){
        ArrayList<Integer> hour =new ArrayList<>();
        for(int j=00;j<=23;j++){
            hour.add(j);
        }
        jComboBox7.setModel(new DefaultComboBoxModel<>(hour.toArray(new Integer[0])));
        getContentPane().add(jComboBox7);
        jComboBox7.setBounds(640, 110, 65, 30);
        ArrayList<Integer> min =new ArrayList<>();
        for(int j=00;j<=59;j++){
            min.add(j);
        }
        jComboBox8.setModel(new DefaultComboBoxModel<>(min.toArray(new Integer[0])));
        getContentPane().add(jComboBox8);
        jComboBox8.setBounds(710, 110, 65, 30);
    }
    void addTextBox(){
        jTextField1 = new javax.swing.JTextField();
        getContentPane().add(jTextField1);
        jTextField1.setBounds(650, 110, 200, 30);
    }
    void addCarChooser(){
        ArrayList<String> car=new ArrayList<>();
        ResultSet rlt;
        try{
			Class.forName("add your jdbc Driver");
			Connection c=DriverManager.getConnection("add your connectin info");
			Statement stat=c.createStatement();
			rlt=stat.executeQuery("Select name from rates ");			
 				while (rlt.next()) {      
  					 car.add(rlt.getString(1));                                 
				}
		}
		catch(Exception e){}
        jComboBox6.setModel(new DefaultComboBoxModel<>(car.toArray(new String[0])));
        getContentPane().add(jComboBox6);
        jComboBox6.setBounds(650, 110, 200, 30);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(240, 90, 0, 0));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setName("Search In Records"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Get Records");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 260, 130, 30);

        jLabel1.setText("Search by : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 110, 90, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registration No", "Owner Name", "Date", "Entry Time", "Exit Time", "Car Type" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(250, 110, 150, 27);

        jLabel2.setText("Search For : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 110, 80, 30);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel3.setText("Search In : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 30, 120, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons8-Refresh-26.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(560, 262, 28, 28);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Records", "Lot" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(540, 30, 180, 30);

        jMenu3.setText("Actions");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("GoTo Entry Form");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("GoTo Exit Form");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Component componentAt = getContentPane().getComponentAt(20,430);
        String expect="javax.swing.JPanel";
        String temp=componentAt.toString();
        int start=0;
	int end=18;
	char buf[]=new char[end-start];
	temp.getChars(start,end,buf,0);
        String tte=new String(buf);
        if((!tte.equals(expect))){
            jOptionPane1 = new javax.swing.JOptionPane();
            jOptionPane1.showMessageDialog(getContentPane(),"Press refresh button to continue.","Alert",jOptionPane1.WARNING_MESSAGE);
            jOptionPane1.setBounds(360, 250, 262, 90);
        }
        else if(s4 == null){
            jOptionPane1 = new javax.swing.JOptionPane();
            jOptionPane1.showMessageDialog(getContentPane(),"First select where to search from!","Alert",jOptionPane1.WARNING_MESSAGE);
            jOptionPane1.setBounds(360, 250, 262, 90);
        }
        else
            get_searchItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        get_searchTerm();
        setInputMethods();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Component componentAt = getContentPane().getComponentAt(10, 330);
        getContentPane().remove(componentAt);
        getContentPane().repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        set_boxes();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new entry_form().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new exit_form().setVisible(true);
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
            java.util.logging.Logger.getLogger(record_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(record_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(record_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(record_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new record_show().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<Integer> jComboBox3 = new javax.swing.JComboBox <>();
    private javax.swing.JComboBox<String> jComboBox4 = new javax.swing.JComboBox <>();
    private javax.swing.JComboBox<Integer> jComboBox5 = new javax.swing.JComboBox <>();
    private javax.swing.JComboBox<String> jComboBox6 = new javax.swing.JComboBox <>();
    private javax.swing.JComboBox<Integer> jComboBox7 = new javax.swing.JComboBox <>();
    private javax.swing.JComboBox<Integer> jComboBox8 = new javax.swing.JComboBox <>();
}