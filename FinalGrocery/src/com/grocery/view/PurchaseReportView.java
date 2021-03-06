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
        gst.setSelected(true);
        
        editor = (JTextFieldDateEditor)from.getDateEditor();
        editor.setEditable(false);
        
        from.setDate(currentDate);
        
        editor = (JTextFieldDateEditor)to.getDateEditor();
        editor.setEditable(false);
        
        to.setDate(currentDate);
        
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        
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
        from = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        gst = new javax.swing.JRadioButton();
        nonGst = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        billAmount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        finalAmount = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        from.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromPropertyChange(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("To:");

        to.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        to.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toPropertyChange(evt);
            }
        });

        buttonGroup1.add(gst);
        gst.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gst.setForeground(new java.awt.Color(255, 0, 0));
        gst.setText("GST");
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });

        buttonGroup1.add(nonGst);
        nonGst.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        nonGst.setForeground(new java.awt.Color(255, 0, 0));
        nonGst.setText("Non-GST");
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
                "Date", "Bill Amount", "Discount", "Final Amount"
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

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Total Bill Amount:");

        billAmount.setEditable(false);
        billAmount.setBackground(new java.awt.Color(255, 255, 153));
        billAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        billAmount.setForeground(new java.awt.Color(255, 0, 0));
        billAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Total Discount:");

        discount.setEditable(false);
        discount.setBackground(new java.awt.Color(255, 255, 153));
        discount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        discount.setForeground(new java.awt.Color(255, 0, 0));
        discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Final Bill Amount:");

        finalAmount.setEditable(false);
        finalAmount.setBackground(new java.awt.Color(255, 255, 153));
        finalAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        finalAmount.setForeground(new java.awt.Color(255, 0, 0));
        finalAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        print.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        print.setText("Print");
        print.setMnemonic(KeyEvent.VK_P);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("From:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(billAmount)
                            .addComponent(discount)
                            .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(gst)
                        .addGap(18, 18, 18)
                        .addComponent(nonGst)
                        .addGap(287, 287, 287))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gst)
                    .addComponent(nonGst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField billAmount;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField finalAmount;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JRadioButton gst;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nonGst;
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
                
                if(gst.isSelected())
                    list = vendorBillMasterQuery.getTotalPurchase(vendorBillMaster, true);
                else
                    list = vendorBillMasterQuery.getTotalPurchase(vendorBillMaster, false);
                
                
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
                            "     SUM(vendor_bill_master.`billAmount`) AS billAmount,\n" +
                            "     SUM(vendor_bill_master.`discount`) AS discount,\n" +
                            "     SUM(vendor_bill_master.`finalBillAmount`) AS finalBillAmount,\n" +
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
                            "     store_details.`photo` AS store_details_photo\n" +
                            "FROM\n" +
                            "     `store_details` store_details INNER JOIN `vendor_bill_master` vendor_bill_master ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
                            "WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                        +   "AND vendor_bill_master.remark = 'GST Taken') "
                        +   "GROUP BY vendor_bill_master.date ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\PurchaseReportGst.jrxml"; 
        }
        else
        {
            joinQuery = "SELECT\n" +
                        "     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
                        "     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
                        "     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
                        "     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
                        "     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
                        "     SUM(vendor_bill_master.`billAmount`) AS billAmount,\n" +
                        "     SUM(vendor_bill_master.`discount`) AS discount,\n" +
                        "     SUM(vendor_bill_master.`finalBillAmount`) AS finalBillAmount,\n" +
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
                        "     store_details.`photo` AS store_details_photo\n" +
                        "FROM\n" +
                        "     `store_details` store_details INNER JOIN `vendor_bill_master` vendor_bill_master ON store_details.`Id` = vendor_bill_master.`storeId` \n" +
                        "WHERE ((vendor_bill_master.date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate + "') "
                    +   "AND vendor_bill_master.remark = 'GST Not Taken') "
                    +   "GROUP BY vendor_bill_master.date ASC";
                
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
