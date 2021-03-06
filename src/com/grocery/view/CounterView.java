/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.Counter;
import com.grocery.query.CounterQuery;
import com.grocery.read.MessageFormat;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_E;
import static java.awt.event.KeyEvent.VK_R;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CounterView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CounterView
     */
    public CounterView() {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);  
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        add.setMnemonic(VK_A);
        edit.setMnemonic(VK_E);
        delete.setMnemonic(VK_D);
        refresh.setMnemonic(VK_R);
        edit.setEnabled(false);
        delete.setEnabled(false);
        loadCounter();
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
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelAddCounter = new javax.swing.JLabel();
        jLabelAddCounter1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        name = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Counters:");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Counters"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelAddCounter.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabelAddCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddCounter.setText("Add/Edit Counter:");

        jLabelAddCounter1.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabelAddCounter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddCounter1.setText("Please enter the counter name:*");

        name.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        edit.setText("Edit");
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

        delete.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteKeyPressed(evt);
            }
        });

        refresh.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        refresh.setText("Refresh");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAddCounter1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAddCounter))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAddCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddCounter1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete)
                    .addComponent(refresh))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        addCounter();
    }//GEN-LAST:event_addActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        clear();
        loadCounter();
    }//GEN-LAST:event_refreshActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
       
    }//GEN-LAST:event_nameKeyPressed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_nameKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        add.setEnabled(false);
        edit.setEnabled(true);
        delete.setEnabled(true);
        name.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());     
    }//GEN-LAST:event_jTable1MouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editPressed();   
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deletePressed();
    }//GEN-LAST:event_deleteActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            addCounter();
    }//GEN-LAST:event_addKeyPressed

    private void editKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            editPressed();
    }//GEN-LAST:event_editKeyPressed

    private void deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            deletePressed();
    }//GEN-LAST:event_deleteKeyPressed

    private void refreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refreshKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            clear();
            loadCounter();
        }
    }//GEN-LAST:event_refreshKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabelAddCounter;
    private javax.swing.JLabel jLabelAddCounter1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables

     public void loadCounter() 
    {
        CounterQuery counterQuery = new CounterQuery();
        
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        Counter counter = new Counter();
        
        List<Counter> list = counterQuery.getCounterDetails(counter);
        
        for(Counter c: list)
            defaultTableModel.addRow(new Object[]{c.getId(), c.getName()});
        
        jTable1.setModel(defaultTableModel);
    }

   public void addCounter() 
    {
        if(name.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the counter name"), "Error Message", JOptionPane.ERROR_MESSAGE);
            name.setText("");
            name.requestFocus();
            return;
        }
        Counter counter = new Counter();
        counter.setName(name.getText().trim());
        
        CounterQuery counterQuery = new CounterQuery();
        
         List<Counter> list = counterQuery.getCounterDetails(counter);
         
         if(!(list.isEmpty()))
         {
             JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This counter already exists"), "Error Message", JOptionPane.ERROR_MESSAGE);
             name.requestFocus();
             name.selectAll();
             return;
         }
         
         int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of adding this counter?"));
         
         if(confirm == JOptionPane.YES_OPTION)
         {
             counter.setStatus("1");
         
            counterQuery.insertCounter(counter);
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Counter added successfully"));
            loadCounter();
            clear();
         }
         
    }

   public void clear() 
    {
        name.setText("");
        name.requestFocus();
        edit.setEnabled(false);
        delete.setEnabled(false);
        add.setEnabled(true);
    }

   public void editCounter(Counter counter, String message, String confirmation) 
    {
        if(name.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the counter name"), "Error Message", JOptionPane.ERROR_MESSAGE);
            name.setText("");
            name.requestFocus();
            return;
        }
        
        counter.setName(name.getText().trim());
        
        CounterQuery counterQuery = new CounterQuery();
        List<Counter> list = counterQuery.checkCounter(counter);
        
        if(!(list.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This counter already exists"), "Error Message", JOptionPane.ERROR_MESSAGE);
            name.requestFocus();
            name.selectAll();
            return;
        }
       
        int confirm = JOptionPane.showConfirmDialog(null, message);

        if(confirm == JOptionPane.YES_OPTION)
        {
            counterQuery.updateCounter(counter);
            JOptionPane.showMessageDialog(null, confirmation);
            loadCounter();
            clear();
        } 
    }

    public void editPressed() 
    {
        try
        {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Counter counter = new Counter();
            counter.setId(id);
            counter.setStatus("1");
            editCounter(counter, MessageFormat.getMessage("Are you sure of updating this Counter?"), MessageFormat.getMessage("Counter updated successfully"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please select the Counter you want to edit");
        }
    }

    public void deletePressed() 
    {
        try
        {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Counter counter = new Counter();
            counter.setId(id);
            counter.setStatus("0");
            editCounter(counter, "Are you sure of deleting this Counter?", "Counter deleted successfully");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please select the Counter you want to delete");
        }
    }
}
