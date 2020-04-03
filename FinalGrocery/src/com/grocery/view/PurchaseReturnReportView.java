/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.PurchaseReturn;
import com.grocery.bean.SaleReturn;
import com.grocery.query.PurchaseReturnQuery;
import com.grocery.query.SaleReturnQuery;
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
public class PurchaseReturnReportView extends javax.swing.JInternalFrame {

    private Date currentDate = new Date();
    private JTextFieldDateEditor editor;
    private boolean flag;
    
    public PurchaseReturnReportView(boolean flag) {
        initComponents();
        
        this.flag = flag;
        editor = (JTextFieldDateEditor)from.getDateEditor();
        editor.setEditable(false);
        
        from.setDate(currentDate);
        
        editor = (JTextFieldDateEditor)to.getDateEditor();
        editor.setEditable(false);
        
        to.setDate(currentDate);
       
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11)); 
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        from = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        billAmount = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
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

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Total Amount:");

        billAmount.setEditable(false);
        billAmount.setBackground(new java.awt.Color(255, 255, 153));
        billAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        billAmount.setForeground(new java.awt.Color(255, 0, 0));
        billAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(billAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print)
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        print();
    }//GEN-LAST:event_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField billAmount;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
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
                    return;
                }
                
                if(flag)
                {
                    PurchaseReturn purchaseReturn = new PurchaseReturn();
                    purchaseReturn.setDate(fromDate);
                    purchaseReturn.setTo(toDate);

                    PurchaseReturnQuery purchaseReturnQuery = new PurchaseReturnQuery();
                    List<Object[]> list = purchaseReturnQuery.getPurchaseReturn(purchaseReturn);

                    for(Object[] object: list)
                    {
                        defaultTableModel.addRow(new Object[]{dateFormat.format(object[0]), object[1]});
                    }
                }
                else
                {
                    SaleReturn saleReturn = new SaleReturn();
                    
                    saleReturn.setDate(fromDate);
                    saleReturn.setTo(toDate);

                    SaleReturnQuery saleReturnQuery = new SaleReturnQuery();
                    List<Object[]> list = saleReturnQuery.getSaleReturn(saleReturn);

                    for(Object[] object: list)
                    {
                        defaultTableModel.addRow(new Object[]{dateFormat.format(object[0]), object[1]});
                    }
                }
                
                jTable1.setModel(defaultTableModel);
                getTotal(1, billAmount);
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
        
        if(flag)
        {
                joinQuery = "SELECT\n" +
                            "     vendor_bill_master.`Id` AS vendor_bill_master_Id,\n" +
                            "     vendor_bill_master.`date` AS vendor_bill_master_date,\n" +
                            "     vendor_bill_master.`storeId` AS vendor_bill_master_storeId,\n" +
                            "     vendor_bill_master.`vendorId` AS vendor_bill_master_vendorId,\n" +
                            "     vendor_bill_master.`challan` AS vendor_bill_master_challan,\n" +
                            "     vendor_bill_master.`billAmount` AS vendor_bill_master_billAmount,\n" +
                            "     vendor_bill_master.`discount` AS vendor_bill_master_discount,\n" +
                            "     vendor_bill_master.`finalBillAmount` AS vendor_bill_master_finalBillAmount,\n" +
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
                            "     purchase_return.`Id` AS purchase_return_Id,\n" +
                            "     purchase_return.`date` AS purchase_return_date,\n" +
                            "     purchase_return.`billId` AS purchase_return_billId,\n" +
                            "     SUM(purchase_return.`amount`) AS amount\n" +
                            "FROM\n" +
                            "     `store_details` store_details INNER JOIN `vendor_bill_master` vendor_bill_master ON store_details.`Id` = vendor_bill_master.`storeId`\n" +
                            "     INNER JOIN `purchase_return` purchase_return ON vendor_bill_master.`Id` = purchase_return.`billId`\n" +
                            "WHERE\n" +
                            "     purchase_return.date BETWEEN '" + sqlFromDate + "'AND '" + sqlToDate + "' GROUP BY\n" +
                            "     purchase_return.date ORDER BY\n" +
                            "     purchase_return.date ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\PurchaseReturnReport.jrxml"; 
        }
        else
        {
            joinQuery = "SELECT\n" +
                        "     sale_return.`Id` AS sale_return_Id,\n" +
                        "     sale_return.`date` AS sale_return_date,\n" +
                        "     sale_return.`billId` AS sale_return_billId,\n" +
                        "     SUM(sale_return.`amount`) AS amount,\n" +
                        "     sale_return.`remark` AS sale_return_remark,\n" +
                        "     sale_master.`Id` AS sale_master_Id,\n" +
                        "     sale_master.`date` AS sale_master_date,\n" +
                        "     sale_master.`storeId` AS sale_master_storeId,\n" +
                        "     sale_master.`counterId` AS sale_master_counterId,\n" +
                        "     sale_master.`customerId` AS sale_master_customerId,\n" +
                        "     sale_master.`billAmount` AS sale_master_billAmount,\n" +
                        "     sale_master.`discount` AS sale_master_discount,\n" +
                        "     sale_master.`finalBillAmount` AS sale_master_finalBillAmount,\n" +
                        "     sale_master.`status` AS sale_master_status,\n" +
                        "     sale_master.`remark` AS sale_master_remark,\n" +
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
                        "     `sale_master` sale_master INNER JOIN `sale_return` sale_return ON sale_master.`Id` = sale_return.`billId`\n" +
                        "     INNER JOIN `store_details` store_details ON sale_master.`storeId` = store_details.`Id`\n" +
                        "WHERE sale_return.date BETWEEN '" + sqlFromDate  + "' AND '" + sqlToDate + "' GROUP BY sale_return.date ORDER BY sale_return.date ASC";
                
                reportSource = ReadFile.getPath() + "Reports\\SaleReturnReport.jrxml"; 
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