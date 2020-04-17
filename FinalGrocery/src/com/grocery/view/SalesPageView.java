/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;


import com.grocery.bean.Counter;
import com.grocery.bean.CustomerMaster;
import com.grocery.bean.CustomerPartialPayment;
import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.bean.SaleDetails;
import com.grocery.bean.SaleMaster;
import com.grocery.bean.StoreDetails;
import com.grocery.dimension.SetDimension;
import com.grocery.query.CounterQuery;
import com.grocery.query.CustomerPartialPaymentQuery;
import com.grocery.query.ItemAvailabilityQuery;
import com.grocery.query.ItemQuery;
import com.grocery.query.SaleDetailsQuery;
import com.grocery.query.SaleMasterQuery;
import com.grocery.read.MessageFormat;
import com.grocery.read.ReadFile;
import com.grocery.util.MyConnection;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class SalesPageView extends javax.swing.JInternalFrame {

    private Date currentDate = new Date();
    private JTextFieldDateEditor editor;
    private JDesktopPane jDesktopPane;
    
    public SalesPageView(JDesktopPane jDesktopPane) {
        initComponents();
        this.jDesktopPane = jDesktopPane;
        gstTaken.setSelected(true);
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        
        jTable2.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setMinWidth(0);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        editor = (JTextFieldDateEditor)date.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor)chequeDate.getDateEditor();
        editor.setEditable(false);
        jPanelNumber.setVisible(false);
        
        date.setDate(currentDate);
        chequeDate.setDate(currentDate);
        item.requestFocus();
        jPanelDiscount.setVisible(false);
        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
        loadCounter();
        getTotal();
    }

    public SalesPageView(JDesktopPane jDesktopPane, SaleMaster saleMaster, CustomerPartialPayment customerPartialPayment, String counter) 
    {
        initComponents();
        reference.setText(saleMaster.getReference());
        this.jDesktopPane = jDesktopPane;
        gstTaken.setSelected(true);
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        
        jTable2.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        
        jTable2.getColumnModel().getColumn(1).setMinWidth(0);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        editor = (JTextFieldDateEditor)date.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor)chequeDate.getDateEditor();
        editor.setEditable(false);
        jPanelNumber.setVisible(false);
        
        date.setDate(currentDate);
        chequeDate.setDate(currentDate);
        item.requestFocus();
        jPanelDiscount.setVisible(false);
        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
        loadCounter();
        this.counter.setSelectedItem(counter);
        
        if(!(saleMaster.getDiscount().compareTo(new BigDecimal(0)) == 0))
        {
            System.out.println("true");
            jCheckBoxDiscount.setSelected(true);
            jPanelDiscount.setVisible(true);
            discount.setText(String.valueOf(saleMaster.getDiscount()));
            finalAmount.setText(String.valueOf(saleMaster.getFinalBillAmount()));
        }
        
        paymentMode.setSelectedItem(customerPartialPayment.getPaymentMode());
        
        if(!(customerPartialPayment.getBank().equalsIgnoreCase("n/a")))
            bank.setSelectedItem(customerPartialPayment.getBank());
        
        if(customerPartialPayment.getChequeDate() != null)
        {
            chequeDate.setVisible(true);
            chequeDate.setDate(customerPartialPayment.getChequeDate());
        }
        
        if(saleMaster.getRemark().equalsIgnoreCase("gst taken"))
            gstTaken.setSelected(true);
        else
            gstNotTaken.setSelected(true);
        
        if(!(customerPartialPayment.getChequeOrCardNumber().equalsIgnoreCase("n/a")))
            number.setText(customerPartialPayment.getChequeOrCardNumber());
        
        getTotal();
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        billId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        item = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        add = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        counter = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        paymentMode = new javax.swing.JComboBox<>();
        jPanelNumber = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        chequeDate = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        bank = new javax.swing.JComboBox<>();
        fullPayment = new javax.swing.JButton();
        change = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        partialPayment = new javax.swing.JButton();
        jCheckBoxDiscount = new javax.swing.JCheckBox();
        jPanelDiscount = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        finalAmount = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        gstTaken = new javax.swing.JRadioButton();
        gstNotTaken = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Date:");

        date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Bill Id:");

        billId.setEditable(false);
        billId.setBackground(new java.awt.Color(255, 255, 153));
        billId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        billId.setForeground(new java.awt.Color(255, 0, 0));
        billId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billIdActionPerformed(evt);
            }
        });

        item.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        item.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Search By Name:");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Item Name", "HSN Code", "Availability", "Unit Price", "GST %", "Selling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        add.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        add.setText("Add");
        add.setMnemonic(KeyEvent.VK_A);
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

        jLabel18.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Counter:");

        counter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        counter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counterActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Sale Details:");

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Details Id", "Item Id", "Item Name", "HSN Code", "Unit Price", "GST %", "Selling Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel31.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Total:");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 153));
        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.setForeground(new java.awt.Color(255, 0, 0));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        remove.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        remove.setText("Remove");
        remove.setMnemonic(KeyEvent.VK_R);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        remove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                removeKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Payment Details:");

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Payment Mode:");

        paymentMode.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card", "Cheque", "Paytm" }));
        paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentModeActionPerformed(evt);
            }
        });

        jPanelNumber.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Card/Cheque #:");

        number.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberKeyTyped(evt);
            }
        });

        chequeDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Bank Name:");

        bank.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.P. Mahesh Co-Op Urban Bank Ltd", "Abhyudaya Co-op Bank Ltd", "Abu Dhabi Commercial Bank", "Ahmedabad Mercantile Co-operative Bank Ltd", "Allahabad Bank", "Andhra Bank", "Apna Sahakari Bank Ltd.", "Axis Bank", "Bank Of America", "Bank Of Bahrain And Kuwait", "Bank Of Baroda", "Bank Of Ceylon", "Bank Of India", "Bank Of Maharashtra", "Bank Of Nova Scotia", "Bank Of Rajasthan Ltd", "Bank Of Tokyo-Mitsubishi UFJ Ltd", "Barclays Bank PLC", "Bassein Catholic Co-Op Bank Ltd", "Bharat Co-operative Bank (Mumbai) Ltd", "Bharat Overseas Bank", "BNP Paribas", "Calyon Bank", "Canara Bank", "Catholic Syrian Bank Ltd", "Central Bank Of India", "Chinatrust Commercial Bank", "Citibank NA", "Citizencredit Co-operative Bank Ltd", "City Union Bank Ltd", "Corporation Bank", "Cosmos Co-operative Bank Ltd.", "Credit Agricole Corp N Invsmnt Bank", "DBS Bank Ltd", "Dena Bank", "Deutsche Bank AG", "Development Credit Bank Limited", "Dhanalakshmi Bank Ltd", "DICGC", "Dombivli Nagari Sahakari Bank Limited", "Federal Bank Ltd", "Firstrand Bank Limited", "Greater Bombay Co-op. Bank Ltd", "HDFC Bank Ltd", "HSBC", "ICICI Bank Ltd", "IDBI Bank Ltd", "Indian Bank", "Indian Overseas Bank", "Indusind Bank Ltd", "ING Vysya Bank Ltd", "Jammu And Kashmir Bank Ltd", "Janakalyan Sahakari Bank Ltd", "Janata Sahakari Bank Ltd (Pune)", "JP Morgan Chase Bank NA", "Kallappanna Awade Ich Janata S Bank", "Kalupur Commercial Co. Op. Bank Ltd.", "Kalyan Janata Sahakari Bank Ltd.", "Kapole Co Op Bank", "Karad Urban Co-Op Bank Ltd", "Karnataka Bank Ltd", "Karnataka State Apex  Coop. Bank Ltd.", "Karur Vysya Bank", "Kotak Mahindra Bank", "Lakshmi Vilas Bank Ltd", "Mahanagar Co-op Bank Ltd", "Maharashtra State Co Operative Bank", "Mashreq Bank PSC", "Mehsana Urban Cooperative Bank Ltd", "Mizuho Corporate Bank Ltd", "Nagpur Nagrik Sahakari Bank Ltd", "Nainital Bank Limited", "Nasik Merchants Co-Op Bank Ltd", "New India Co-operative Bank Ltd", "Nkgsb Co-op Bank Ltd", "Nutan Nagarik Sahakari Bank Ltd", "Oman International Bank Saog", "Oriental Bank Of Commerce", "Parsik Janata Sahakari Bank Ltd", "PMC Bank", "Punjab And Maharashtra Co-op Bank Ltd", "Punjab And Sind Bank", "Punjab National Bank", "Rajkot Nagarik Sahakari Bank Ltd", "Ratnakar Bank Ltd", "Reserve Bank Of India", "Saraswat Co-operative Bank Ltd", "Shamrao Vithal Co-operative Bank Limited", "Shinhan Bank", "Societe Generale", "South Indian Bank", "Standard Chartered Bank", "State Bank Of Bikaner And Jaipur", "State Bank Of Hyderabad", "State Bank Of India", "State Bank Of Indore", "State Bank Of Mauritius Ltd", "State Bank Of Mysore", "State Bank Of Patiala", "State Bank Of Travancore", "Surat Peoples Co-Op Bank Ltd", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd", "Tamilnadu State Apex Cooperative Bank Limited", "Thane Janata Sahakari Bank Ltd", "The Royal Bank Of Scotland NV", "UBS AG", "UCO Bank", "Union Bank Of India", "United Bank Of India", "Vijaya Bank", "West Bengal State Cooperative Bank Ltd", "Yes Bank Ltd" }));

        javax.swing.GroupLayout jPanelNumberLayout = new javax.swing.GroupLayout(jPanelNumber);
        jPanelNumber.setLayout(jPanelNumberLayout);
        jPanelNumberLayout.setHorizontalGroup(
            jPanelNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNumberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNumberLayout.setVerticalGroup(
            jPanelNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNumberLayout.createSequentialGroup()
                .addGroup(jPanelNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fullPayment.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        fullPayment.setText("Full Payment");
        fullPayment.setMnemonic(KeyEvent.VK_F);
        fullPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaymentActionPerformed(evt);
            }
        });
        fullPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fullPaymentKeyPressed(evt);
            }
        });

        change.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        change.setText("Change Quantity");
        change.setMnemonic(KeyEvent.VK_Q);
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        change.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                changeKeyPressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Item Availability:");

        partialPayment.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        partialPayment.setText("Partial Payment");
        partialPayment.setMnemonic(KeyEvent.VK_P);
        partialPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partialPaymentActionPerformed(evt);
            }
        });
        partialPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                partialPaymentKeyPressed(evt);
            }
        });

        jCheckBoxDiscount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxDiscount.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxDiscount.setText("Discount:");
        jCheckBoxDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDiscountActionPerformed(evt);
            }
        });

        jPanelDiscount.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Final Amount:");

        discount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discount.setText("0.00");
        discount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        discount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                discountFocusGained(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Discount Amount:");

        finalAmount.setEditable(false);
        finalAmount.setBackground(new java.awt.Color(255, 255, 153));
        finalAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        finalAmount.setForeground(new java.awt.Color(255, 0, 0));
        finalAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalAmount.setText("0.00");
        finalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalAmountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDiscountLayout = new javax.swing.GroupLayout(jPanelDiscount);
        jPanelDiscount.setLayout(jPanelDiscountLayout);
        jPanelDiscountLayout.setHorizontalGroup(
            jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiscountLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(12, 12, 12)
                .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanelDiscountLayout.setVerticalGroup(
            jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiscountLayout.createSequentialGroup()
                .addGroup(jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
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

        buttonGroup1.add(gstTaken);
        gstTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gstTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstTaken.setText("GST");
        gstTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstTakenActionPerformed(evt);
            }
        });

        buttonGroup1.add(gstNotTaken);
        gstNotTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gstNotTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstNotTaken.setText("Non - GST");
        gstNotTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstNotTakenActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Reference:");

        reference.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reference.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reference.setText("N/A");
        reference.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                referenceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                referenceFocusLost(evt);
            }
        });
        reference.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                referenceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator5)
            .addComponent(jSeparator4)
            .addComponent(jSeparator9)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(281, 281, 281))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(535, 535, 535)
                                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fullPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(partialPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jCheckBoxDiscount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(26, 26, 26)
                                .addComponent(gstTaken)
                                .addGap(18, 18, 18)
                                .addComponent(gstNotTaken)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(510, 510, 510)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(450, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(545, 545, 545))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(counter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove)
                    .addComponent(change))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gstTaken)
                    .addComponent(gstNotTaken)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxDiscount)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fullPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(partialPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyReleased
        ItemMaster itemMaster = new ItemMaster();
        if(!(item.getText().trim().isEmpty()))
            itemMaster.setName(item.getText().trim());
        loadTable(itemMaster);
    }//GEN-LAST:event_itemKeyReleased

    private void itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
        evt.consume();
    }//GEN-LAST:event_itemKeyTyped

    private void counterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterActionPerformed
        if(counter.getItemCount() > 0)
        {
            ItemMaster itemMaster = new ItemMaster();
            loadTable(itemMaster);
            getDetails();
            
            jPanelDiscount.setVisible(false);
            jCheckBoxDiscount.setSelected(false);
            discount.setText("0.00");
            finalAmount.setText("0.00");
        }
    }//GEN-LAST:event_counterActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        addItem();
    }//GEN-LAST:event_addActionPerformed

    private void paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentModeActionPerformed
        number.setText("");
        chequeDate.setVisible(false);
        jLabel25.setVisible(false);
        bank.setVisible(false);
        if(paymentMode.getItemCount() > 0)
        {
            if(paymentMode.getSelectedItem().toString().equalsIgnoreCase("cash"))
                jPanelNumber.setVisible(false);
            else
                if(paymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque"))
                {
                    jPanelNumber.setVisible(true);
                    chequeDate.setVisible(true);
                    jLabel25.setVisible(true);
                    bank.setVisible(true);
                }   
                else
                    if(paymentMode.getSelectedItem().toString().equalsIgnoreCase("card"))
                    {
                        jPanelNumber.setVisible(true);
                        jLabel25.setVisible(true);
                        bank.setVisible(true);
                    }
                    else
                    {
                        jPanelNumber.setVisible(true);
                        jLabel25.setVisible(false);
                        bank.setVisible(false);
                    }
        }
    }//GEN-LAST:event_paymentModeActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove();
    }//GEN-LAST:event_removeActionPerformed

    private void numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_numberKeyTyped

    private void fullPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaymentActionPerformed
        pay();
    }//GEN-LAST:event_fullPaymentActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            addItem();
    }//GEN-LAST:event_addKeyPressed

    private void removeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            remove();
    }//GEN-LAST:event_removeKeyPressed

    private void fullPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullPaymentKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            pay();
    }//GEN-LAST:event_fullPaymentKeyPressed

    private void itemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyPressed
 
    }//GEN-LAST:event_itemKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            addItem();
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            remove();
    }//GEN-LAST:event_jTable2KeyPressed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        changeQuantity();
    }//GEN-LAST:event_changeActionPerformed

    private void changeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            changeQuantity();
    }//GEN-LAST:event_changeKeyPressed

    private void partialPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partialPaymentActionPerformed
        partialPayment();
    }//GEN-LAST:event_partialPaymentActionPerformed

    private void partialPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_partialPaymentKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_partialPaymentKeyPressed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        checkDispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            checkDispose();
    }//GEN-LAST:event_cancelKeyPressed

    private void jCheckBoxDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDiscountActionPerformed
        discount.setText("0.00");
        finalAmount.setText("0.00");
        if(jCheckBoxDiscount.isSelected())
            jPanelDiscount.setVisible(true);
        else
            jPanelDiscount.setVisible(false);
    }//GEN-LAST:event_jCheckBoxDiscountActionPerformed

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        if(!(discount.getText().trim().isEmpty()))
            getFinalAmountPaid(discount.getText());
        else
            finalAmount.setText(total.getText());
    }//GEN-LAST:event_discountKeyReleased

    private void discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusGained
        discount.selectAll();
    }//GEN-LAST:event_discountFocusGained

    private void gstTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstTakenActionPerformed
        if(jTable2.getRowCount() > 0)
            getGstTaken();
    }//GEN-LAST:event_gstTakenActionPerformed

    private void gstNotTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstNotTakenActionPerformed
        if(jTable2.getRowCount() > 0)
            getGstNotTaken();
    }//GEN-LAST:event_gstNotTakenActionPerformed

    private void referenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_referenceKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || c == '.' || c == '-'))
            evt.consume();
    }//GEN-LAST:event_referenceKeyTyped

    private void referenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusGained
        reference.selectAll();
    }//GEN-LAST:event_referenceFocusGained

    private void referenceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusLost
        if(reference.getText().trim().isEmpty())
            reference.setText("N/A");
    }//GEN-LAST:event_referenceFocusLost

    private void billIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billIdActionPerformed

    private void finalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> bank;
    private javax.swing.JTextField billId;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton change;
    private com.toedter.calendar.JDateChooser chequeDate;
    private javax.swing.JComboBox<String> counter;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JFormattedTextField discount;
    private javax.swing.JTextField finalAmount;
    private javax.swing.JButton fullPayment;
    private javax.swing.JRadioButton gstNotTaken;
    private javax.swing.JRadioButton gstTaken;
    private javax.swing.JTextField item;
    private javax.swing.JCheckBox jCheckBoxDiscount;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDiscount;
    private javax.swing.JPanel jPanelNumber;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField number;
    private javax.swing.JButton partialPayment;
    private javax.swing.JComboBox<String> paymentMode;
    private javax.swing.JTextField reference;
    private javax.swing.JButton remove;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
    
    public void loadTable(ItemMaster itemMaster)
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
        defaultTableModel.setRowCount(0);
        
        List<Object[]> list = new ArrayList<>();
        
        ItemAvailability itemAvailability = new ItemAvailability();
        ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();
        
        itemAvailability.setItemMaster(itemMaster);
        list = itemAvailabilityQuery.getAvailability(itemAvailability);
        
        for(Object[] object: list)
        {
            ItemAvailability ia = (ItemAvailability)object[0];
            
            defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getHsnCode(), ia.getAvailability(), ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getGstPercent(), ia.getItemMaster().getFinalSellingPrice()});
        }
        jTable1.setModel(defaultTableModel);
    }
    
    private void loadCounter() 
    {
        CounterQuery counterQuery = new CounterQuery();
        
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel)counter.getModel();
        defaultComboBoxModel.removeAllElements();
        
        Counter counter = new Counter();
        
        List<Counter> list = counterQuery.getCounterDetails(counter);
        
        for(Counter c: list)
            defaultComboBoxModel.addElement(c.getName());
        
        this.counter.setModel(defaultComboBoxModel);
    }

    private void getDetails() 
    {
        Counter counter = new Counter();
        CounterQuery counterQuery = new CounterQuery();
        
        counter.setName(this.counter.getSelectedItem().toString());
        List<Counter> list = counterQuery.getCounterDetails(counter);
        
        for(Counter c: list)
            counter.setId(c.getId());
        
        SaleMaster saleMaster = new SaleMaster();
        SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
        
        saleMaster.setCounter(counter);
        
        List<SaleMaster> saleList = saleMasterQuery.getSaleDetails(saleMaster);
        
        for(SaleMaster sm: saleList)
            saleMaster.setId(sm.getId());
        
       if(saleList.isEmpty())
           billId.setText("");
       else
           billId.setText(String.valueOf(saleMaster.getId()));
       
       getSaleDetails(saleMaster);
    }

    private void getSaleDetails(SaleMaster saleMaster) 
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable2.getModel();
        defaultTableModel.setRowCount(0);
        
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
        
        saleDetails.setSaleMaster(saleMaster);
        
        List<Object[]> list = saleDetailsQuery.getSale(saleDetails);
        
        for(Object[] object: list)
        {
            SaleDetails sd = (SaleDetails)object[0];
            
            defaultTableModel.addRow(new Object[]{sd.getId(), sd.getItemMaster().getId(), sd.getItemMaster().getName(), sd.getItemMaster().getHsnCode(), sd.getUnitPrice(), sd.getGstPercent(), sd.getSellingPrice(), sd.getQuantity(), sd.getTotal()});
        }
        
        jTable2.setModel(defaultTableModel);
        
        getTotal();
    }

    private void getTotal() 
    {
        int i = 0;
        float sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        
        while(i < jTable2.getRowCount())
        {
            sum = sum + Float.parseFloat(jTable2.getValueAt(i, 8).toString());
            i++;
        }
        total.setText(decimalFormat.format(sum));
    }

    private void addItem() 
    {
        try
        {
            String hsnCode = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
            float availability = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            int itemId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            float sellingPrice = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            float unitPrice = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            float gstPercent = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
            String itemName = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            DecimalFormat decimalFormat = new DecimalFormat("#0.000");
            float total = 0;
            float soldQuantity = 0f;
            
            JFrame frame = new JFrame("Input");
            
            try
            {
                soldQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(availability) + "</FONT></HTML>" ));
                
                if(soldQuantity > availability)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be greater than Available Quantity"), "Error Message", JOptionPane.ERROR_MESSAGE);
                }
                else 
                    if(soldQuantity == 0)
                    {
                        JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        total = soldQuantity * sellingPrice;

                        ItemMaster itemMaster = new ItemMaster();
                        itemMaster.setId(itemId);

                        SaleMaster saleMaster = new SaleMaster();
                        SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
                        StoreDetails storeDetails = new StoreDetails();
                        CustomerMaster customerMaster = new CustomerMaster();
                        Counter counter = new Counter();
                        CounterQuery counterQuery = new CounterQuery();

                        counter.setName(this.counter.getSelectedItem().toString());
                        List<Counter> list = counterQuery.getCounterDetails(counter);

                        for(Counter c: list)
                            counter.setId(c.getId());

                        if(billId.getText().isEmpty())
                        {
                            Date date = this.date.getDate();
                            storeDetails.setId(1);
                            customerMaster.setId(1);

                            saleMaster.setDate(date);
                            saleMaster.setStoreDetails(storeDetails);
                            saleMaster.setCounter(counter);
                            saleMaster.setStatus("0");
                            saleMaster.setCustomerMaster(customerMaster);

                            saleMasterQuery.insertIntoSaleMaster(saleMaster);
                        }
                        else
                            saleMaster.setId(Integer.parseInt(billId.getText()));

                        SaleDetails saleDetails = new SaleDetails();
                        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

                        saleDetails.setSaleMaster(saleMaster);
                        saleDetails.setItemMaster(itemMaster);

                        List<SaleDetails> saleDetailsList = saleDetailsQuery.checkItem(saleDetails);
                        if(!(saleDetailsList.isEmpty()))
                        {
                            for(SaleDetails sd: saleDetailsList)
                            {
                                saleDetails.setId(sd.getId());
                                saleDetails.setQuantity(sd.getQuantity().add(new BigDecimal(soldQuantity)));
                                saleDetails.setTotal(sd.getTotal().add(new BigDecimal(total)));
                            }
                            saleDetailsQuery.updateSaleDetails(saleDetails);
                        }
                        else
                        {
                            saleDetails.setQuantity(new BigDecimal(soldQuantity));
                            saleDetails.setUnitPrice(new BigDecimal(unitPrice));
                            saleDetails.setTotal(new BigDecimal(total));
                            saleDetails.setGstPercent(new BigDecimal(gstPercent));
                            saleDetails.setSellingPrice(new BigDecimal(sellingPrice));
                            saleDetailsQuery.insertIntoSaleDetails(saleDetails);
                        }

                        ItemAvailability itemAvailability = new ItemAvailability();
                        ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();

                        itemAvailability.setItemMaster(itemMaster);
                        itemAvailability.setAvailability(new BigDecimal(availability).subtract(new BigDecimal(soldQuantity)));

                        List<ItemAvailability> itemAvailabilityList = itemAvailabilityQuery.checkItem(itemAvailability);
                        for(ItemAvailability ia: itemAvailabilityList)
                            itemAvailability.setId(ia.getId());

                        itemAvailabilityQuery.updateItemAvailability(itemAvailability);
                        clear();
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter numeric value"), "Error Message", JOptionPane.ERROR_MESSAGE);
              
                }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to add"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remove() 
    {
        try
        {
            int detailsId = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
            int itemId = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
            float quantity = Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
            
            ItemMaster itemMaster = new ItemMaster();
            itemMaster.setId(itemId);
            
            ItemAvailability itemAvailability = new ItemAvailability();
            ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();
            
            itemAvailability.setItemMaster(itemMaster);
            
            List<ItemAvailability> endProductAvalabilityList = itemAvailabilityQuery.checkItem(itemAvailability);
            for(ItemAvailability ea: endProductAvalabilityList)
            {
                itemAvailability.setId(ea.getId());
                itemAvailability.setAvailability(ea.getAvailability());
            }
            
            itemAvailability.setAvailability(itemAvailability.getAvailability().add(new BigDecimal(quantity)));
            SaleDetails saleDetails = new SaleDetails();
            saleDetails.setId(detailsId);
            
            SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
            saleDetailsQuery.deleteSaleDetails(saleDetails);
            
            itemAvailabilityQuery.updateItemAvailability(itemAvailability);
            
            clear();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to remove"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clear()
    {
        ItemMaster endProduct = new ItemMaster();
        loadTable(endProduct);
        item.setText("");
        item.requestFocus();
        getTotal();
        getDetails();
        paymentMode.setSelectedIndex(0);
        jPanelDiscount.setVisible(false);
        discount.setText("0.00");
        jCheckBoxDiscount.setSelected(false);
        finalAmount.setText("0.00");
    }

    private void pay() 
    {
        try
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("No order placed"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String paymentMode = this.paymentMode.getSelectedItem().toString();

            SaleMaster saleMaster = new SaleMaster();
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
            
            CustomerMaster customerMaster = new CustomerMaster();
            
            customerMaster.setId(1);
            
            CustomerPartialPayment customerPartialPayment = new CustomerPartialPayment();
            customerPartialPayment.setPaymentMode(paymentMode);
            customerPartialPayment.setBank("N/A");
            customerPartialPayment.setChequeOrCardNumber("N/A");
            customerPartialPayment.setCustomerMaster(customerMaster);
            customerPartialPayment.setDate(this.date.getDate());
            customerPartialPayment.setStatus("1");
            customerPartialPayment.setPaidAmount(new BigDecimal(total.getText().trim()));
            
            CustomerPartialPaymentQuery customerPartialPaymentQuery = new CustomerPartialPaymentQuery();

            if(!(paymentMode.equalsIgnoreCase("cash")))
            {
                if(number.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/Card/Transaction Number"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    number.requestFocus();
                    return;
                }
                customerPartialPayment.setChequeOrCardNumber(number.getText().trim());
                if(paymentMode.equalsIgnoreCase("cheque"))
                {
                    Date saleDate = this.date.getDate();
                    Date chequeDate = this.chequeDate.getDate();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    String stringChequeDate = dateFormat.format(chequeDate);        
                    String stringPurchaseDate = dateFormat.format(saleDate);
                    
                    try
                    {
                        chequeDate = dateFormat.parse(stringChequeDate);
                        saleDate = dateFormat.parse(stringPurchaseDate);

                        if(chequeDate.compareTo(saleDate) < 0)
                        {
                            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Cheque Date can't be ahead of Sale Date"), "Error message", JOptionPane.ERROR_MESSAGE);
                            this.chequeDate.requestFocus();
                            return;
                        }
                        
                        customerPartialPayment.setChequeDate(chequeDate);
                        customerPartialPayment.setStatus("0");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                
                if(!(paymentMode.equalsIgnoreCase("paytm")))
                    customerPartialPayment.setBank(bank.getSelectedItem().toString());
            }
            
            if(paymentMode.equalsIgnoreCase("cheque"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Can't make full payment with Cheque!!!<br>Go for Partial Payment"), "Error message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            saleMaster.setBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setFinalBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setDiscount(new BigDecimal(0));
            
            if(jCheckBoxDiscount.isSelected())
            {
                if(discount.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if(Float.parseFloat(discount.getText().trim()) == 0)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if(Float.parseFloat(discount.getText().trim()) >  Float.parseFloat(total.getText().trim()))
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                saleMaster.setDiscount(new BigDecimal(discount.getText().trim()));
                saleMaster.setFinalBillAmount(new BigDecimal(finalAmount.getText().trim()));
                customerPartialPayment.setPaidAmount(new BigDecimal(finalAmount.getText().trim()));
            }
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of this Sale?"));
            if(confirm == JOptionPane.YES_OPTION)
            {
                saleMaster.setId(Integer.parseInt(billId.getText()));
                saleMaster.setCustomerMaster(customerMaster);
                saleMaster.setReference(reference.getText().trim());
                saleMaster.setStatus("1");
                if(gstTaken.isSelected())
                    saleMaster.setRemark("GST Taken");
                else
                    saleMaster.setRemark("GST Not Taken");
     
                saleMasterQuery.updateSaleMaster(saleMaster);
                
                customerPartialPaymentQuery.insertIntoCustomerPartialPayment(customerPartialPayment);
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Sale successful"));
                clear();
                if(gstTaken.isSelected())
                    printBill(saleMaster, true);
                else
                    printBill(saleMaster, false);
                
                gstTaken.setSelected(true);
            } 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Invalid Entry!!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    private void checkDispose() 
    {
        int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of closing this form?"));
        if(confirm == JOptionPane.YES_OPTION)
            dispose();
    }
    
    private void printBill(SaleMaster saleMaster, boolean flag) 
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String joinQuery =  "SELECT\n" +
                        "     counter.`Id` AS counter_Id,\n" +
                        "     counter.`name` AS counter_name,\n" +
                        "     counter.`status` AS counter_status,\n" +
                        "     item_master.`Id` AS item_master_Id,\n" +
                        "     item_master.`name` AS item_master_name,\n" +
                        "     item_master.`unitPrice` AS item_master_unitPrice,\n" +
                        "     item_master.`gstPercent` AS item_master_gstPercent,\n" +
                        "     item_master.`sellingPrice` AS item_master_sellingPrice,\n" +
                        "     item_master.`sellingGstPercent` AS item_master_sellingGstPercent,\n" +
                        "     item_master.`finalSellingPrice` AS item_master_finalSellingPrice,\n" +
                        "     item_master.`hsnCode` AS hsnCode,\n" +
                        "     sale_details.`Id` AS sale_details_Id,\n" +
                        "     sale_details.`saleId` AS sale_details_saleId,\n" +
                        "     sale_details.`itemId` AS sale_details_itemId,\n" +
                        "     sale_details.`unitPrice` AS sale_details_unitPrice,\n" +
                        "     sale_details.`gstPercent` AS sale_details_gstPercent,\n" +
                        "     sale_details.`sellingPrice` AS sale_details_sellingPrice,\n" +
                        "     sale_details.`quantity` AS sale_details_quantity,\n" +
                        "     sale_details.`total` AS sale_details_total,\n" +
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
                        "     store_details.`photo` AS store_details_photo\n" +
                        "FROM\n" +
                        "     `item_master` item_master INNER JOIN `sale_details` sale_details ON item_master.`Id` = sale_details.`itemId`\n" +
                        "     INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n" +
                        "     INNER JOIN `counter` counter ON sale_master.`counterId` = counter.`Id`\n" +
                        "     INNER JOIN `store_details` store_details ON sale_master.`storeId` = store_details.`Id` \n" +
                        "WHERE sale_master.id = " + saleMaster.getId();
        try
        {
            connection = MyConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(joinQuery);
            
            String reportSource = "";
            
            if(flag)
               reportSource = ReadFile.getPath() + "Reports\\GstSaleDetails.jrxml"; 
            else
                reportSource = ReadFile.getPath() + "Reports\\NonGstSaleDetails.jrxml"; 
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, resultSetDataSource);
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

    private void changeQuantity() 
    {
        try
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.000");
            int detailsId = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
            int itemId = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
            float quantity = Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
            float unitPrice = Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
            float sellingPrice = Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
            String itemName = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();
            float newQuantity = 0;
            
            JFrame frame = new JFrame("Input");
            
            ItemMaster itemMaster = new ItemMaster();
            itemMaster.setId(itemId);
            
            ItemAvailability eAvailability = new ItemAvailability();
            ItemAvailabilityQuery endProductAvailabilityQuery = new ItemAvailabilityQuery();
            
            eAvailability.setItemMaster(itemMaster);
            
            List<ItemAvailability> endProductAvalabilityList = endProductAvailabilityQuery.checkItem(eAvailability);
            for(ItemAvailability ea: endProductAvalabilityList)
            {
                eAvailability.setId(ea.getId());
                eAvailability.setAvailability(ea.getAvailability());
            }
            
            
            eAvailability.setAvailability(eAvailability.getAvailability().add(new BigDecimal(quantity)));
            
            newQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(eAvailability.getAvailability()) + "</FONT></HTML>" ));
            int compare = new BigDecimal(newQuantity).compareTo(eAvailability.getAvailability());
            
          /*  if(compare == 1)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Entered Quantity is greater than Available Quantity"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            } */
            if(newQuantity == 0)
            {
               JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
               return; 
            }
            
            endProductAvailabilityQuery.updateItemAvailability(eAvailability);
            eAvailability.setAvailability(eAvailability.getAvailability().subtract(new BigDecimal(newQuantity)));
            
            endProductAvailabilityQuery.updateItemAvailability(eAvailability);
            float total = newQuantity * sellingPrice;
            
            
            SaleDetails saleDetails = new SaleDetails();
            saleDetails.setId(detailsId);
            saleDetails.setQuantity(new BigDecimal(newQuantity));
            saleDetails.setTotal(new BigDecimal(total));
            
            SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
            saleDetailsQuery.updateSaleDetails(saleDetails);   
            
            clear();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to change the quantity of"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void getFinalAmountPaid(String discount) 
    {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        finalAmount.setText(decimalFormat.format(Float.parseFloat(total.getText()) - Float.parseFloat(discount)));
    }

    private void getGstTaken() 
    {
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
        
        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();
        
        SaleMaster saleMaster = new SaleMaster();
        
        int i = 0;
        
        while(i < jTable2.getRowCount())
        {
            saleMaster.setId(Integer.parseInt(billId.getText().trim()));
            int itemId = Integer.parseInt(jTable2.getValueAt(i, 1).toString());

            itemMaster.setId(itemId);

            saleDetails.setSaleMaster(saleMaster);
            saleDetails.setItemMaster(itemMaster);

            List<SaleDetails> list = saleDetailsQuery.checkItem(saleDetails);

            for(SaleDetails sd: list)
            {
                List<ItemMaster> itemList = itemQuery.getItemById(itemMaster);
                for(ItemMaster im: itemList)
                {
                    itemMaster.setSellingPrice(im.getSellingPrice());
                    itemMaster.setSellingGstPercent(im.getSellingGstPercent());
                    itemMaster.setFinalSellingPrice(im.getFinalSellingPrice());
                }
                saleDetails.setId(sd.getId());
                saleDetails.setGstPercent(itemMaster.getSellingGstPercent());
                saleDetails.setSellingPrice(itemMaster.getFinalSellingPrice());
                saleDetails.setTotal(sd.getQuantity().multiply(saleDetails.getSellingPrice()));
                
                saleDetailsQuery.updateGst(saleDetails);
            }
            i++;
        }
        getDetails();    
    }

    private void getGstNotTaken() 
    {
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
        
        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();
        
        SaleMaster saleMaster = new SaleMaster();
        
        int i = 0;
        
        while(i < jTable2.getRowCount())
        {
            saleMaster.setId(Integer.parseInt(billId.getText().trim()));
            int itemId = Integer.parseInt(jTable2.getValueAt(i, 1).toString());

            itemMaster.setId(itemId);

            saleDetails.setSaleMaster(saleMaster);
            saleDetails.setItemMaster(itemMaster);

            List<SaleDetails> list = saleDetailsQuery.checkItem(saleDetails);

            for(SaleDetails sd: list)
            {
                saleDetails.setId(sd.getId());
                saleDetails.setGstPercent(new BigDecimal(0));
                saleDetails.setSellingPrice(sd.getUnitPrice());
                saleDetails.setTotal(sd.getQuantity().multiply(saleDetails.getSellingPrice()));
                
                saleDetailsQuery.updateGst(saleDetails);
            }
            i++;
        }
        getDetails();
    }

    private void partialPayment() 
    {
        try
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("No order placed"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String paymentMode = this.paymentMode.getSelectedItem().toString();

            SaleMaster saleMaster = new SaleMaster();
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
            
            CustomerMaster customerMaster = new CustomerMaster();
            
            customerMaster.setId(1);
            
            CustomerPartialPayment customerPartialPayment = new CustomerPartialPayment();
            customerPartialPayment.setPaymentMode(paymentMode);
            customerPartialPayment.setBank("N/A");
            customerPartialPayment.setChequeOrCardNumber("N/A");
            customerPartialPayment.setCustomerMaster(customerMaster);
            customerPartialPayment.setDate(this.date.getDate());
            customerPartialPayment.setStatus("1");
            customerPartialPayment.setPaidAmount(new BigDecimal(total.getText().trim()));
            
            CustomerPartialPaymentQuery customerPartialPaymentQuery = new CustomerPartialPaymentQuery();

            if(!(paymentMode.equalsIgnoreCase("cash")))
            {
                if(number.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/Card/Transaction Number"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    number.requestFocus();
                    return;
                }
                customerPartialPayment.setChequeOrCardNumber(number.getText().trim());
                if(paymentMode.equalsIgnoreCase("cheque"))
                {
                    Date saleDate = this.date.getDate();
                    Date chequeDate = this.chequeDate.getDate();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    String stringChequeDate = dateFormat.format(chequeDate);        
                    String stringPurchaseDate = dateFormat.format(saleDate);
                    
                    try
                    {
                        chequeDate = dateFormat.parse(stringChequeDate);
                        saleDate = dateFormat.parse(stringPurchaseDate);

                        if(chequeDate.compareTo(saleDate) < 0)
                        {
                            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Cheque Date can't be ahead of Sale Date"), "Error message", JOptionPane.ERROR_MESSAGE);
                            this.chequeDate.requestFocus();
                            return;
                        }
                        
                        customerPartialPayment.setChequeDate(chequeDate);
                        customerPartialPayment.setStatus("0");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                
                if(!(paymentMode.equalsIgnoreCase("paytm")))
                    customerPartialPayment.setBank(bank.getSelectedItem().toString());
            }
            
            saleMaster.setBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setFinalBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setDiscount(new BigDecimal(0));
            
            if(jCheckBoxDiscount.isSelected())
            {
                if(discount.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if(Float.parseFloat(discount.getText().trim()) == 0)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if(Float.parseFloat(discount.getText().trim()) >  Float.parseFloat(total.getText().trim()))
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                saleMaster.setDiscount(new BigDecimal(discount.getText().trim()));
                saleMaster.setFinalBillAmount(new BigDecimal(finalAmount.getText().trim()));
                customerPartialPayment.setPaidAmount(new BigDecimal(finalAmount.getText().trim()));
            }
            
            saleMaster.setId(Integer.parseInt(billId.getText()));
            saleMaster.setCustomerMaster(customerMaster);
            saleMaster.setReference(reference.getText().trim());
            saleMaster.setStatus("1");
            if(gstTaken.isSelected())
                saleMaster.setRemark("GST Taken");
            else
                saleMaster.setRemark("GST Not Taken");
            
            dispose();
            
            CustomerPartialPaymentView storeDetails = new CustomerPartialPaymentView(jDesktopPane, saleMaster, customerPartialPayment, counter.getSelectedItem().toString());
            storeDetails.setTitle("Customer Partial Payment");
            jDesktopPane.add(storeDetails);
            SetDimension setDimension = new SetDimension();
            setDimension.setInternalFrameLocation(jDesktopPane, storeDetails);
            storeDetails.setVisible(true);
        }
        catch(Exception e)
        {
            
        }
    }
}
