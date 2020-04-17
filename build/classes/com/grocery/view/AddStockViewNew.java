/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;


import com.grocery.bean.Expenses;
import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.bean.PurchaseMaster;
import com.grocery.bean.StockDetailsPurchase;
import com.grocery.bean.StoreDetails;
import com.grocery.bean.VendorBillMaster;
import com.grocery.bean.VendorMaster;
import com.grocery.bean.VendorPartialPayment;
import com.grocery.query.ExpensesQuery;
import com.grocery.query.ItemAvailabilityQuery;
import com.grocery.query.ItemQuery;
import com.grocery.query.PurchaseMasterQuery;
import com.grocery.query.StockDetailsQuery;
import com.grocery.query.VendorBillMasterQuery;
import com.grocery.query.VendorPartialPaymentQuery;
import com.grocery.query.VendorQuery;
import com.grocery.read.MessageFormat;
//import com.grocery.bean.VendorMaster;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_A;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class AddStockViewNew extends javax.swing.JInternalFrame {

    private Date date = new Date();
    private JDesktopPane jDesktopPane;
    private JTextFieldDateEditor editor;
    private boolean vendorFlag;
    private boolean brandFlag;
    private boolean newVendorFlag;
    private boolean itemFlag;
    private BigDecimal beginningCash;
    private BigDecimal expenses;
    
    public AddStockViewNew(JDesktopPane jDesktopPane) {
        initComponents();
       // jLabel27.setVisible(false);
        igstTaken.setVisible(false);
        gstNotTaken.setSelected(true);
        quantity.setFont(quantity.getFont().deriveFont(Font.BOLD, 11));
        total.setFont(total.getFont().deriveFont(Font.BOLD, 11));
        this.jDesktopPane = jDesktopPane;  
        add.setMnemonic(VK_A);
        jTable1.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 11));
        purchaseDate.setDate(date); 
        editor = (JTextFieldDateEditor)purchaseDate.getDateEditor();
        editor.setEditable(false);
