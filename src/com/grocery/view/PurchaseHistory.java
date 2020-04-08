/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

//import com.grocery.bean.CustomerDetails;
import com.grocery.bean.SaleMaster;
import com.grocery.bean.VendorBillMaster;
import com.grocery.bean.VendorMaster;
import com.grocery.bean.CustomerDetails;
import com.grocery.dimension.SetDimension;
import com.grocery.query.SaleMasterQuery;
import com.grocery.query.VendorBillMasterQuery;
import com.grocery.read.MessageFormat;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class PurchaseHistory extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    private boolean flag;
    private int id;
    public PurchaseHistory(JDesktopPane jDesktopPane, boolean flag, int id) {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        
        this.jDesktopPane = jDesktopPane;
        this.flag = flag;
        this.id = id;
        jTable1.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 11));
        
        if(!(flag))
        {
            //purchase.setText("Sale History");
            purchase.setText("ग्राहक का नाम");
            JTableHeader header= jTable1.getTableHeader();
            TableColumnModel colMod = header.getColumnModel();
            TableColumn tabCol = colMod.getColumn(1);
            //tabCol.setHeaderValue("Customer Name");
            tabCol.setHeaderValue("ग्राहक का नाम");
            header.repaint();
            
            jTable1.getColumnModel().getColumn(4).setMinWidth(0);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
            
            
        }
        
        loadTable();
    }

    PurchaseHistory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        purchase = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        billDetails = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        purchase.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        purchase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchase.setText("खरीद इतिहास");
        purchase.setToolTipText("Purchase History");

        jTable1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "नंबर", "विक्रेता का नाम", "संदर्भ", "बिल नंबर", "दिनांक", "चालान संख्या", "बिल की राशि", "छूट", "अंतिम राशी", "टिप्पणी"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        billDetails.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        billDetails.setText("बिल का विवरण");
        billDetails.setToolTipText("Bill Details");
        billDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(billDetails)
                .addGap(338, 338, 338))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(billDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void billDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billDetailsActionPerformed
        try
        {
            BillDetailsView storeDetails = new BillDetailsView(flag, Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 3 ).toString()));
            if(flag)
                storeDetails.setTitle("Purchase Details");
            
            else
                storeDetails.setTitle("Sale Details");
            jDesktopPane.add(storeDetails);
            SetDimension setDimension = new SetDimension();
            setDimension.setInternalFrameLocation(jDesktopPane, storeDetails);
            storeDetails.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the row whose details you want to view"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_billDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billDetails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel purchase;
    // End of variables declaration//GEN-END:variables

    private void loadTable() 
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        if(flag)
        {
            VendorMaster vendorMaster = new VendorMaster();
            vendorMaster.setId(id);
            
            VendorBillMaster vendorBillMaster = new VendorBillMaster();
            vendorBillMaster.setVendorMaster(vendorMaster);
            
            VendorBillMasterQuery vendorBillMasterQuery = new VendorBillMasterQuery();
            List<Object[]> list = vendorBillMasterQuery.getPurchaseByVendorId(vendorBillMaster);
            
            for(Object[] object: list)
            {
                VendorBillMaster vbm = (VendorBillMaster)object[0];
                
               // defaultTableModel.addRow(new Object[]{vbm.getVendorMaster().getId(), vbm.getVendorMaster().getName(), vbm.getReference(), vbm.getId(), dateFormat.format(vbm.getDate()), vbm.getChallan(), vbm.getBillAmount(), vbm.getDiscount(), vbm.getFinalBillAmount(), vbm.getRemark()});
                defaultTableModel.addRow(new Object[]{vbm.getVendorMaster().getId(), vbm.getVendorMaster().getName(), vbm.getReference(), vbm.getId(), dateFormat.format(vbm.getDate()), vbm.getChallan(), vbm.getBillAmount(), vbm.getDiscount(), vbm.getFinalBillAmount(), vbm.getRemark()});
            }
        }
        else
        {
            CustomerDetails warehouseDetails = new CustomerDetails();
            warehouseDetails.setId(id);
            
            SaleMaster saleMaster = new SaleMaster();
            saleMaster.setCustomerDetails(warehouseDetails);
            
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
            
            List<Object[]> list = saleMasterQuery.getSaleByWarehouseId(saleMaster);
            
            for(Object[] object: list)
            {
                SaleMaster sm = (SaleMaster)object[0];
                
                defaultTableModel.addRow(new Object[]{sm.getCustomerDetails().getId(), sm.getCustomerDetails().getName(), sm.getReference(), sm.getId(), dateFormat.format(sm.getDate()), "", sm.getBillAmount(), sm.getDiscount(), sm.getFinalBillAmount(), sm.getRemark()});
            }
        }
        
        jTable1.setModel(defaultTableModel);
    }
}
