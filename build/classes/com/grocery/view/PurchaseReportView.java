/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.VendorBillMaster;
import com.grocery.query.VendorBillMasterQuery;
import com.grocery.read.MessageFormat;
import com.grocery.read.ReadFile;
import com.grocery.util.MyConnection;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public class PurchaseReportView extends javax.swing.JInternalFrame {

    private Date currentDate = new Date();
    private JTextFieldDateEditor editor;
    
    public PurchaseReportView() {
        initComponents();
       // nonGst.setVisible(false);
        igst.setVisible(false);
        
        nonGst.setSelected(true);
        
        editor = (JTextFieldDateEditor)from.getDateEditor();
        editor.setEditable(false);
        
        from.setDate(currentDate);
        
        editor = (JTextFieldDateEditor)to.getDateEditor();
        editor.setEditable(false);
        
        to.setDate(currentDate);
        
        jTable1.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 11));
        
        gst.setSelected(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        gst = new javax.swing.JRadioButton();
        nonGst = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        billAmount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        finalAmount = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        igst = new javax.swing.JRadioButton();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        from = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(gst);
        gst.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        gst.setForeground(new java.awt.Color(255, 0, 0));
        gst.setText("जीएसटी");
        gst.setToolTipText("GST");
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });

        buttonGroup1.add(nonGst);
        nonGst.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        nonGst.setForeground(new java.awt.Color(255, 0, 0));
        nonGst.setText("  नहीं-जीएसटी");
        nonGst.setToolTipText("Non-GST");
        nonGst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonGstActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "दिनांक", "बिल की राशि", "छूट", "अंतिम राशी"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel22.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("कुल बिल राशि:");
        jLabel22.setToolTipText("Total Bill Amount:");

        billAmount.setEditable(false);
        billAmount.setBackground(new java.awt.Color(255, 255, 153));
        billAmount.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        billAmount.setForeground(new java.awt.Color(255, 0, 0));
        billAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("कुल छूट:");
        jLabel24.setToolTipText("Total Discount:");

        discount.setEditable(false);
        discount.setBackground(new java.awt.Color(255, 255, 153));
        discount.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        discount.setForeground(new java.awt.Color(255, 0, 0));
        discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("अंतिम बिल राशि:");
        jLabel23.setToolTipText("Final Bill Amount:");

        finalAmount.setEditable(false);
        finalAmount.setBackground(new java.awt.Color(255, 255, 153));
        finalAmount.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        finalAmount.setForeground(new java.awt.Color(255, 0, 0));
        finalAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        print.setBackground(new java.awt.Color(153, 153, 255));
        print.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/grocery/view/print-32.png"))); // NOI18N
        print.setText("छाप");
        print.setToolTipText("Print");
        print.setMnemonic(KeyEvent.VK_P);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        buttonGroup1.add(igst);
        igst.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        igst.setForeground(new java.awt.Color(255, 0, 0));
        igst.setText("IGST");
        igst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igstActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("खरीद रिपोर्ट");
        jLabel1.setToolTipText("Purchase Report");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("से");
        jLabel20.setToolTipText("From:");

        from.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromPropertyChange(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("तक\t");
        jLabel19.setToolTipText("To:");

        to.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        to.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(billAmount)
                            .addComponent(discount)
                            .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(399, 399, 399)
                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(342, 342, 342)
                                        .addComponent(nonGst)
                                        .addGap(10, 10, 10)
                                        .addComponent(gst)
                                        .addGap(10, 10, 10)
                                        .addComponent(igst)))
                                .addGap(265, 265, 265)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nonGst)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gst)
                        .addComponent(igst)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromPropertyChange
        if(from.getDate() != null)
            loadTable();
    }//GEN-LAST:event_fromPropertyChange

    private void toPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toPropertyChange
        if(to.getDate() != null)
            loadTable();
    }//GEN-LAST:event_toPropertyChange

    private void gstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstActionPerformed
        loadTable();
    }//GEN-LAST:event_gstActionPerformed

    private void nonGstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonGstActionPerformed
        loadTable();
    }//GEN-LAST:event_nonGstActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        print();
    }//GEN-LAST:event_printActionPerformed

    private void igstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igstActionPerformed
        loadTable();
    }//GEN-LAST:event_igstActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField billAmount;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField finalAmount;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JRadioButton gst;
    private javax.swing.JRadioButton igst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nonGst;
    private java.awt.Panel panel1;
    private javax.swing.JButton print;
    private com.toedter.calendar.JDateChooser to;
    // End of variables declaration//GEN-END:variables

    private void loadTable() 
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        
        Date fromDate = from.getDate();
        Date toDate = to.getDate();
        
        if(fromDate != null && toDate != null)
        {
            String stringFrom = dateFormat.format(fromDate);
            String stringTo = dateFormat.format(toDate);

            try
            {
                fromDate = dateFormat.parse(stringFrom);
                toDate = dateFormat.parse(stringTo);

                if(toDate.compareTo(fromDate) < 0)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("To Date can't be ahead of From Date"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    getTotal(1, billAmount);
                    getTotal(2, discount);
                    getTotal(3, finalAmount);
                    
                    to.setDate(currentDate);
                    from.setDate(currentDate);
                    return;
                }
                VendorBillMaster vendorBillMaster = new VendorBillMaster();
                vendorBillMaster.setDate(fromDate);
                vendorBillMaster.setTo(toDate);
                
                VendorBillMasterQuery vendorBillMasterQuery = new VendorBillMasterQuery();
                
                List<Object[]> list = null;
                
                if(gst.isSelected()){
                     list = vendorBillMasterQuery.getTotalPurchase(vendorBillMaster, "GST");
                     
                }else if(igst.isSelected()){
                    list = vendorBillMasterQuery.getTotalPurchase(vendorBillMaster, "IGST");
                    
                }else{
                    list = vendorBillMasterQuery.getTotalPurchase(vendorBillMaster, "NON-GST");
                } 
                    
                
                
                for(Object[] object: list)
                {
                    defaultTableModel.addRow(new Object[]{dateFormat.format(object[0]), object[1], object[2], object[3]});
                }
                jTable1.setModel(defaultTableModel);
                getTotal(1, billAmount);
                getTotal(2, discount);
                getTotal(3, finalAmount);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private void getTotal(int columnIndex, JTextField jTextField) 
    {
        int index = jTable1.getRowCount();
        int i = 0;
        float sum = 0;
        
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        
        while(i < index)
        {
            sum = sum + Float.parseFloat(jTable1.getValueAt(i, columnIndex).toString());
            i++;
        }
        
        jTextField.setText(decimalFormat.format(sum));
    }
    
    private void print() 
    {
        if(jTable1.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Nothing to Print"), "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        
        Date fromDate = from.getDate();
        Date toDate = to.getDate();
        
        java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
        java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
        
        String reportSource = "";
        String joinQuery = "";
        
        if(gst.isSelected())
        {
                joinQuery = "SELECT\n" +
                            "     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
                            "     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
                            "     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
                            "     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
                            "     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
//                            "     SUM(vendor_bill_master.`billAmount`) AS billAmount,\n" +
//                            "     SUM(vendor_bill_master.`discount`) AS discount,\n" +
//                            "     SUM(vendor_bill_master.`finalBillAmount`) AS finalBillAmount,\n" +
                            "     vendor_bill_master.`billAmount` AS billAmount,\n" +
                            "     vendor_bill_master.`discount` AS discount,\n" +
                            "     vendor_bill_master.`finalBillAmount` AS finalBillAmount,\n" +
                            "     vendor_bill_master.`remark` AS vendor_bill_master_remark,\n" +
                            "     store_details.`Id` AS store_details_Id,\n" +
                            "     store_details.`name` AS store_details_name,\n" +
                            "     store_details.`address` AS store_details_address,\n" +
                            "     store_details.`city` AS store_details_city,\n" +
                            "     store_details.`state` AS store_details_state,\n" +
                            "     store_details.`pincode` AS store_details_pincode,\n" +
                            "     store_details.`phone` AS store_details_phone,\n" +
                            "     store_details.`website` AS store_details_website,\n" +
                            "     store_details.`email` AS store_details_email,\n" +
                            "     store_details.`gstNumber` AS store_details_gstNumber,\n" +
                            "     store_details.`hsnCode` AS store_details_hsnCode,\n" +
                            "     store_details.`photo` AS store_details_photo,\n" +
                            "     stock_details.`gstAmount` AS stock_details_gstAmount,\n" +
                                    // "     stock_details.`igstAmount` AS  stock_details_igstAmount,\n" +
                            "     stock_details.`igstAmount` AS  stock_details_igstAmount,\n" +
                            "     stock_details.`igstPercent` AS  stock_details_igstPercent,\n" +
                            "     stock_details.`gstPercent` AS  stock_details_gstPercent,\n" +
                            "     (stock_details.`gstAmount`/2) AS stock_details_cgst,\n" +
                            "	  (stock_details.`gstAmount`/2) AS stock_details_sgst,\n" +
                            "	  (0.0) AS stock_details_igst\n" +
                            "   FROM\n" +
                            "   `vendor_bill_master` vendor_bill_master \n" +
                            "   INNER JOIN `store_details` store_details  ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
                            "   INNER JOIN `stock_details`  stock_details ON stock_details.`billId` = vendor_bill_master.`id`" +
                            "   WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                        +   "   AND vendor_bill_master.remark = 'GST') "
                        +   "   group BY vendor_bill_master.id ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\PurchaseReportGst.jrxml"; 
        } else if(igst.isSelected()){
            
            joinQuery = "SELECT\n" +
"     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
"     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
"     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
"     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
"     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
"     vendor_bill_master.`billAmount` AS billAmount,\n" +
"     vendor_bill_master.`discount` AS discount,\n" +
"     vendor_bill_master.`finalBillAmount` AS finalBillAmount,\n" +
"     vendor_bill_master.`remark` AS vendor_bill_master_remark,\n" +
"     store_details.`Id` AS store_details_Id,\n" +
"     store_details.`name` AS store_details_name,\n" +
"     store_details.`address` AS store_details_address,\n" +
"     store_details.`city` AS store_details_city,\n" +
"     store_details.`state` AS store_details_state,\n" +
"     store_details.`pincode` AS store_details_pincode,\n" +
"     store_details.`phone` AS store_details_phone,\n" +
"     store_details.`website` AS store_details_website,\n" +
"     store_details.`email` AS store_details_email,\n" +
"     store_details.`gstNumber` AS store_details_gstNumber,\n" +
"     store_details.`photo` AS store_details_photo,\n" +
"	stock_details.`gstAmount` AS stock_details_gstAmount,\n" +
"	stock_details.`igstAmount` AS stock_details_igstAmount,\n" +
"	stock_details.`gstPercent` AS stock_details_gstPercent,\n" +
"	stock_details.`igstPercent` AS stock_details_igstPercent,\n" +
"	(stock_details.`gstAmount`/2) AS stock_details_cgst,\n" +
"	(stock_details.`gstAmount`/2) AS stock_details_sgst\n" +
"FROM\n" +
"  `vendor_bill_master` vendor_bill_master \n" +
"  INNER JOIN `store_details` store_details  ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
"  INNER JOIN `stock_details`  stock_details ON stock_details.`billId` = vendor_bill_master.`id` "+
  "   WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                        +   "   AND vendor_bill_master.remark = 'IGST') "
                        +   "   group BY vendor_bill_master.id ASC";
                
    reportSource = ReadFile.getPath() + "Reports\\PurchaseReportIgst.jrxml"; 
                        
            
         /*    joinQuery = "SELECT\n" +
                            "     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
                            "     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
                            "     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
                            "     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
                            "     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
//                            "     SUM(vendor_bill_master.`billAmount`) AS billAmount,\n" +
//                            "     SUM(vendor_bill_master.`discount`) AS discount,\n" +
//                            "     SUM(vendor_bill_master.`finalBillAmount`) AS finalBillAmount,\n" +
                            "     vendor_bill_master.`billAmount` AS billAmount,\n" +
                            "     vendor_bill_master.`discount` AS discount,\n" +
                            "     vendor_bill_master.`finalBillAmount` AS finalBillAmount,\n" +
                            "     vendor_bill_master.`remark` AS vendor_bill_master_remark,\n" +
                            "     store_details.`Id` AS store_details_Id,\n" +
                            "     store_details.`name` AS store_details_name,\n" +
                            "     store_details.`address` AS store_details_address,\n" +
                            "     store_details.`city` AS store_details_city,\n" +
                            "     store_details.`state` AS store_details_state,\n" +
                            "     store_details.`pincode` AS store_details_pincode,\n" +
                            "     store_details.`phone` AS store_details_phone,\n" +
                            "     store_details.`website` AS store_details_website,\n" +
                            "     store_details.`email` AS store_details_email,\n" +
                            "     store_details.`gstNumber` AS store_details_gstNumber,\n" +
                            "     store_details.`hsnCode` AS store_details_hsnCode,\n" +
                            "     store_details.`photo` AS store_details_photo,\n" +
                            "     stock_details.`gstAmount` AS stock_details_gstAmount,\n" +
                            "    (stock_details.`gstAmount`/2) AS stock_details_cgst,\n" +
                            "    (stock_details.`gstAmount`/2) AS stock_details_sgst,\n" +
                            "     stock_details.`igstAmount` AS  stock_details_igstAmount,\n" +
                            
                            "     stock_details.`igstPercent` AS  stock_details_igstPercent,\n" +
                            "     stock_details.`gstPercent` AS  stock_details_gstPercent,\n" +
                            "	  (0.0) AS stock_details_igst\n" +
                              "   FROM\n" +
                            "   `vendor_bill_master` vendor_bill_master \n" +
                            "   INNER JOIN `store_details` store_details  ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
                            "   INNER JOIN `stock_details`  stock_details ON stock_details.`billId` = vendor_bill_master.`id`" +
                            "   WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                        +   "   AND vendor_bill_master.remark = 'GST') "
                        +   "   GROUP BY vendor_bill_master.date ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\PurchaseReportIgst.jrxml"; */
        }
        else
        {
            joinQuery = "SELECT\n" +
                        "     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
                        "     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
                        "     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
                        "     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
                        "     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
//                        "     SUM(vendor_bill_master.`billAmount`) AS billAmount,\n" +
//                        "     SUM(vendor_bill_master.`discount`) AS discount,\n" +
//                        "     SUM(vendor_bill_master.`finalBillAmount`) AS finalBillAmount,\n" +
                    
                        "     vendor_bill_master.`billAmount` AS billAmount,\n" +
                        "     vendor_bill_master.`discount` AS discount,\n" +
                        "     vendor_bill_master.`finalBillAmount` AS finalBillAmount,\n" +
                    
                        "     vendor_bill_master.`remark` AS vendor_bill_master_remark,\n" +
                        "     store_details.`Id` AS store_details_Id,\n" +
                        "     store_details.`name` AS store_details_name,\n" +
                        "     store_details.`address` AS store_details_address,\n" +
                        "     store_details.`city` AS store_details_city,\n" +
                        "     store_details.`state` AS store_details_state,\n" +
                        "     store_details.`pincode` AS store_details_pincode,\n" +
                        "     store_details.`phone` AS store_details_phone,\n" +
                        "     store_details.`website` AS store_details_website,\n" +
                        "     store_details.`email` AS store_details_email,\n" +
                        "     store_details.`gstNumber` AS store_details_gstNumber,\n" +
                        "     store_details.`hsnCode` AS store_details_hsnCode,\n" +
                        "     store_details.`photo` AS store_details_photo,\n" +
                        "     stock_details.`gstAmount` AS stock_details_gstAmount,\n" +
                        "    (stock_details.`gstAmount`/2) AS stock_details_cgst,\n" +
                        "    (stock_details.`gstAmount`/2) AS stock_details_sgst,\n" +
                        "       (0.0) AS stock_details_igst\n" +
                        "    FROM\n" +
                        "   `vendor_bill_master` vendor_bill_master \n" +
                        "   INNER JOIN `store_details` store_details  ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
                        "   INNER JOIN `stock_details`  stock_details ON stock_details.`billId` = vendor_bill_master.`id`" +
                        "   WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                    +   "   AND vendor_bill_master.remark = 'NON-GST') "
                     +  "   group BY vendor_bill_master.id ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\PurchaseReportNonGst.jrxml"; 
        }
        
        try
        {
            connection = MyConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(joinQuery);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
            Map<String, Object> map = new HashMap<>();
            
            map.put("from", dateFormat.format(sqlFromDate));
            map.put("to", dateFormat.format(sqlToDate));
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, resultSetDataSource);
            JasperViewer.viewReport(jasperPrint, false);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (resultSet != null) 
            {
                try 
                {
                //    System.out.println("Statement");
                    resultSet.close();
                } 
                catch (SQLException e) 
                { /* ignored */}
            }
            if (statement != null) 
            {
                try 
                {
                //    System.out.println("Statement");
                    statement.close();
                } 
                catch (SQLException e) 
                { /* ignored */}
            }
            
            if (connection != null) 
            {
                try 
                {
                //    System.out.println("Connection");
                    connection.close();
                } 
                catch (SQLException e)
                {

                }
            }
        }
    }

}