//        loadVendor();
//        loadItem();
//        loadBeginningCash();
//        loadExpenses();
//        loadCash();
//        getTotal();
  
    }
    public AddStockViewNew(DefaultTableModel defaultTableModel, JDesktopPane jDesktopPane, VendorMaster vendorMaster, VendorPartialPayment vendorPartialPayment, boolean newVendorFlag,String discount, String finalAmount) 
    {
        initComponents();  
        gstNotTaken.setSelected(true);
        jCheckBoxDiscount.setSelected(false);
        this.discount.setText(discount);
        this.finalAmountPaid.setText(finalAmount);
        
        this.jDesktopPane = jDesktopPane;
        jTable1.setModel(defaultTableModel);
        add.setMnemonic(VK_A);
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        purchaseDate.setDate(date);
       
        editor = (JTextFieldDateEditor)purchaseDate.getDateEditor();
        editor.setEditable(false);
        editor.setEditable(false);     
        
//        loadVendor();
//        loadItem();
//        loadBeginningCash();
//        loadExpenses();
//        loadCash();
//        getTotal();
 
        purchaseDate.setDate(vendorPartialPayment.getDate());

        if(Float.parseFloat(discount) != 0)
        {
            jPanelDiscount.setVisible(true);
            jCheckBoxDiscount.setSelected(true);
            this.discount.setText(discount);
            this.finalAmountPaid.setText(finalAmount);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        amount = new javax.swing.JTextField();
        Pay = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        item = new javax.swing.JComboBox<String>();
        jPanelItem = new javax.swing.JPanel();
        newItem = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        gstNotTaken = new javax.swing.JRadioButton();
        gstTaken = new javax.swing.JRadioButton();
        igstTaken = new javax.swing.JRadioButton();
        gst = new javax.swing.JComboBox<String>();
        purchaseGstAmountNew = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        actualTotal = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        brand = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        total = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        quantity1 = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        item2 = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        quantity = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanelBrand = new javax.swing.JPanel();
        newBrand = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        purchaseDate = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        vendorName = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelDiscount = new javax.swing.JPanel();
        jCheckBoxDiscount = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        jLabel38 = new javax.swing.JLabel();
        finalAmountPaid = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("कुल");
        jLabel25.setToolTipText("Total");

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        add.setText("जोड़ना");
        add.setToolTipText("Add");
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

        remove.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App_icons/remove_cart.png"))); // NOI18N
        remove.setText("हटाना");
        remove.setToolTipText("Remove");
        remove.setMnemonic(KeyEvent.VK_R);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        amount.setBackground(new java.awt.Color(255, 255, 153));
        amount.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 0, 0));
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Pay.setBackground(new java.awt.Color(255, 255, 255));
        Pay.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        Pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App_icons/pay32.png"))); // NOI18N
        Pay.setText(" भुगतान");
        Pay.setToolTipText("Pay");
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Item Details:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        item.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActionPerformed(evt);
            }
        });

        jPanelItem.setBackground(new java.awt.Color(255, 255, 255));

        newItem.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
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

        javax.swing.GroupLayout jPanelItemLayout = new javax.swing.GroupLayout(jPanelItem);
        jPanelItem.setLayout(jPanelItemLayout);
        jPanelItemLayout.setHorizontalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemLayout.createSequentialGroup()
                .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelItemLayout.setVerticalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemLayout.createSequentialGroup()
                .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel41.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("यूनिट मूल्य:");
        jLabel41.setToolTipText("Unit Price:");

        unitPrice.setEditable(false);
        unitPrice.setBackground(new java.awt.Color(255, 255, 153));
        unitPrice.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        unitPrice.setForeground(new java.awt.Color(255, 0, 0));
        unitPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unitPrice.setText("0.00");
        unitPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                unitPriceFocusGained(evt);
            }
        });
        unitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("जीएसटी राशि");
        jLabel33.setToolTipText("GST Amount");

        buttonGroup1.add(gstNotTaken);
        gstNotTaken.setFont(new java.awt.Font("Arial Unicode MS", 1, 10)); // NOI18N
        gstNotTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstNotTaken.setText("नोन-जीएसटी");
        gstNotTaken.setToolTipText("Non-GST");
        gstNotTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstNotTakenActionPerformed(evt);
            }
        });

        buttonGroup1.add(gstTaken);
        gstTaken.setFont(new java.awt.Font("Arial Unicode MS", 1, 10)); // NOI18N
        gstTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstTaken.setText("जीएसटी");
        gstTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstTakenActionPerformed(evt);
            }
        });

        buttonGroup1.add(igstTaken);
        igstTaken.setFont(new java.awt.Font("Arial Unicode MS", 1, 10)); // NOI18N
        igstTaken.setForeground(new java.awt.Color(255, 0, 0));
        igstTaken.setText("इ-जीएसटी");
        igstTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igstTakenActionPerformed(evt);
            }
        });

        gst.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        gst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "5", "12", "18", "28" }));
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });

        purchaseGstAmountNew.setBackground(new java.awt.Color(255, 255, 153));
        purchaseGstAmountNew.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        purchaseGstAmountNew.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purchaseGstAmountNew.setText("0.00");
        purchaseGstAmountNew.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        purchaseGstAmountNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                purchaseGstAmountNewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchaseGstAmountNewFocusLost(evt);
            }
        });
        purchaseGstAmountNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseGstAmountNewActionPerformed(evt);
            }
        });
        purchaseGstAmountNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purchaseGstAmountNewKeyReleased(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("वास्तविक राशि");
        jLabel46.setToolTipText("Actual Amount");

        actualTotal.setBackground(new java.awt.Color(255, 255, 153));
        actualTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        actualTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        actualTotal.setText("00");
        actualTotal.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        actualTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                actualTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                actualTotalFocusLost(evt);
            }
        });
        actualTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                actualTotalKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("वस्तु का नाम:");
        jLabel23.setToolTipText("Item Name:");

        brand.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jLabel3.setPreferredSize(new java.awt.Dimension(7, 15));

        jLabel26.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("ब्रांड :");
        jLabel26.setToolTipText("Brand");

        jLabel30.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("कुल");

        total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("0.00");
        total.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                totalFocusLost(evt);
            }
        });
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalKeyReleased(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jLabel9.setPreferredSize(new java.awt.Dimension(7, 15));

        quantity1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        quantity1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity1.setText("00");
        quantity1.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        quantity1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantity1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantity1FocusLost(evt);
            }
        });
        quantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantity1KeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("वजन ");
        jLabel27.setToolTipText("weight");

        jLabel32.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("इकाई");
        jLabel32.setToolTipText("Unit");

        item2.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        item2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Units--", "Kg", "gm", "unit" }));
        item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jLabel4.setPreferredSize(new java.awt.Dimension(7, 15));

        jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText(" मात्रा:");
        jLabel24.setToolTipText("quantity");

        quantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.setText("00");
        quantity.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityFocusLost(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jLabel5.setPreferredSize(new java.awt.Dimension(7, 15));

        jPanelBrand.setBackground(new java.awt.Color(255, 255, 255));

        newBrand.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        newBrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newBrandFocusGained(evt);
            }
        });
        newBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newBrandKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelBrandLayout = new javax.swing.GroupLayout(jPanelBrand);
        jPanelBrand.setLayout(jPanelBrandLayout);
        jPanelBrandLayout.setHorizontalGroup(
            jPanelBrandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBrandLayout.createSequentialGroup()
                .addComponent(newBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanelBrandLayout.setVerticalGroup(
            jPanelBrandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gstNotTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gstTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(igstTaken)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(actualTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(purchaseGstAmountNew, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(item2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitPrice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(item2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jPanelBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(purchaseGstAmountNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(actualTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(igstTaken)
                        .addComponent(gstTaken))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gstNotTaken)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase काउंटर");
        jLabel1.setToolTipText("counter");

        jButton3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jButton3.setText("वापस");
        jButton3.setToolTipText("Back");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("खरीद की तारीख:");
        jLabel29.setToolTipText("Purchase Date:");

        purchaseDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("नाम :");
        jLabel17.setToolTipText("Name");

        vendorName.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        vendorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorNameActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App_icons/1439034530_user-group-new.png"))); // NOI18N
        jButton1.setText("नया विक्रेता जोड़ें");
        jButton1.setToolTipText("Add New Vendoer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");
        jLabel2.setPreferredSize(new java.awt.Dimension(7, 15));

        jTable1.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "वस्तु का नाम", "ब्रांड ", "वजन", "इकाई", "मात्रा", "कुल", "यूनिट मूल्य", "जीएसटी %", "वास्तविक राशि", "जीएसटी राशि", "फाइनल  टोटल", "बेचना कीमत", "जीएसटी प्रकार"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanelDiscount.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBoxDiscount.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jCheckBoxDiscount.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxDiscount.setText(" छूट");
        jCheckBoxDiscount.setToolTipText("Discount");
        jCheckBoxDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDiscountActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText(" छूट राशि:");
        jLabel37.setToolTipText("Discount Amount:");

        discount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discount.setText("0.00");
        discount.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        discount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                discountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                discountFocusLost(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("अंतिम राशि का भुगतान:");
        jLabel38.setToolTipText("Final Amount Paid:");

        finalAmountPaid.setBackground(new java.awt.Color(255, 255, 153));
        finalAmountPaid.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        finalAmountPaid.setForeground(new java.awt.Color(255, 0, 0));
        finalAmountPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalAmountPaid.setText("0.00");
        finalAmountPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalAmountPaidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDiscountLayout = new javax.swing.GroupLayout(jPanelDiscount);
        jPanelDiscount.setLayout(jPanelDiscountLayout);
        jPanelDiscountLayout.setHorizontalGroup(
            jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiscountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxDiscount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDiscountLayout.setVerticalGroup(
            jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiscountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(finalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxDiscount)))
        );

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App_icons/1439034464_DeleteRed.png"))); // NOI18N
        cancel.setText("रद्द करना");
        cancel.setToolTipText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(remove)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(593, 593, 593)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(499, 499, 499)
                            .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106)
                            .addComponent(cancel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel17)
                            .addGap(48, 48, 48)
                            .addComponent(vendorName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancel)
                    .addComponent(Pay))
                .addGap(26, 26, 26))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1386, 556);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed

        PurchasePayment payment = new PurchasePayment();
        String totalAmount = amount.getText().trim();
       // String gstAmount2 = gstAmount.getText().trim();
        String finalAmount = finalAmountPaid.getText().trim();
        String vendorName1 = vendorName.getSelectedItem().toString();
        String discountAmount = discount.getText();
        Date purDate = purchaseDate.getDate();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
        String mfg = dateFormat.format(purDate);
        String gstType ;
        if(gstTaken.isSelected()){
           gstType="GST"; 
        }
        else if(igstTaken.isSelected()){
           gstType="IGST"; 
        }else{
           gstType="NON-GST"; 
        }

         payment.setValues(purchaseDate, totalAmount,discountAmount, finalAmount, getTableData(), vendorName1,gstType);
         payment.setVisible(true);
 
    }//GEN-LAST:event_PayActionPerformed

    private void igstTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igstTakenActionPerformed
//        gstTaken.setVisible(false);
//      //  igstP.setVisible(true);
//        gst.setVisible(true);
//        if(igstTaken.isSelected()){
//            igstP.setSelected(true);
//        }

    }//GEN-LAST:event_igstTakenActionPerformed

    private void finalAmountPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAmountPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalAmountPaidActionPerformed

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        if(!(discount.getText().trim().isEmpty()))
        //getFinalAmountPaid(discount.getText());
      //  else
        finalAmountPaid.setText("0.00");
    }//GEN-LAST:event_discountKeyReleased

    private void discountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusLost
        if(discount.getText().trim().isEmpty())
        discount.setText("0.00");
    }//GEN-LAST:event_discountFocusLost

    private void discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusGained
        discount.selectAll();
    }//GEN-LAST:event_discountFocusGained

    private void jCheckBoxDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDiscountActionPerformed
        discount.setText("0.00");
        finalAmountPaid.setText("0.00");
        if(jCheckBoxDiscount.isSelected())
        {
            jPanelDiscount.setVisible(true);
        }
        else
        {
            jPanelDiscount.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxDiscountActionPerformed

    private void gstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstActionPerformed
     /*   if(!(sellingPrice.getText().trim().isEmpty()) && gst.getSelectedItem()!="0")
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float sellingPrice = Float.parseFloat(this.sellingPrice.getText());
            float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());

            float gstAmount = calculateGst(sellingPrice, gstPercent);
            this.gstAmount.setText(decimalFormat.format(gstAmount));

            finalAmount.setText(decimalFormat.format(sellingPrice + gstAmount));
            //  float igstPercent = Float.parseFloat(gst.getSelectedItem().toString());
        }
        else
        finalAmount.setText("0.00"); 
        */
        
          if(!(total.getText().trim().isEmpty()) && gst.getSelectedItem()!="0")
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float total = Float.parseFloat(this.total.getText());
            float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());

