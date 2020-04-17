/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.query.ItemAvailabilityQuery;
import com.grocery.query.ItemQuery;
import com.grocery.read.MessageFormat;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class EditSellingPrice extends javax.swing.JInternalFrame {
    private boolean flag;
    private boolean editFlag;
    
    public EditSellingPrice() {
        initComponents();
        sellingPrice.setFont(sellingPrice.getFont().deriveFont(Font.BOLD, 11));
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);   
        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        item = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        newItem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        available = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        gstPercent = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        cancel = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        sellingPrice = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        hsnCode = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Available Items:");

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Search By Name:");

        item.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        item.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActionPerformed(evt);
            }
        });
        item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemKeyTyped(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Item Name", "HSN Code", "Availablility", "Selling Price", "GST Percent", "Final Selling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel18.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Edit Items");

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Name:");

        newItem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        newItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newItemFocusGained(evt);
            }
        });
        newItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newItemKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Available Quantity:");

        available.setEditable(false);
        available.setBackground(new java.awt.Color(255, 255, 153));
        available.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        available.setForeground(new java.awt.Color(255, 0, 0));
        available.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        available.setText("0.00");

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Selling Price:");

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("GST %");

        gstPercent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gstPercent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "12", "18", "28" }));
        gstPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstPercentActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Total:");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 153));
        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.setForeground(new java.awt.Color(255, 0, 0));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("0.00");

        cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancel.setText("Cancel");
        cancel.setMnemonic(KeyEvent.VK_C);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelKeyPressed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        edit.setText("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editKeyPressed(evt);
            }
        });

        refresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refresh.setText("Refresh");
        refresh.setMnemonic(KeyEvent.VK_R);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        refresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                refreshKeyPressed(evt);
            }
        });

        sellingPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        sellingPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sellingPrice.setText("0.00");
        sellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sellingPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sellingPriceFocusLost(evt);
            }
        });
        sellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sellingPriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sellingPriceKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("HSN:");

        hsnCode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hsnCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hsnCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hsnCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hsnCodeFocusLost(evt);
            }
        });
        hsnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hsnCodeActionPerformed(evt);
            }
        });
        hsnCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hsnCodeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newItem, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(sellingPrice))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hsnCode)
                            .addComponent(gstPercent, 0, 89, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(available, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(total))
                        .addGap(27, 27, 27))))
            .addComponent(jSeparator5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsnCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gstPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit)
                    .addComponent(cancel)
                    .addComponent(refresh))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
            evt.consume();
    }//GEN-LAST:event_itemKeyTyped

    private void newItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newItemKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
            evt.consume();
    }//GEN-LAST:event_newItemKeyTyped

    private void newItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemFocusGained
        newItem.selectAll();
    }//GEN-LAST:event_newItemFocusGained

    private void itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyReleased
        ItemMaster itemMaster = new ItemMaster();
        if(!(item.getText().trim().isEmpty()))
            itemMaster.setName(item.getText().trim());      
        loadTable(itemMaster);
    }//GEN-LAST:event_itemKeyReleased

    private void gstPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstPercentActionPerformed
        if(gstPercent.getItemCount() > 0)
        {
            try
            {
                if(!(sellingPrice.getText().trim().isEmpty()))
                {
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    float sellingPrice = Float.parseFloat(this.sellingPrice.getText().trim());
                    float gstAmount = calculateGst(sellingPrice, Float.parseFloat(gstPercent.getSelectedItem().toString()));

                    total.setText(decimalFormat.format(sellingPrice + gstAmount));
                }
                else
                    total.setText("0.00");
            }
            catch(Exception e)
            {
                total.setText("0.00");
            }
        }
    }//GEN-LAST:event_gstPercentActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        clear();
    }//GEN-LAST:event_refreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        int gstPercent = (int)Float.parseFloat(jTable1.getValueAt(index, 4).toString());
        newItem.setText(jTable1.getValueAt(index, 1).toString());
        hsnCode.setText(jTable1.getValueAt(index, 2).toString());
        available.setText(jTable1.getValueAt(index, 3).toString());
        sellingPrice.setText(jTable1.getValueAt(index, 4).toString());
        this.gstPercent.setSelectedItem(String.valueOf(gstPercent));
        total.setText(jTable1.getValueAt(index, 6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void refreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refreshKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            clear();
    }//GEN-LAST:event_refreshKeyPressed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        edit();
    }//GEN-LAST:event_editActionPerformed

    private void editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            edit();
    }//GEN-LAST:event_editKeyPressed

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            checkDispose();
    }//GEN-LAST:event_cancelKeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        checkDispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void sellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellingPriceFocusLost
        if(sellingPrice.getText().trim().isEmpty())
            sellingPrice.setText("0.00");
    }//GEN-LAST:event_sellingPriceFocusLost

    private void sellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellingPriceFocusGained
        sellingPrice.selectAll();
    }//GEN-LAST:event_sellingPriceFocusGained

    private void sellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingPriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_sellingPriceKeyTyped

    private void sellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingPriceKeyReleased
        if(gstPercent.getItemCount() > 0)
        {
            try
            {
                if(!(sellingPrice.getText().trim().isEmpty()))
                {
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    float sellingPrice = Float.parseFloat(this.sellingPrice.getText().trim());
                    float gstAmount = calculateGst(sellingPrice, Float.parseFloat(gstPercent.getSelectedItem().toString()));

                    total.setText(decimalFormat.format(sellingPrice + gstAmount));
                }
                else
                    total.setText("0.00");
            }
            catch(Exception e)
            {
                total.setText("0.00");
            }
        }
    }//GEN-LAST:event_sellingPriceKeyReleased

    private void hsnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hsnCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hsnCodeActionPerformed

    private void hsnCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hsnCodeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_hsnCodeKeyTyped

    private void hsnCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hsnCodeFocusGained
        hsnCode.selectAll();
    }//GEN-LAST:event_hsnCodeFocusGained

    private void hsnCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hsnCodeFocusLost
        if(hsnCode.getText().trim().isEmpty())
            hsnCode.setText("N/A");
    }//GEN-LAST:event_hsnCodeFocusLost

    private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField available;
    private javax.swing.JButton cancel;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> gstPercent;
    private javax.swing.JTextField hsnCode;
    private javax.swing.JTextField item;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField newItem;
    private javax.swing.JButton refresh;
    private javax.swing.JFormattedTextField sellingPrice;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
    
    public void loadTable(ItemMaster itemMaster)
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        List<Object[]> list = new ArrayList<>();
        
        ItemAvailability itemAvailability = new ItemAvailability();
        itemAvailability.setItemMaster(itemMaster);
        
        ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();
        list = itemAvailabilityQuery.getAvailability(itemAvailability);
        
        for(Object[] object: list)
        {
            ItemAvailability ia =  (ItemAvailability)object[0];
            
            defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getHsnCode(), ia.getAvailability(), ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getGstPercent(), ia.getItemMaster().getFinalSellingPrice()});
        }
        jTable1.setModel(defaultTableModel);
    }

    
    public void clear()
    {
        item.setText("");
        available.setText("0.00");
        sellingPrice.setText("0.00");
        gstPercent.setSelectedIndex(0);
        total.setText("0.00");
        newItem.setText("");
        newItem.requestFocus();
 
        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
    }
    
    private float calculateGst(float sellingPrice, float gstPercent)
    {
        float gstAmount = (sellingPrice * gstPercent ) /100;      
        return gstAmount;
    }

    private void edit() 
    {
        try
        {
            if(newItem.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Item Name"), "Error Message", JOptionPane.ERROR_MESSAGE);
                newItem.requestFocus();
                return;
            }
            if(sellingPrice.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Selling Price"), "Error Message", JOptionPane.ERROR_MESSAGE);
                sellingPrice.requestFocus();
                return;
            }
            ItemMaster itemMaster = new ItemMaster();
            ItemQuery itemQuery = new ItemQuery();
            
            itemMaster.setName(newItem.getText().trim());
            itemMaster.setId(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            
            List<ItemMaster> list = itemQuery.checkItem(itemMaster);
            
            if(!(list.isEmpty()))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This Item already exists"), "Error Message", JOptionPane.ERROR_MESSAGE);
                newItem.requestFocus();
                return;
            }
            
            float gstAmount = calculateGst(Float.parseFloat(sellingPrice.getText().trim()), Float.parseFloat(gstPercent.getSelectedItem().toString()));
            itemMaster.setSellingGstPercent(new BigDecimal(gstPercent.getSelectedItem().toString()));
            itemMaster.setFinalSellingPrice(new BigDecimal(total.getText()));
            itemMaster.setSellingPrice(new BigDecimal(sellingPrice.getText()));
            itemMaster.setHsnCode(hsnCode.getText().trim());
            
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of Updating this Item?"));
            if(confirm == JOptionPane.YES_OPTION)
            {
                itemQuery.updateItemMaster(itemMaster);
  
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Item updated successfully"));
                clear();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to edit"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkDispose() 
    {
        int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of closing this form?"));
        if(confirm == JOptionPane.YES_OPTION)
            dispose();
    }
}
