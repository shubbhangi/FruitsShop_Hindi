/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;


//import com.grocery.bean.CustomerDetails;
//import com.grocery.bean.CustomerPartialPayment;
import com.grocery.bean.CustomerDetails;
import com.grocery.bean.CustomerPartialPayment;
import com.grocery.query.WarehoseDetailsQuery123;
import com.grocery.query.CustomerPartialPaymentQuery;
import com.grocery.read.MessageFormat;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerChequeClearanceView extends javax.swing.JInternalFrame {

    private Date currentDate = new Date();
    private JTextFieldDateEditor editor;
    private BigDecimal beginningCash;
    private BigDecimal expenses;
    
    public CustomerChequeClearanceView() {
        initComponents();
        editor = (JTextFieldDateEditor)date.getDateEditor();
        editor.setEditable(false);
        date.setDate(currentDate);
        
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        clear.setEnabled(false);
        bounce.setEnabled(false);
        
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);   
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
        date = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        clear = new javax.swing.JButton();
        bounce = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datePropertyChange(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Date:");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer Id", "Date ", "Customer Name", "Cheque/NEFT Date", "Payment Mode", "Cheque/NEFT Number", "Bank", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear.setText("Clear");
        clear.setMnemonic(KeyEvent.VK_C);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clearKeyPressed(evt);
            }
        });

        bounce.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bounce.setText("Bounce");
        bounce.setMnemonic(KeyEvent.VK_B);
        bounce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bounceActionPerformed(evt);
            }
        });
        bounce.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bounceKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bounce)
                        .addGap(316, 316, 316))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(bounce))
                .addContainerGap(17, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datePropertyChange
        clear.setEnabled(false);
        loadDetails();
    }//GEN-LAST:event_datePropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Date date = new Date();
        int index = jTable1.getSelectedRow();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try
        {
             Date chequeDate = dateFormat.parse(jTable1.getValueAt(index, 4).toString());
             if(chequeDate.compareTo(date) <= 0)
             {
                 clear.setEnabled(true);
                 bounce.setEnabled(true);
             }
             else
             {
                 clear.setEnabled(false);
                 bounce.setEnabled(false);
             }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearAmount();
    }//GEN-LAST:event_clearActionPerformed

    private void clearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clearKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            clearAmount();
    }//GEN-LAST:event_clearKeyPressed

    private void bounceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bounceActionPerformed
        chequeBounce();
    }//GEN-LAST:event_bounceActionPerformed

    private void bounceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bounceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bounceKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bounce;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


    private void loadDetails() 
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = this.date.getDate();
        
        CustomerPartialPayment warehousePartialPayment = new CustomerPartialPayment();
       // CustomerPartialPayment warehousePartialPayment = new CustomerPartialPayment();
        warehousePartialPayment.setChequeDate(date);
        
        CustomerPartialPaymentQuery warehousePartialPaymentQuery = new CustomerPartialPaymentQuery();
        
        List<Object[]> list = warehousePartialPaymentQuery.getDetails(warehousePartialPayment);
        
        for(Object[] object: list)
        {
            CustomerPartialPayment cpp = (CustomerPartialPayment)object[0];
                //defaultTableModel.addRow(new Object[]{cpp.getId(), cpp.getCustomerDetails().getId(), dateFormat.format(cpp.getDate()), cpp.getCustomerDetails().getName(), dateFormat.format(cpp.getChequeDate()), cpp.getPaymentMode(), cpp.getChequeOrCardNumber(), cpp.getBank(), cpp.getPaidAmount()});
                defaultTableModel.addRow(new Object[]{cpp.getId(), cpp.getCustomerDetails().getId(), dateFormat.format(cpp.getDate()), cpp.getCustomerDetails().getName(), dateFormat.format(cpp.getChequeDate()), cpp.getPaymentMode(), cpp.getChequeOrCardNumber(), cpp.getBank(), cpp.getPaidAmount()});
        }
        jTable1.setModel(defaultTableModel);
    }

    private void clearAmount() 
    {
        try
        {
            
            String customerName = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
            int customerId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            BigDecimal amount = new BigDecimal(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
            int partialId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of clearing this Cheque?"));
        
            if(confirm == JOptionPane.YES_OPTION)
            {
                CustomerPartialPayment warehousePartialPayment = new CustomerPartialPayment();
                CustomerPartialPaymentQuery warehousePartialPaymentQuery = new CustomerPartialPaymentQuery();
                
                warehousePartialPayment.setChequeClearanceDate(currentDate);
                warehousePartialPayment.setStatus("1");
                warehousePartialPayment.setId(partialId);
                
                warehousePartialPaymentQuery.updateCustomerPartialPayment(warehousePartialPayment);
                
                
                CustomerDetails warehouseDetails = new CustomerDetails();
                warehouseDetails.setName(customerName);
                warehouseDetails.setId(customerId);
                
                WarehoseDetailsQuery123 warehouseDetailsQuery = new WarehoseDetailsQuery123();
                
                List<CustomerDetails> list = warehouseDetailsQuery.getCustomerDetails(warehouseDetails);
                
                for(CustomerDetails cm: list)
                    warehouseDetails.setBalance(cm.getBalance().subtract(amount));
                
                warehouseDetailsQuery.updateWarehouseBalance(warehouseDetails);
                
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Customer Cheque Clearance successful"));
                clear();
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Cheque/NEFT you want to clear"), "Error Message", JOptionPane.ERROR_MESSAGE);
            clear();
        }
    }
    
    public void clear()
    {
        clear.setEnabled(false);
        bounce.setEnabled(false);
        loadDetails();
        
    }
    
    private void chequeBounce() 
    {
        try
        {
            
            String customerName = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
            int customerId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            BigDecimal amount = new BigDecimal(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
            int partialId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure that this cheque bounced?"));
        
            if(confirm == JOptionPane.YES_OPTION)
            {
                CustomerPartialPayment warehousePartialPayment = new CustomerPartialPayment();
                CustomerPartialPaymentQuery warehousePartialPaymentQuery = new CustomerPartialPaymentQuery();
                
                warehousePartialPayment.setChequeClearanceDate(currentDate);
                warehousePartialPayment.setStatus("2");
                warehousePartialPayment.setId(partialId);
                
                warehousePartialPaymentQuery.updateCustomerPartialPayment(warehousePartialPayment);
                
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Update successful"));
                clear();
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Cheque/NEFT you want to clear"), "Error Message", JOptionPane.ERROR_MESSAGE);
            clear();
        }
    }
}