//            float gstAmount = calculateGst(total, gstPercent);
//            this.gstAmount.setText(decimalFormat.format(gstAmount));
//
//            purchaseGstAmount.setText(decimalFormat.format(total - gstAmount));
            
            
           float gstPercentTotal = calculateGSTPerNew(gstPercent);
           //this.gstPer.setText(decimalFormat.format(gstPercentTotal));
           float gt = calculateGSTPerNew(gstPercent)+1;
           float gtTotal =(gstPercentTotal/gt);
           float purchaseGstAmount1 = (gstPercentTotal / gt)*total;
           this.purchaseGstAmountNew.setText(decimalFormat.format(purchaseGstAmount1));
           
           float actualAmount = total -purchaseGstAmount1;
           this.actualTotal.setText(decimalFormat.format(actualAmount));
           
            //  float igstPercent = Float.parseFloat(gst.getSelectedItem().toString());
        }
//        else
//        purchaseGstAmount.setText("0.00");
        
        
    }//GEN-LAST:event_gstActionPerformed

    private void gstNotTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstNotTakenActionPerformed
        gstTaken.setVisible(false);
        gstTaken.setSelected(false);
//        igstP.setVisible(false);
//        igstP.setSelected(false);
        gst.setVisible(false);
        
        gstNotTaken.setVisible(true);
    }//GEN-LAST:event_gstNotTakenActionPerformed

    private void gstTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstTakenActionPerformed
