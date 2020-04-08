/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.query.AlertTableQuery;
import com.lowagie.text.Font;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.formatDate;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static net.sf.dynamicreports.report.builder.component.Components.currentDate;

/**
 *
 * @author GanpatiBappa
 */
public class AlertPage extends javax.swing.JFrame {
  private int currRow_g = 0;
    /**
     * Creates new form TableAlerts
     */
    public AlertPage() {
        initComponents();

        jLabel3.setVisible(false);
        searchItem.setVisible(false);
        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
        jTable1.getTableHeader().setFont(new java.awt.Font("Arial Unicode MS", Font.BOLD, 12));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(255, 51, 0));
        jTable1.setRowHeight(25);
        days15.setBackground(new java.awt.Color(253,250,114));
        days10.setBackground(new java.awt.Color(255,210,127));
        days5.setBackground(new java.awt.Color(255,111,0));
        expired.setBackground(Color.RED);
        
        days15.setEditable(false);
        days10.setEditable(false);
        days5.setEditable(false);
        expired.setEditable(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        purchaseDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchItem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        expired = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        days15 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        days5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        days10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("दिनांक");
        jLabel2.setToolTipText("Date");

        purchaseDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("व्यय वस्तु");
        jLabel1.setToolTipText(" Expairy Item");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(680, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        searchItem.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        searchItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchItemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchItemKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel3.setText("आइटम खोजें");
        jLabel3.setToolTipText("Search Item");

        jTable1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "क्रमांक", "वस्तु का नाम", "ह.स. न. कॊड", "मात्रा", "यूनिट मूल्य", " कुल", "निर्माण तिथि", "समाप्ति तिथि"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Expired");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("11-15 Days");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("1-5 Days");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("6-10 Days");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(expired, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(days15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(days5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(days10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(expired, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(days15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(days10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(days5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchItemKeyReleased
//        ItemAvailability itemAvailability = new ItemAvailability();
//        if(!(searchItem.getText().trim().isEmpty()))
//         itemAvailability.setItemMaster(searchItem.getText().trim());
//        loadTable(itemAvailability);

    }//GEN-LAST:event_searchItemKeyReleased

    private void searchItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchItemKeyTyped
       char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
        evt.consume();
    }//GEN-LAST:event_searchItemKeyTyped

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
            java.util.logging.Logger.getLogger(AlertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlertPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField days10;
    private javax.swing.JTextField days15;
    private javax.swing.JTextField days5;
    private javax.swing.JTextField expired;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser purchaseDate;
    private javax.swing.JTextField searchItem;
    // End of variables declaration//GEN-END:variables
    
    public void loadTable(ItemMaster itemMaster)
    {
        
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        List<Object[]> list = new ArrayList<>();
        
        ItemAvailability itemAvailability = new ItemAvailability();
        
        AlertTableQuery alertTableQuery = new AlertTableQuery();
        itemAvailability.setItemMaster(itemMaster);

//        StockDetails stockDetails = new StockDetails();
//        stockDetails.setItemMaster(itemMaster);
//        list = alertTableQuery.getAvailabilityList(stockDetails);
        
        list = alertTableQuery.getAvailability(itemAvailability);
       

               /*     if (formatDate.parse(expDate).before(currentDate)) {
                        expiredProductAlertJLabel.setVisible(true);
                        timer = new Timer(1000, UserActivities.expProductAlert(expiredProductAlertJLabel));
                        timer.start();

                    }
                    */
        //getTotal();
        int i =0;
        Timer timer;
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");
        Date currentDate = new Date();
        for(Object[] object : list)
        {
           //  for (int i = 0; i < list.size(); i++) {

         //   ItemMaster im = (ItemMaster)object[0];
            
            //defaultTableModel.addRow(new Object[]{ia.getItemMaster().getName(),ia.getAvailability(),ia.getItemMaster().getGstPercent(),ia.getItemMaster().getSellingPrice() ,ia.getItemMaster().getEfgDate(),ia.getItemMaster().getExpDate()});
            defaultTableModel.addRow(new Object[]{i,object[0],object[1],object[2],object[3],Double.valueOf(object[2].toString())* Double.valueOf(object[3].toString()), object[4],object[5]});
        
//            if (LocalDate.now().isAfter((ChronoLocalDate) object[5])) {
//                        
//                        timer = new Timer(1000, expProductAlert(expiredProductAlertJLabel));
//                        timer.start();
//
//                    }
            
        i++;
        } 
        jTable1.setModel(defaultTableModel);
        jTable1.setDefaultRenderer(Object.class, setOutOfStockAlert());
    
    }
    
     private void getTotal() {
        int i = 0;
        float sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        
        float qty = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        float unitPrice = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());

        while (i < jTable1.getRowCount()) {
            sum = qty * unitPrice;
            i++;
//            
//            sum = sum + Float.parseFloat(jTable1.getValueAt(i, 5).toString());
//            i++;
            }
       
       
    }
  /*   private double getTotalAmount() {
        int index = jTable1.getRowCount();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        sumOfGstAmount = 0;
        while(currRow_g<index){
        sumOfGstAmount = sumOfGstAmount + Float.parseFloat(salesTabel.getValueAt(currRow_g, 7).toString());
        currRow_g ++;
         }
        return sumOfGstAmount;
        
//        sumOfIGstAmount = sumOfIGstAmount + Float.parseFloat(jTable2.getValueAt(currRow_g, 10).toString());
//        currRow_g++;
//
//        return sumOfIGstAmount;
    }
    */
    
     
     
 /*      public static void setExpiredProductsAlert() {
        Timer timer;
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");
        Date currentDate = new Date();
        ResultSet expiredMeds = inventory.getInventoryRecord();

        try {
            while (expiredMeds.next()) {
                String expDate = expiredMeds.getString("ExpDate");

                try {
                    if (formatDate.parse(expDate).before(currentDate)) {
                        expiredProductAlertJLabel.setVisible(true);
                        timer = new Timer(1000, UserActivities.expProductAlert(expiredProductAlertJLabel));
                        timer.start();

                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DisplayMedicine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
       
//         public static ActionListener expProductAlert(JLabel label) {
//        return new java.awt.event.ActionListener() {
//            private java.awt.Color cor1 = java.awt.Color.red;
//            private java.awt.Color cor2 = java.awt.Color.blue;
//            private int count;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (count % 2 == 0) {
//                    label.setForeground(cor1);
//                    label.setBackground(cor1);
//                } else {
//                    label.setForeground(cor2);
//                    label.setBackground(cor1);
//                }
//                count++;
//            }
//        };
//
//    }




  public DefaultTableCellRenderer setOutOfStockAlert() {
        return new DefaultTableCellRenderer() {
            int column = 7;
            

            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(jTable1, value, isSelected, hasFocus, row, column);
                String exp = (String)jTable1.getValueAt(row, column);
                 
                //SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");
                if (LocalDate.now().plusMonths(2).isAfter(LocalDate.parse(exp))) {
                    setBackground(Color.RED);
                    //setForeground(Color.WHITE);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }
                return this;
            }
        };
    }








}
