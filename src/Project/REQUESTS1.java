package Project;

import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

public final class REQUESTS1 extends javax.swing.JFrame {
    static int acc_id,id;
    int id2;
    ArrayList<Integer> helperId;
    OracleConnection conn;
    OracleStatement stmt,stmt1;
    OracleResultSet rs, rs1, rs2, rs4;
    String selectQuery2 = null;
    ButtonGroup bg;
     ArrayList<JRadioButton> bts;
     DefaultTableModel model2;

    public REQUESTS1(int acc_id,int id1) throws SQLException {

        initComponents();
        REQUESTS1.acc_id = acc_id;
        REQUESTS1.id = id1;
        jTable1.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(255, 153, 0));
        jTable1.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable1.setRowHeight(35);
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            conn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Samarth");

            stmt = (OracleStatement) conn.createStatement();
            stmt=(OracleStatement) conn.createStatement();
           stmt1= (OracleStatement) conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception e = " + e);
        }
                               bts = new ArrayList<>(); 
        
          helperId = this.gethelperIds(id);
          Object data[][] = new Object[helperId.size()][8];
           bg = new ButtonGroup();
           String name ="";
            bts = new ArrayList<>();
          for(int i=0;i<helperId.size();i++){
            try {
                String q = "select * from hr.helper_details where helper_id in "+helperId.get(i);
                
                
                ResultSet rs = stmt.executeQuery(q);
                while(rs.next()){
                    try {
                        id2 = rs.getInt("account_id");
                        String q1 = "select first_name,last_name from hr.account_details where account_id ="+id2;
                        ResultSet rs2 = stmt1.executeQuery(q1);
                        while(rs2.next()){
                            name = rs2.getString("first_name")+" "+rs2.getString("last_name");
                        }
                        
                        bts.add(i, new JRadioButton());
                        data[i][0] = bts.get(i);
                        bg.add((JRadioButton)data[i][0]);
                        data[i][1] = name;
                        data[i][2] = rs.getString("helper_startpoint");
                        data[i][3] = rs.getString("helper_destination");
                        data[i][4] = rs.getString("time_helper");
                        data[i][5] = rs.getString("date_helper");
                        data[i][6] = rs.getString("payment_mode");
                        data[i][7] = rs.getString("fair_amount");
                    } catch (SQLException ex) {
                        Logger.getLogger(REQUESTS1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } } catch (SQLException ex) {
                Logger.getLogger(REQUESTS1.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          }
           model2 = new DefaultTableModel();
        String[] columnNames = {"Choice","Name","StartPoint","Destination", "Time", "Date", "Payment mode", "Fare amount"};
         
         
        
        Font f = new Font("Seoge UI Light",Font.PLAIN,24);
        JTableHeader header = jTable1.getTableHeader();
        header.setFont(f);
        model2.setDataVector(data, columnNames);
        jTable1.setModel(model2);
        jTable1.getColumn("Choice").setCellRenderer((TableCellRenderer) new RadioButtonRenderer());
        jTable1.getColumn("Choice").setCellEditor(new RadioButtonEditor(new JCheckBox()));
        jTable1.setRowMargin(10);
        jTable1.setCellSelectionEnabled(true);
        jTable1.setVisible(true);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("R E Q U E S T S :");

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/icons8_MacOS_Minimize_30px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/icons8_MacOS_Close_30px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(3);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(3);
        }

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CONFIRM");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1154, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(1988, 1988, 1988))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(717, 717, 717)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(537, 537, 537)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(JFrame.ICONIFIED);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       for(int i=0;i<bts.size();i++){
           if(bts.get(i).isSelected())
           {
               id2 =   helperId.get(i);
           }
       }
        int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
        if (a == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Request sent successfully");
            String q3 = "insert into hr.join_hs values(" + id2 + "," + id + ")";
            try {
                int m = stmt.executeUpdate(q3);
                SEEKER u = new SEEKER(acc_id);
                u.setVisible(true);
                u.pack();
                u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(REQUESTS1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REQUESTS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new REQUESTS1(acc_id,id).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(REQUESTS1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
   ArrayList<Integer> gethelperIds(int id) throws SQLException {
        
            ArrayList<String>  help_seek =  
                  new ArrayList<>();
    
        
        String gender= "";
        String q1 = "select gender from hr.account_details where account_id ="+acc_id;
        
        ResultSet rs1 = stmt.executeQuery(q1);
        while(rs1.next()){
          gender = rs1.getString("gender");
        }
        

            CallableStatement cstmt = conn.prepareCall("{?= call HR.join(?,?)}");
            cstmt.registerOutParameter(1,Types.VARCHAR);  
            cstmt.setInt(2,id); 
            cstmt.setString(3, gender);
            cstmt.execute();
             ArrayList<Integer> temp=null;
            String str = cstmt.getString(1);
            if(str.equals("No data")){
                JOptionPane.showMessageDialog(null,"No data found");    
            }
            else{
            System.out.println(str);
                String values[] = str.split(",");
               
                Collections.addAll(help_seek, values);
                temp = new ArrayList<Integer>();
                for(String stringValue : help_seek){
                   temp.add(Integer.parseInt(stringValue));
                }
               
            }  
            return temp;
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