//        igstP.setVisible(false);
        gstTaken.setVisible(true);
        gst.setVisible(true);
        if(gstTaken.isSelected()){
            gstTaken.setSelected(true);
        }
    }//GEN-LAST:event_gstTakenActionPerformed

    private void totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyReleased
        if(!(total.getText().trim().isEmpty()))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float quantity = Float.parseFloat(this.quantity.getText());
            float total = Float.parseFloat(this.total.getText());

            float unitPrice = getUnitPrice(total, quantity);
          //  this.unitPrice.setText(decimalFormat.format(unitPrice));
        }
        else
        unitPrice.setText("0.00");
    }//GEN-LAST:event_totalKeyReleased

    private void totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusGained
        total.selectAll();
    }//GEN-LAST:event_totalFocusGained

    private void totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusLost
        if(total.getText().trim().isEmpty())
        {
            total.setText("0.00");
            unitPrice.setText("0.00");
        }
        if(Float.parseFloat(total.getText()) == 0)
        unitPrice.setText("0.00");
    }//GEN-LAST:event_totalFocusLost

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        if(!(quantity.getText().trim().isEmpty()))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float quantity = Float.parseFloat(this.quantity.getText());
            float total = Float.parseFloat(this.total.getText());

            float unitPrice = getUnitPrice(total, quantity);
            this.unitPrice.setText(decimalFormat.format(unitPrice));
        }
        else
        unitPrice.setText("0.00");
    }//GEN-LAST:event_quantityKeyReleased

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusLost
        if(quantity.getText().trim().isEmpty())
        quantity.setText("0.00");
    }//GEN-LAST:event_quantityFocusLost

    private void quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusGained
        quantity.selectAll();
    }//GEN-LAST:event_quantityFocusGained

    private void unitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceActionPerformed

    private void unitPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitPriceFocusGained

    }//GEN-LAST:event_unitPriceFocusGained

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      //  remove();
    }//GEN-LAST:event_removeActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
//        
//            try{addToTable();
//            
//            }catch(Exception e) {
//                e.printStackTrace();
//            }
    }//GEN-LAST:event_addKeyPressed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try{
            pay();
            
            }catch(Exception e) {
               e.printStackTrace();
            }
    }//GEN-LAST:event_addActionPerformed

    private void vendorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorNameActionPerformed
//        newVendor.setText("");
//        registration.setText("N/A");
//        contact.setText("N/A");
//        address.setText("N/A");
//        gstNumber.setText("N/A");

//        VendorDetails vendorDetail = new VendorDetails();
//        vendorDetail.setVisible(true);
        try
        {
            if(vendorName.getItemCount() != 0)
            {
                if(vendorName.getSelectedIndex() == 0)
                {
                    vendorFlag = false;
                    
                   // jPanelNewVendor.setVisible(false);
                }
                else
                if(vendorName.getSelectedIndex() == 1)
                {
                    vendorFlag = false;
                   // jPanelNewVendor.setVisible(true);
                }
                else
                {
                    vendorFlag = true;
                   // jPanelNewVendor.setVisible(false);
                   // loadVendor();
                }
            }
        }
        catch(Exception e)
        {
        }

    }//GEN-LAST:event_vendorNameActionPerformed

    private void newItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newItemKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
        evt.consume();
    }//GEN-LAST:event_newItemKeyTyped

    private void newItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemFocusGained
        newItem.selectAll();
    }//GEN-LAST:event_newItemFocusGained

    private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
                newItem.setText("");
                if(item.getSelectedIndex() == 1)
                        jPanelItem.setVisible(true);
                else
                    jPanelItem.setVisible(false);
        
        newItem.setText("");
        try
        {
            if(item.getItemCount() != 0)
            {
                if(item.getSelectedIndex() == 0)
                {
                    itemFlag = false;
                   // jPanelNewVendor.setVisible(false);
                }
                else
                if(item.getSelectedIndex() == 1)
                {
                    itemFlag = false;
                    jPanelItem.setVisible(true);
                }
                else
                {
                    itemFlag = true;
                    jPanelItem.setVisible(false);
                   // loadItem();
                }
            }
        }
        catch(Exception e)
        {
        }

    }//GEN-LAST:event_itemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     VendorDetails vendorDetails = new VendorDetails();
       // VendorDetails2 vendorDetails = new VendorDetails2();
      vendorDetails.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       // if(evt.getKeyCode() == KeyEvent.VK_ENTER)
      //  remove();
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        HomePage1 obj = new HomePage1();
//        obj.show();

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void actualTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_actualTotalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_actualTotalFocusGained

    private void actualTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_actualTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_actualTotalFocusLost

    private void actualTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_actualTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_actualTotalKeyReleased

    private void purchaseGstAmountNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseGstAmountNewFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseGstAmountNewFocusGained

    private void purchaseGstAmountNewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseGstAmountNewFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseGstAmountNewFocusLost

    private void purchaseGstAmountNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseGstAmountNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseGstAmountNewActionPerformed

    private void purchaseGstAmountNewKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseGstAmountNewKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseGstAmountNewKeyReleased

    private void brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandActionPerformed
        newBrand.setText("");
        if(brand.getSelectedIndex() == 1)
        jPanelBrand.setVisible(true);
        else
        jPanelBrand.setVisible(false);

        newBrand.setText("");
        try
        {
            if(brand.getItemCount() != 0)
            {
                if(brand.getSelectedIndex() == 0)
                {
                    brandFlag = false;
                    // jPanelNewVendor.setVisible(false);
                }
                else
                if(brand.getSelectedIndex() == 1)
                {
                    brandFlag = false;
                    jPanelBrand.setVisible(true);
                }
                else
                {
                    brandFlag = true;
                    jPanelBrand.setVisible(false);
                    // loadItem();
                }
            }
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_brandActionPerformed

    private void newBrandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newBrandFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_newBrandFocusGained

    private void newBrandKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newBrandKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_newBrandKeyTyped

    private void quantity1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantity1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1FocusGained

    private void quantity1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantity1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1FocusLost

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1KeyReleased

    private void item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pay;
    private javax.swing.JFormattedTextField actualTotal;
    private javax.swing.JButton add;
    private javax.swing.JTextField amount;
    private javax.swing.JComboBox<String> brand;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JFormattedTextField discount;
    private javax.swing.JTextField finalAmountPaid;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JRadioButton gstNotTaken;
    private javax.swing.JRadioButton gstTaken;
    private javax.swing.JRadioButton igstTaken;
    private javax.swing.JComboBox<String> item;
    private javax.swing.JComboBox<String> item2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBoxDiscount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBrand;
    private javax.swing.JPanel jPanelDiscount;
    private javax.swing.JPanel jPanelItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField newBrand;
    private javax.swing.JTextField newItem;
    private com.toedter.calendar.JDateChooser purchaseDate;
    private javax.swing.JFormattedTextField purchaseGstAmountNew;
    private javax.swing.JFormattedTextField quantity;
    private javax.swing.JFormattedTextField quantity1;
    private javax.swing.JButton remove;
    private javax.swing.JFormattedTextField total;
    private javax.swing.JTextField unitPrice;
    private javax.swing.JComboBox<String> vendorName;
    // End of variables declaration//GEN-END:variables
 
    private void pay() 
    { 
        try
        {
            boolean isGstTaken = false;
            String chequeNumber = "";
            VendorPartialPayment vendorPartialPayment = new VendorPartialPayment();
            
            Expenses expenses = new Expenses();
            ExpensesQuery expensesQuery = new ExpensesQuery();

            if(jTable1.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Nothing to save"), "Error message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String vendorName = this.vendorName.getSelectedItem().toString();

            if(vendorName.equalsIgnoreCase("--select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select a vendor"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.vendorName.requestFocus();
                return;
            }
           
            Date purchaseDate = this.purchaseDate.getDate();
      
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
                String stringPurchaseDate = dateFormat.format(purchaseDate);
                
            if(jCheckBoxDiscount.isSelected())
            {
                if(discount.getText().trim().isEmpty() || Float.parseFloat(discount.getText()) == 0)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Discount Amount"), "Error message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                
                if(Float.parseFloat(discount.getText()) > Float.parseFloat(amount.getText()))
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
            }
            VendorMaster vendorMaster = new VendorMaster();
            VendorQuery vendorQuery = new VendorQuery();

            vendorMaster.setName(vendorName);

            List<VendorMaster> list = vendorQuery.getVendorDetails(vendorMaster);

            if(!(list.isEmpty()) && newVendorFlag == true)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This Vendor already exists"), "Error message", JOptionPane.ERROR_MESSAGE);
               // newVendor.requestFocus();
                newVendorFlag = false;
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of making this Purchase?"));
            
            if(confirm == JOptionPane.YES_OPTION)
            {
                BigDecimal balance;
                String status = "";
                if(list.isEmpty())
                    vendorQuery.insertVendor(vendorMaster);        
                else
                {
                    for(VendorMaster vm: list)
                    {
                        vendorMaster.setId(vm.getId());
                    }
                    vendorQuery.updateVendor(vendorMaster);
                }            
            
                VendorBillMaster vendorBillMaster = new VendorBillMaster();
                VendorBillMasterQuery vendorBillMasterQuery = new VendorBillMasterQuery();
                StoreDetails storeDetails = new StoreDetails();
                
                storeDetails.setId(1);
                
                vendorBillMaster.setDate(purchaseDate);
                vendorBillMaster.setStoreDetails(storeDetails);
                vendorBillMaster.setVendorMaster(vendorMaster);
                vendorBillMaster.setBillAmount(new BigDecimal(amount.getText().trim()));
                vendorBillMaster.setDiscount(new BigDecimal(discount.getText()));
                vendorBillMaster.setFinalBillAmount(new BigDecimal(amount.getText()).subtract(new BigDecimal(discount.getText())));
                vendorBillMaster.setRemark("GST Not Taken");
                vendorBillMasterQuery.insertIntoVendorBillMaster(vendorBillMaster);

                vendorPartialPayment.setDate(purchaseDate);
                vendorPartialPayment.setVendorMaster(vendorMaster);
                vendorPartialPayment.setPaidAmount(new BigDecimal(amount.getText().trim()).subtract(new BigDecimal(discount.getText())));
                vendorPartialPayment.setChequeCardNumber(chequeNumber);
                vendorPartialPayment.setStatus(status);
                VendorPartialPaymentQuery vendorPartialPaymentQuery = new VendorPartialPaymentQuery();
                vendorPartialPaymentQuery.insertIntoVendorPartialPayment(vendorPartialPayment);

                
                PurchaseMaster purchaseMaster = new PurchaseMaster();
                
               // ItemMaster purchaseMaster = new ItemMaster();
                ItemAvailability itemAvailability = new ItemAvailability();
                StockDetailsPurchase stockDetails = new StockDetailsPurchase();

                //ItemQuery itemQuery = new ItemQuery();
                PurchaseMasterQuery purchaseMasterQuery = new PurchaseMasterQuery();
                StockDetailsQuery stockDetailsQuery = new StockDetailsQuery();
                ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();
                
                String itemName = "";
                String brandName = "";
                String itemWeight = "";
                String itemUnit = "";
                BigDecimal quantity;
                BigDecimal total;
                BigDecimal unitPrice;
                BigDecimal gstPercent;
                BigDecimal actualAmount;                
                BigDecimal gstAmount;                
                BigDecimal finalTotal;
                BigDecimal sellingPrice;

                String remark = "";

                int i = 0;
                int count = 0;

                while(i < jTable1.getRowCount())
                {
                    itemName = jTable1.getValueAt(i, 0).toString();
                    brandName = jTable1.getValueAt(i, 1).toString();
                    itemWeight = jTable1.getValueAt(i, 2).toString();
                    itemUnit = jTable1.getValueAt(i, 3).toString();
                    quantity = new BigDecimal(jTable1.getValueAt(i, 4).toString());
                    total = new BigDecimal(jTable1.getValueAt(i, 5).toString());
                    unitPrice = new BigDecimal(jTable1.getValueAt(i, 6).toString());
                    gstPercent = new BigDecimal(jTable1.getValueAt(i, 7).toString());
                    actualAmount = new BigDecimal(jTable1.getValueAt(i, 8).toString());
                    gstAmount = new BigDecimal(jTable1.getValueAt(i, 9).toString());
                    finalTotal = new BigDecimal(jTable1.getValueAt(i, 10).toString());
                    //sellingPrice = new BigDecimal(jTable1.getValueAt(i, 9).toString());
                    remark = jTable1.getValueAt(i, 11).toString();
                    
                    if(!(isGstTaken))
                        if(remark.equalsIgnoreCase("gst taken"))
                        {
                            isGstTaken = true;
                            vendorBillMaster.setRemark("GST Taken");
                        }
                    purchaseMaster.setName(itemName);   
                    purchaseMaster.setBrand(brandName);   
                    purchaseMaster.setWeight(itemWeight);
                    purchaseMaster.setUnit(itemUnit);
                    purchaseMaster.setQuantity(quantity);
                    purchaseMaster.setTotal(total);
                    purchaseMaster.setGstType(remark);
                   // purchaseMaster.setGstPercent(gstPercent);
                    purchaseMaster.setActualAmount(actualAmount);
                    purchaseMaster.setGstAmount(gstAmount);
                    purchaseMaster.setUnitPrice(unitPrice);
                  
                    List<PurchaseMaster> itemList = purchaseMasterQuery.checkItem(purchaseMaster);
                    if(itemList.isEmpty())
                        purchaseMasterQuery.insertItem(purchaseMaster);
                  
                    i++;
                } 


                if(isGstTaken)
                    vendorBillMasterQuery.updateVendorBillMaster(vendorBillMaster);
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Stock added successfully"));

                DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
                defaultTableModel.setRowCount(0);
                jTable1.setModel(defaultTableModel);
               
                this.vendorName.setSelectedIndex(0);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Stock Details failed to save"), "Error Mesage", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
        
     private float calculatePer(float gstPercent)
    {
        float gstPer = 1+(gstPercent ) /100;      
        return gstPer;
    }
        
     private float calculateGSTPerNew(float gstPercent)
    {
        float gstPer =(gstPercent)/100 ;      
        return gstPer;
    }
     public TableModel getTableData() {
        return jTable1.getModel();
    }

   private float getUnitPrice(float total, float quantity)
    {
        float unitPrice = 0;
        try
        {
           if(quantity == 0)
               throw new RuntimeException();
           unitPrice = total/quantity;
            
        }
        catch(Exception e)
        {
            this.unitPrice.setText("0.00");
        }
        return unitPrice;
    }
        
    
}

   
