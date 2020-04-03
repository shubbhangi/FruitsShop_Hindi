/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import com.grocery.bean.Counter;
import com.grocery.bean.CustomerDetails;
import com.grocery.bean.CustomerPartialPayment;
import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.bean.SaleDetails;
import com.grocery.bean.SaleMaster;
import com.grocery.bean.StoreDetails;
import com.grocery.dimension.SetDimension;
import com.grocery.query.CounterQuery;
import com.grocery.query.WarehoseDetailsQuery123;
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
    private int currRow_g = 0;
    private int currRow_s = 0;
    private double sumOfGstAmount = 0.0;
    private double sumOfIGstAmount = 0.0;
    private double sumOfSellingPrice = 0.0;
    private boolean warehouseFlag;
    private boolean newWarehouseFlag;

    public SalesPageView(JDesktopPane jDesktopPane) {
        initComponents();
        salesTabel.removeAll();
        loadWarehouswe();
        jLabel30.setVisible(false);
        billId.setVisible(false);
        
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        
        
        PaymentDet.setVisible(false);
        jLabel18.setVisible(false);
        counter.setVisible(false);
        save.setVisible(false);

        this.jDesktopPane = jDesktopPane;
        gstTaken.setSelected(true);
        stockTable.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
        stockTable.getColumnModel().getColumn(0).setMinWidth(0);
        stockTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        
        stockTable.getColumnModel().getColumn(7).setMinWidth(0);
        stockTable.getColumnModel().getColumn(7).setMaxWidth(0);
       
        salesTabel.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
        salesTabel.getColumnModel().getColumn(0).setMinWidth(0);
        salesTabel.getColumnModel().getColumn(0).setMaxWidth(0);

        salesTabel.getColumnModel().getColumn(1).setMinWidth(0);
        salesTabel.getColumnModel().getColumn(1).setMaxWidth(0);

        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEditable(false);

        editor = (JTextFieldDateEditor) chequeDate.getDateEditor();
        editor.setEditable(false);
        jPanelNumber.setVisible(false);

        date.setDate(currentDate);
        chequeDate.setDate(currentDate);
        item.requestFocus();
        jPanelDiscount.setVisible(false);
        totalGstAmount.setText("0.00");
        finalAmountSale.setText("0.00");

        ItemMaster itemMaster = new ItemMaster();
        loadTable(itemMaster);
       // loadCounter();
        DefaultTableModel defaultTableModel = (DefaultTableModel) salesTabel.getModel();
        defaultTableModel.setRowCount(0);
        salesTabel.setModel(defaultTableModel);
        getTotal();
    }
  //public SalesPageView(JDesktopPane jDesktopPane, SaleMaster saleMaster, CustomerPartialPaymentView customerPartialPayment, String counter) {
  public SalesPageView(JDesktopPane jDesktopPane, SaleMaster saleMaster, CustomerPartialPayment customerPartialPayment, String counter) {
      
  //  public SalesPageView(JDesktopPane jDesktopPane, SaleMaster saleMaster, CustomerPartialPayment customerPartialPayment, String counter) {
        initComponents();

         loadWarehouswe();
        PaymentDet.setVisible(false);

        reference.setText(saleMaster.getReference());
        this.jDesktopPane = jDesktopPane;
        gstTaken.setSelected(true);
        stockTable.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
        stockTable.getColumnModel().getColumn(0).setMinWidth(0);
        stockTable.getColumnModel().getColumn(0).setMaxWidth(0);

        salesTabel.getTableHeader().setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
        salesTabel.getColumnModel().getColumn(0).setMinWidth(0);
        salesTabel.getColumnModel().getColumn(0).setMaxWidth(0);

        salesTabel.getColumnModel().getColumn(1).setMinWidth(0);
        salesTabel.getColumnModel().getColumn(1).setMaxWidth(0);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEditable(false);

        editor = (JTextFieldDateEditor) chequeDate.getDateEditor();
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

        if (!(saleMaster.getDiscount().compareTo(new BigDecimal(0)) == 0)) {
            System.out.println("true");
            jCheckBoxDiscount.setSelected(true);
            jPanelDiscount.setVisible(true);
            discount.setText(String.valueOf(saleMaster.getDiscount()));
            finalAmount.setText(String.valueOf(saleMaster.getFinalBillAmount()));
        }

        paymentMode.setSelectedItem(customerPartialPayment.getPaymentMode());

        if (!(customerPartialPayment.getBank().equalsIgnoreCase("n/a"))) {
            bank.setSelectedItem(customerPartialPayment.getBank());
        }

        if (customerPartialPayment.getChequeDate() != null) {
            chequeDate.setVisible(true);
            chequeDate.setDate(customerPartialPayment.getChequeDate());
        }

        if (saleMaster.getRemark().equalsIgnoreCase("gst")) {
            gstTaken.setSelected(true);
        } else if (saleMaster.getRemark().equalsIgnoreCase("igst")) {
            gstTaken.setSelected(true);
        } else {
            gstNotTaken.setSelected(true);
        }

        if (!(customerPartialPayment.getChequeOrCardNumber().equalsIgnoreCase("n/a"))) {
            number.setText(customerPartialPayment.getChequeOrCardNumber());
        }

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
        jScrollPane2 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        add = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        salesTabel = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        PaymentDet = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();
        fullPaymentOld = new javax.swing.JButton();
        partialPayment = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        paymentMode = new javax.swing.JComboBox<String>();
        jPanelNumber = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        chequeDate = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        bank = new javax.swing.JComboBox<String>();
        jCheckBoxDiscount = new javax.swing.JCheckBox();
        jPanelDiscount = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        finalAmount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        finalAmountSale = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        totalGstAmount = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        gstTaken = new javax.swing.JRadioButton();
        igstTaken = new javax.swing.JRadioButton();
        gstNotTaken = new javax.swing.JRadioButton();
        gst = new javax.swing.JComboBox<String>();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        item = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        change = new javax.swing.JButton();
        fullPayment = new javax.swing.JButton();
        save = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        billId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        counter = new javax.swing.JComboBox<String>();
        jLabel28 = new javax.swing.JLabel();
        warehouseName = new javax.swing.JComboBox<String>();
        add1 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();

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
        setMaximizable(true);
        setMinimumSize(new java.awt.Dimension(57, 34));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(895, 894));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(57, 34));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 805));

        stockTable.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "क्रमांक", "वस्तु का नाम", "बारकोड", "उपलब्धता", "यूनिट मूल्य", "जीएसटी %", " विक्रय मूल्य", "जीएसटी  प्रकार", "निर्माण तिथि", "समाप्ति तिथि"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stockTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(stockTable);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        add.setText("जोड़ना");
        add.setToolTipText("Add");
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

        salesTabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        salesTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "क्रमांक", "आइटम नंबर", "वस्तु का नाम", "बारकोड", "यूनिट मूल्य", "मात्रा", "जीएसटी %", "जीएसटी राशि  	", " विक्रय मूल्य	", " कुल", "जीएसटी  प्रकार", "निर्माण तिथि", "समाप्ति तिथि"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salesTabelKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(salesTabel);

        jLabel24.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("आइटम उपलब्धता:");
        jLabel24.setToolTipText("Item Availability:");

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

        fullPaymentOld.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        fullPaymentOld.setText("Full Payment");
        fullPaymentOld.setMnemonic(KeyEvent.VK_F);
        fullPaymentOld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaymentOldActionPerformed(evt);
            }
        });
        fullPaymentOld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fullPaymentOldKeyPressed(evt);
            }
        });

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

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Payment Mode:");

        paymentMode.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        paymentMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Card", "Cheque", "Paytm" }));
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
        bank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A.P. Mahesh Co-Op Urban Bank Ltd", "Abhyudaya Co-op Bank Ltd", "Abu Dhabi Commercial Bank", "Ahmedabad Mercantile Co-operative Bank Ltd", "Allahabad Bank", "Andhra Bank", "Apna Sahakari Bank Ltd.", "Axis Bank", "Bank Of America", "Bank Of Bahrain And Kuwait", "Bank Of Baroda", "Bank Of Ceylon", "Bank Of India", "Bank Of Maharashtra", "Bank Of Nova Scotia", "Bank Of Rajasthan Ltd", "Bank Of Tokyo-Mitsubishi UFJ Ltd", "Barclays Bank PLC", "Bassein Catholic Co-Op Bank Ltd", "Bharat Co-operative Bank (Mumbai) Ltd", "Bharat Overseas Bank", "BNP Paribas", "Calyon Bank", "Canara Bank", "Catholic Syrian Bank Ltd", "Central Bank Of India", "Chinatrust Commercial Bank", "Citibank NA", "Citizencredit Co-operative Bank Ltd", "City Union Bank Ltd", "Corporation Bank", "Cosmos Co-operative Bank Ltd.", "Credit Agricole Corp N Invsmnt Bank", "DBS Bank Ltd", "Dena Bank", "Deutsche Bank AG", "Development Credit Bank Limited", "Dhanalakshmi Bank Ltd", "DICGC", "Dombivli Nagari Sahakari Bank Limited", "Federal Bank Ltd", "Firstrand Bank Limited", "Greater Bombay Co-op. Bank Ltd", "HDFC Bank Ltd", "HSBC", "ICICI Bank Ltd", "IDBI Bank Ltd", "Indian Bank", "Indian Overseas Bank", "Indusind Bank Ltd", "ING Vysya Bank Ltd", "Jammu And Kashmir Bank Ltd", "Janakalyan Sahakari Bank Ltd", "Janata Sahakari Bank Ltd (Pune)", "JP Morgan Chase Bank NA", "Kallappanna Awade Ich Janata S Bank", "Kalupur Commercial Co. Op. Bank Ltd.", "Kalyan Janata Sahakari Bank Ltd.", "Kapole Co Op Bank", "Karad Urban Co-Op Bank Ltd", "Karnataka Bank Ltd", "Karnataka State Apex  Coop. Bank Ltd.", "Karur Vysya Bank", "Kotak Mahindra Bank", "Lakshmi Vilas Bank Ltd", "Mahanagar Co-op Bank Ltd", "Maharashtra State Co Operative Bank", "Mashreq Bank PSC", "Mehsana Urban Cooperative Bank Ltd", "Mizuho Corporate Bank Ltd", "Nagpur Nagrik Sahakari Bank Ltd", "Nainital Bank Limited", "Nasik Merchants Co-Op Bank Ltd", "New India Co-operative Bank Ltd", "Nkgsb Co-op Bank Ltd", "Nutan Nagarik Sahakari Bank Ltd", "Oman International Bank Saog", "Oriental Bank Of Commerce", "Parsik Janata Sahakari Bank Ltd", "PMC Bank", "Punjab And Maharashtra Co-op Bank Ltd", "Punjab And Sind Bank", "Punjab National Bank", "Rajkot Nagarik Sahakari Bank Ltd", "Ratnakar Bank Ltd", "Reserve Bank Of India", "Saraswat Co-operative Bank Ltd", "Shamrao Vithal Co-operative Bank Limited", "Shinhan Bank", "Societe Generale", "South Indian Bank", "Standard Chartered Bank", "State Bank Of Bikaner And Jaipur", "State Bank Of Hyderabad", "State Bank Of India", "State Bank Of Indore", "State Bank Of Mauritius Ltd", "State Bank Of Mysore", "State Bank Of Patiala", "State Bank Of Travancore", "Surat Peoples Co-Op Bank Ltd", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd", "Tamilnadu State Apex Cooperative Bank Limited", "Thane Janata Sahakari Bank Ltd", "The Royal Bank Of Scotland NV", "UBS AG", "UCO Bank", "Union Bank Of India", "United Bank Of India", "Vijaya Bank", "West Bengal State Cooperative Bank Ltd", "Yes Bank Ltd" }));

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
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Payment Details:");

        jLabel32.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Final Amount");

        jLabel33.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Total GST/IGST Amunt");

        totalGstAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalGstAmountFocusGained(evt);
            }
        });
        totalGstAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGstAmountActionPerformed(evt);
            }
        });
        totalGstAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalGstAmountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalGstAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalAmountSale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(finalAmountSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalGstAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        buttonGroup1.add(gstTaken);
        gstTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gstTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstTaken.setText("GST");
        gstTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstTakenActionPerformed(evt);
            }
        });

        buttonGroup1.add(igstTaken);
        igstTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        igstTaken.setForeground(new java.awt.Color(255, 0, 0));
        igstTaken.setText("IGST");
        igstTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igstTakenActionPerformed(evt);
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

        gst.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "5", "12", "18", "28" }));
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gstTaken)
                .addGap(4, 4, 4)
                .addComponent(igstTaken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gstNotTaken, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gstTaken)
                        .addComponent(gstNotTaken)
                        .addComponent(igstTaken)
                        .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PaymentDetLayout = new javax.swing.GroupLayout(PaymentDet);
        PaymentDet.setLayout(PaymentDetLayout);
        PaymentDetLayout.setHorizontalGroup(
            PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentDetLayout.createSequentialGroup()
                .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentDetLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullPaymentOld, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(partialPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(186, 186, 186))
                    .addComponent(cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentDetLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jCheckBoxDiscount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaymentDetLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(PaymentDetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PaymentDetLayout.setVerticalGroup(
            PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentDetLayout.createSequentialGroup()
                .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaymentDetLayout.createSequentialGroup()
                        .addComponent(fullPaymentOld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(partialPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel))
                    .addGroup(PaymentDetLayout.createSequentialGroup()
                        .addGroup(PaymentDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxDiscount)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("नाम से खोजें:");
        jLabel17.setToolTipText("Search By Name:");

        item.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
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

        jLabel31.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("कुल\t");
        jLabel31.setToolTipText("Total:");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 153));
        total.setFont(new java.awt.Font("Arial Unicode MS", 1, 10)); // NOI18N
        total.setForeground(new java.awt.Color(255, 0, 0));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalFocusGained(evt);
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

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove.png"))); // NOI18N
        remove.setText(" हटाना");
        remove.setToolTipText("Remove");
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

        change.setBackground(new java.awt.Color(255, 255, 255));
        change.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/change.png"))); // NOI18N
        change.setText("मात्रा बदलें");
        change.setToolTipText("Change Quantity");
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

        fullPayment.setBackground(new java.awt.Color(255, 255, 255));
        fullPayment.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        fullPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print.png"))); // NOI18N
        fullPayment.setText(" छाप");
        fullPayment.setToolTipText("Print");
        fullPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaymentActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        save.setText("सहेजें");
        save.setToolTipText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel1.setBackground(new java.awt.Color(255, 255, 255));
        cancel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        cancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        cancel1.setText(" रद्द करना");
        cancel1.setToolTipText("Cancel");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("बिल क्रमांक:");
        jLabel30.setToolTipText("Bill Id:");

        billId.setEditable(false);
        billId.setBackground(new java.awt.Color(255, 255, 153));
        billId.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        billId.setForeground(new java.awt.Color(255, 0, 0));
        billId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billIdActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("काउंटर:");
        jLabel18.setToolTipText("Counter:");

        counter.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        counter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counterActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("ग्राहक का नाम:");
        jLabel28.setToolTipText("Customer Name:");

        warehouseName.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        warehouseName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "--Add Customer--" }));
        warehouseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseNameActionPerformed(evt);
            }
        });

        add1.setBackground(new java.awt.Color(0, 204, 51));
        add1.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setText("जोड़ना");
        add1.setToolTipText("Add");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("बिक्री  भण्डार");
        jLabel1.setToolTipText("Sale Stock");

        date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText(" दिनांक :");
        jLabel29.setToolTipText("Date");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(481, 481, 481)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(436, 436, 436)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel30)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(396, 396, 396)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 213, Short.MAX_VALUE))
                                .addComponent(PaymentDet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap()))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(fullPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(warehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(1, 1, 1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(billId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(fullPayment)
                    .addComponent(cancel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(PaymentDet, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1361, 615);
    }// </editor-fold>//GEN-END:initComponents

    private void itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyReleased
        ItemMaster itemMaster = new ItemMaster();
        if (!(item.getText().trim().isEmpty())) {
           // itemMaster.setName(item.getText().trim());
            itemMaster.setBarCode(item.getText().trim());
        }
        loadTable(itemMaster);
    }//GEN-LAST:event_itemKeyReleased

    private void itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':')) {
            evt.consume();
        }
    }//GEN-LAST:event_itemKeyTyped

    private void counterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterActionPerformed
        if (counter.getItemCount() > 0) {
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
        if (paymentMode.getItemCount() > 0) {
            if (paymentMode.getSelectedItem().toString().equalsIgnoreCase("cash")) {
                jPanelNumber.setVisible(false);
            } else if (paymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque")) {
                jPanelNumber.setVisible(true);
                chequeDate.setVisible(true);
                jLabel25.setVisible(true);
                bank.setVisible(true);
            } else if (paymentMode.getSelectedItem().toString().equalsIgnoreCase("card")) {
                jPanelNumber.setVisible(true);
                jLabel25.setVisible(true);
                bank.setVisible(true);
            } else {
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
        if (!(Character.isDigit(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_numberKeyTyped

    private void fullPaymentOldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaymentOldActionPerformed
        pay();
    }//GEN-LAST:event_fullPaymentOldActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItem();
        }
    }//GEN-LAST:event_addKeyPressed

    private void removeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            remove();
        }
    }//GEN-LAST:event_removeKeyPressed

    private void fullPaymentOldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullPaymentOldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pay();
        }
    }//GEN-LAST:event_fullPaymentOldKeyPressed

    private void itemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyPressed

    }//GEN-LAST:event_itemKeyPressed

    private void stockTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItem();
        }
    }//GEN-LAST:event_stockTableKeyPressed

    private void salesTabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salesTabelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            remove();
        }
    }//GEN-LAST:event_salesTabelKeyPressed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        changeQuantity();
    }//GEN-LAST:event_changeActionPerformed

    private void changeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            changeQuantity();
        }
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkDispose();
        }
    }//GEN-LAST:event_cancelKeyPressed

    private void jCheckBoxDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDiscountActionPerformed
        discount.setText("0.00");
        finalAmount.setText("0.00");
        if (jCheckBoxDiscount.isSelected()) {
            jPanelDiscount.setVisible(true);
        } else {
            jPanelDiscount.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxDiscountActionPerformed

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        if (!(discount.getText().trim().isEmpty())) {
            getFinalAmountPaid(discount.getText());
        } else {
            finalAmount.setText(total.getText());
        }
    }//GEN-LAST:event_discountKeyReleased

    private void discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusGained
        discount.selectAll();
    }//GEN-LAST:event_discountFocusGained

    private void gstTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstTakenActionPerformed
        if (salesTabel.getRowCount() > 0) {
            getGstTaken();
        }
        gst.setVisible(true);
        gstTaken.setSelected(true);
        igstTaken.setSelected(false);
        gstNotTaken.setSelected(false);
    }//GEN-LAST:event_gstTakenActionPerformed

    private void gstNotTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstNotTakenActionPerformed
        if (salesTabel.getRowCount() > 0) {
            getGstNotTaken();
        }

        gst.setVisible(false);
        gstTaken.setSelected(false);
        igstTaken.setSelected(false);
        gstNotTaken.setSelected(true);

    }//GEN-LAST:event_gstNotTakenActionPerformed

    private void referenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_referenceKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || c == '.' || c == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_referenceKeyTyped

    private void referenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusGained
        reference.selectAll();
    }//GEN-LAST:event_referenceFocusGained

    private void referenceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusLost
        if (reference.getText().trim().isEmpty()) {
            reference.setText("N/A");
        }
    }//GEN-LAST:event_referenceFocusLost

    private void billIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billIdActionPerformed

    private void finalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalAmountActionPerformed

    private void fullPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaymentActionPerformed
       Payment payment = new Payment();
       payment.setVisible(true);
        pay();
    }//GEN-LAST:event_fullPaymentActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       Payment payment = new Payment();
       payment.setVisible(true); 
        save();
    }//GEN-LAST:event_saveActionPerformed

    private void igstTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igstTakenActionPerformed
        if (salesTabel.getRowCount() > 0) {
            getIGstTaken();
        }
        gst.setVisible(true);
        gstTaken.setSelected(false);
        igstTaken.setSelected(true);
        gstNotTaken.setSelected(false);
    }//GEN-LAST:event_igstTakenActionPerformed

    private void gstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstActionPerformed
        if (!(total.getText().trim().isEmpty()) && gst.getSelectedItem() != "0") {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float sellingPrice = Float.parseFloat(this.total.getText());
            float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());

            float gstAmount = calculateGst(sellingPrice, gstPercent);
            this.totalGstAmount.setText(decimalFormat.format(gstAmount));

            finalAmount.setText(decimalFormat.format(sellingPrice + gstAmount));
      
            //  float igstPercent = Float.parseFloat(gst.getSelectedItem().toString());
        } else {
            finalAmount.setText("0.00");
        }

        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_gstActionPerformed

    private void totalGstAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalGstAmountActionPerformed

        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalGstAmountActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalActionPerformed

    private void totalGstAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalGstAmountFocusGained

        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalGstAmountFocusGained

    private void totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusGained

        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalFocusGained

    private void totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyReleased
        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalKeyReleased

    private void totalGstAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalGstAmountKeyReleased
        double gstAmount = Double.valueOf(totalGstAmount.getText());
        double totalAmount = Double.valueOf(total.getText());
        double finalTOtalAmount = 0;
        if (!(gstAmount <= 0) || !(totalAmount <= 0)) {
            finalTOtalAmount = totalAmount + gstAmount;
            finalAmountSale.setText(String.valueOf(finalTOtalAmount));
        } else {

            finalAmountSale.setText("0.00");
        }
    }//GEN-LAST:event_totalGstAmountKeyReleased

    private void warehouseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseNameActionPerformed
   /*     newWarehouswe.setText("");
        contact.setText("N/A");
        address.setText("N/A");
        gstNumber.setText("N/A");

        try
        {
            if(warehouseName.getItemCount() != 0)
            {
                if(warehouseName.getSelectedIndex() == 0)
                {
                    warehouseFlag = false;
                    jPanelNewWarehouswe.setVisible(false);
                }
                else
                if(warehouseName.getSelectedIndex() == 1)
                {
                    warehouseFlag = false;
                    jPanelNewWarehouswe.setVisible(true);
                }
                else
                {
                    warehouseFlag = true;
                    jPanelNewWarehouswe.setVisible(false);
                    loadWarehouswe();
                }
            }
        }
        catch(Exception e)
        {
        }
*/
    }//GEN-LAST:event_warehouseNameActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
    CustomerView customerView = new CustomerView();
   // WarehousweView customerView = new WarehousweView();
    customerView.setVisible(true);
//    addVendor();
    }//GEN-LAST:event_add1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaymentDet;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JComboBox<String> bank;
    private javax.swing.JTextField billId;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancel1;
    private javax.swing.JButton change;
    private com.toedter.calendar.JDateChooser chequeDate;
    private javax.swing.JComboBox<String> counter;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JFormattedTextField discount;
    private javax.swing.JTextField finalAmount;
    private javax.swing.JTextField finalAmountSale;
    private javax.swing.JButton fullPayment;
    private javax.swing.JButton fullPaymentOld;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JRadioButton gstNotTaken;
    private javax.swing.JRadioButton gstTaken;
    private javax.swing.JRadioButton igstTaken;
    private javax.swing.JTextField item;
    private javax.swing.JCheckBox jCheckBoxDiscount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelDiscount;
    private javax.swing.JPanel jPanelNumber;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField number;
    private java.awt.Panel panel1;
    private javax.swing.JButton partialPayment;
    private javax.swing.JComboBox<String> paymentMode;
    private javax.swing.JTextField reference;
    private javax.swing.JButton remove;
    private javax.swing.JTable salesTabel;
    private javax.swing.JButton save;
    private javax.swing.JTable stockTable;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalGstAmount;
    private javax.swing.JComboBox<String> warehouseName;
    // End of variables declaration//GEN-END:variables

    public void loadTable(ItemMaster itemMaster) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) stockTable.getModel();
        defaultTableModel.setRowCount(0);

        List<Object[]> list = new ArrayList<>();

        ItemAvailability itemAvailability = new ItemAvailability();
        ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();

        itemAvailability.setItemMaster(itemMaster);
        list = itemAvailabilityQuery.getAvailability(itemAvailability);

        for (Object[] object : list) {
            ItemAvailability ia = (ItemAvailability) object[0];

           // defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getHsnCode(), ia.getAvailability(), ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getGstPercent(), ia.getItemMaster().getFinalSellingPrice(), ia.getItemMaster().getIgstPercent()});
            //if(ia.getItemMaster().getGstType().equals("GST")){
               if(!(Double.valueOf(String.valueOf(ia.getAvailability()))<=0)) {
           // defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getHsnCode(), ia.getAvailability(), ia.getItemMaster().getUnitPrice(), ia.getItemMaster().getGstPercent(),ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getFinalSellingPrice(),ia.getItemMaster().getGstType(),ia.getItemMaster().getEfgDate(),ia.getItemMaster().getExpDate()});
            defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getBarCode(), ia.getAvailability(), ia.getItemMaster().getUnitPrice(), ia.getItemMaster().getGstPercent(),ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getFinalSellingPrice(),ia.getItemMaster().getEfgDate(),ia.getItemMaster().getExpDate()});
            }
            //}else{
           // defaultTableModel.addRow(new Object[]{ia.getItemMaster().getId(), ia.getItemMaster().getName(), ia.getItemMaster().getHsnCode(), ia.getAvailability(), ia.getItemMaster().getSellingPrice(), ia.getItemMaster().getIgstPercent(), ia.getItemMaster().getFinalSellingPrice(), ia.getItemMaster().getGstType()});
                
           // }
        }
        stockTable.setModel(defaultTableModel);
    }

    private void loadCounter() {
        CounterQuery counterQuery = new CounterQuery();

        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) counter.getModel();
        defaultComboBoxModel.removeAllElements();

        Counter counter = new Counter();

        List<Counter> list = counterQuery.getCounterDetails(counter);

        for (Counter c : list) {
            defaultComboBoxModel.addElement(c.getName());
        }

        this.counter.setModel(defaultComboBoxModel);
    }

    private void getDetails() {
        Counter counter = new Counter();
        CounterQuery counterQuery = new CounterQuery();

        counter.setName(this.counter.getSelectedItem().toString());
        List<Counter> list = counterQuery.getCounterDetails(counter);

        for (Counter c : list) {
            counter.setId(c.getId());
        }

        SaleMaster saleMaster = new SaleMaster();
        SaleMasterQuery saleMasterQuery = new SaleMasterQuery();

        saleMaster.setCounter(counter);

        List<SaleMaster> saleList = saleMasterQuery.getSaleDetails(saleMaster);

        for (SaleMaster sm : saleList) {
            saleMaster.setId(sm.getId());
        }

        if (saleList.isEmpty()) {
            billId.setText("");
        } else {
            billId.setText(String.valueOf(saleMaster.getId()));
        }

        getSaleDetails(saleMaster);
    }

    private void getSaleDetails(SaleMaster saleMaster) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) salesTabel.getModel();
        defaultTableModel.setRowCount(0);

        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

        saleDetails.setSaleMaster(saleMaster);

        List<Object[]> list = saleDetailsQuery.getSale(saleDetails);

        float gstPercentage = 0f;
        for (Object[] object : list) {
            SaleDetails sd = (SaleDetails) object[0];

            float unitPrce = Float.valueOf(sd.getUnitPrice().toString());
          // For Non-GST GST% and GST Amount will be zero
           if(sd.getGstType().equalsIgnoreCase("Non-GST")){
                gstPercentage = 0;
           }else{
               gstPercentage = Float.valueOf(sd.getGstPercent().toString());
           } 
          //  String gstType = sd.getGstType().toString();
            
          //  float igstPer = Float.valueOf(sd.getIgstPercent().toString());
            float quantity = Float.valueOf(sd.getQuantity().toString());
            float totalSellingPrice = (unitPrce * quantity);
            float gstAmount = (unitPrce * quantity) * gstPercentage / 100;
     //       float igstAmount = (unitPrce * quantity) * igstPer / 100;
            //defaultTableModel.addRow(new Object[]{sd.getId(), sd.getItemMaster().getId(), sd.getItemMaster().getName(), sd.getItemMaster().getHsnCode(), sd.getUnitPrice(), sd.getQuantity(), sd.getGstPercent(), gstAmount, totalSellingPrice, sd.getTotal(), sd.getIgstPercent(), igstAmount});
            //defaultTableModel.addRow(new Object[]{sd.getId(), sd.getItemMaster().getId(), sd.getItemMaster().getName(), sd.getItemMaster().getHsnCode(), sd.getUnitPrice(), sd.getQuantity(), sd.getGstPercent(), gstAmount, totalSellingPrice, sd.getTotal(), sd.getItemMaster().getGstType()});
            defaultTableModel.addRow(new Object[]{sd.getId(), sd.getItemMaster().getId(), sd.getItemMaster().getName(), sd.getItemMaster().getBarCode(), sd.getUnitPrice(), sd.getQuantity(), gstPercentage, gstAmount, totalSellingPrice, sd.getTotal(), sd.getGstType()});
        
        }
        
        salesTabel.setModel(defaultTableModel);

        getTotal();
    }

    private void getTotal() {
        
        int i = 0;
        float sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        while (i < salesTabel.getRowCount()) {
            sum = sum + Float.parseFloat(salesTabel.getValueAt(i, 9).toString());
            i++;
        }
        total.setText(decimalFormat.format(sum));
    }

    private void addItem() {
        float totalSellingPrice = 0f;
        float gstAmount = 0f;
        float igstAmount = 0f;
        float total = 0;
        float soldQuantity = 0f;
        int count = 0;
//        String mfg1 ;
//        String exp1;

        String gstTypeTable1 = stockTable.getValueAt(stockTable.getSelectedRow(), 7).toString();
       
//      String gstType1=null;
//       
//       for(int i=0; i<=jTable2.getRowCount()-1; i++){  
//            String gstTypeTable2 = jTable2.getValueAt(i, 10).toString();
//            if(!gstTypeTable2.equals("NON-GST")){
//                gstType1 = gstTypeTable2;
//            }
//       }
         
           
        if(salesTabel.getRowCount()<1){
            if(gstTypeTable1.equals("Non-GST")){
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select first Product GST or IGST"), "Error Message", JOptionPane.ERROR_MESSAGE);  
                return;
            }
        }
       
        try {
            String gstType = "";
            String itemName = stockTable.getValueAt(stockTable.getSelectedRow(), 1).toString();
            String hsnCode = stockTable.getValueAt(stockTable.getSelectedRow(), 2).toString();
            float availability = Float.parseFloat(stockTable.getValueAt(stockTable.getSelectedRow(), 3).toString());
            int itemId = Integer.parseInt(stockTable.getValueAt(stockTable.getSelectedRow(), 0).toString());
           // float unitPrice = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            float gstPercent = Float.parseFloat(stockTable.getValueAt(stockTable.getSelectedRow(), 5).toString());
           // float sellingPrice = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            float unitPrice = Float.parseFloat(stockTable.getValueAt(stockTable.getSelectedRow(), 6).toString());
            //float igstPercent = Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        //    String gstType = (stockTable.getValueAt(stockTable.getSelectedRow(), 7).toString());
            
            String mfg = stockTable.getValueAt(stockTable.getSelectedRow() ,8).toString();
            String exp = stockTable.getValueAt(stockTable.getSelectedRow() ,9).toString();
            DecimalFormat decimalFormat = new DecimalFormat("#0.000");
            JFrame frame = new JFrame("Input");
            
            try {
//              GSTTaxInput obj = new GSTTaxInput(decimalFormat.format(availability));
                
                soldQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(availability) + "</FONT></HTML>"));
                //soldQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(availability) + "</FONT></HTML>"));
               // String[] values = {"Non-GST", "GST", "IGST"};
               // Object selected = JOptionPane.showInputDialog(null, "Please select tax type:", "Radio", JOptionPane.DEFAULT_OPTION, null, values, "0");
//                if ( selected != null ){//null if the user cancels. 
//                    gstType = selected.toString();
//                }else{
//                    System.out.println("User cancelled");
//                }
                int gstCount = 0;
                int igstCount = 0;
                int nonGstCount = 0;
                String gstSalesTabel1 = "";
                String gstSalesTabel2 = "";   
                int i =0;
                int index = salesTabel.getRowCount();
                while(i < index) {
                    gstSalesTabel1 = salesTabel.getValueAt(i, 10).toString();
                    if(!gstSalesTabel1.equals(gstType)){
                       if((((gstCount==0 && igstCount==0) || !(nonGstCount>0)) || (gstCount == igstCount)) ){
                        JOptionPane.showMessageDialog(null, MessageFormat.getMessage("You can select only "+gstSalesTabel1+" Product"), "Error Message", JOptionPane.ERROR_MESSAGE);  
                        return;  
                        }
                    } 
                   i++;
                }
           
                if (soldQuantity > availability) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be greater than Available Quantity"), "Error Message", JOptionPane.ERROR_MESSAGE);
                } else if (soldQuantity == 0) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    totalSellingPrice = soldQuantity * unitPrice;
 
                    if (!gstType.equals("Non-GST") && gstPercent >= 0) {
                        gstAmount = (soldQuantity * unitPrice) * gstPercent / 100;
                    }
                    
           //       if(!counter ==0)
//                    } else if (igstPercent >= 0) {
//                        gstAmount = (soldQuantity * unitPrice) * igstPercent / 100;
//                    }
                    total = totalSellingPrice + gstAmount;

                    ItemMaster itemMaster = new ItemMaster();
                    itemMaster.setId(itemId);

                    SaleMaster saleMaster = new SaleMaster();
                    SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
                    StoreDetails storeDetails = new StoreDetails();
                    CustomerDetails customerDetails = new CustomerDetails();
                    Counter counter = new Counter();
                    CounterQuery counterQuery = new CounterQuery();

                    counter.setName(this.counter.getSelectedItem().toString());
                    List<Counter> list = counterQuery.getCounterDetails(counter);

                    System.out.println("listL::::>>"+list);
                    if(list.size()>0){
                        for (Counter c : list) {
                        counter.setId(c.getId());
                    } 
                    }
                    
                    if (billId.getText().isEmpty()) {
                        Date date = this.date.getDate();
                        storeDetails.setId(1);
                        customerDetails.setId(1);

                        saleMaster.setDate(date);
                        saleMaster.setStoreDetails(storeDetails);
                        saleMaster.setCounter(counter);
                        saleMaster.setStatus("0");
                        saleMaster.setCustomerDetails(customerDetails);

                        saleMasterQuery.insertIntoSaleMaster(saleMaster);
                    } else {
                        saleMaster.setId(Integer.parseInt(billId.getText()));
                    }

                    SaleDetails saleDetails = new SaleDetails();
                    SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

                    saleDetails.setSaleMaster(saleMaster);
                    saleDetails.setItemMaster(itemMaster);
                    
                   
                    List<SaleDetails> saleDetailsList = saleDetailsQuery.checkItem(saleDetails);
                    if (!(saleDetailsList.isEmpty())) {
                        for (SaleDetails sd : saleDetailsList) {
                            saleDetails.setId(sd.getId());
                            saleDetails.setQuantity(sd.getQuantity().add(new BigDecimal(soldQuantity)));
                            saleDetails.setTotal(sd.getTotal().add(new BigDecimal(total)));
                        }
                        saleDetailsQuery.updateSaleDetails(saleDetails);
                    } else {
                        saleDetails.setQuantity(new BigDecimal(soldQuantity));
                        saleDetails.setUnitPrice(new BigDecimal(unitPrice));
                        saleDetails.setTotal(new BigDecimal(total));
                        saleDetails.setGstPercent(new BigDecimal(gstPercent));
                        
                        saleDetails.setIgstPercent(new BigDecimal(gstAmount));
                        saleDetails.setGstType(gstType);
                        
                        saleDetails.setSellingPrice(new BigDecimal(totalSellingPrice));
                        
                        saleDetailsQuery.insertIntoSaleDetails(saleDetails);
                    }

                    ItemAvailability itemAvailability = new ItemAvailability();
                    ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();

                    itemAvailability.setItemMaster(itemMaster);
                    itemAvailability.setAvailability(new BigDecimal(availability).subtract(new BigDecimal(soldQuantity)));

                    List<ItemAvailability> itemAvailabilityList = itemAvailabilityQuery.checkItem(itemAvailability);
                    for (ItemAvailability ia : itemAvailabilityList) {
                        itemAvailability.setId(ia.getId());
                    }

                    itemAvailabilityQuery.updateItemAvailability(itemAvailability);
                    clear();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter numeric value"), "Error Message", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to add"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }

    }

   
        
    private void remove() {
        try {
            int detailsId = Integer.parseInt(salesTabel.getValueAt(salesTabel.getSelectedRow(), 0).toString());
            int itemId = Integer.parseInt(salesTabel.getValueAt(salesTabel.getSelectedRow(), 1).toString());
            float quantity = Float.parseFloat(salesTabel.getValueAt(salesTabel.getSelectedRow(), 5).toString());

            ItemMaster itemMaster = new ItemMaster();
            itemMaster.setId(itemId);

            ItemAvailability itemAvailability = new ItemAvailability();
            ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();

            itemAvailability.setItemMaster(itemMaster);

            List<ItemAvailability> endProductAvalabilityList = itemAvailabilityQuery.checkItem(itemAvailability);
            for (ItemAvailability ea : endProductAvalabilityList) {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to remove"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clear1(){
         loadWarehouswe(); 
//        newWarehouswe.setText(" ");
//        contact.setText(" ");
//        address.setText(" ");
//        gstNumber.setText(" ");
    }
    private void clear() {
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
        totalGstAmount.setText("0.00");
        
      
        
        
    }

    private double getTotalGSTAmount() {
        int index = salesTabel.getRowCount();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        sumOfGstAmount = 0;
        currRow_g = 0;
        while(currRow_g<index){
        sumOfGstAmount = sumOfGstAmount + Float.parseFloat(salesTabel.getValueAt(currRow_g, 7).toString());
        currRow_g++;
        }
        return sumOfGstAmount;
    }

    private double getTotalIGSTAmount() {
        int index = salesTabel.getRowCount();
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

    private double getTotalBillAmount() {
        int index = salesTabel.getRowCount();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        while (currRow_s < index) {
            sumOfSellingPrice = sumOfSellingPrice + Float.parseFloat(salesTabel.getValueAt(currRow_s, 8).toString());
            currRow_s++;
        }
        return sumOfSellingPrice;
    }

    private void pay() {
        try {
             newWarehouseFlag = false;
            if (salesTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("No order placed"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String paymentMode = this.paymentMode.getSelectedItem().toString();

            SaleMaster saleMaster = new SaleMaster();
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
            
            String warehouseName = this.warehouseName.getSelectedItem().toString();


            if(warehouseName.equalsIgnoreCase("--Select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select a Warehouswe"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.warehouseName.requestFocus();
                return;
            }
//            if(warehouseName.equalsIgnoreCase("--Add Warehouswe--"))
//            {
//                if(newWarehouswe.getText().trim().isEmpty())
//                {
//                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Warehouswe Name"), "Error message", JOptionPane.ERROR_MESSAGE);
//                    newWarehouswe.requestFocus();
//                    return;
//                }
//                warehouseName = newWarehouswe.getText().trim();
//                newWarehouseFlag = true;
//            }
           
            CustomerDetails customerDetails = new CustomerDetails();
            WarehoseDetailsQuery123 customerDetailsQuery = new WarehoseDetailsQuery123();

            customerDetails.setName(warehouseName);

            List<CustomerDetails> list = customerDetailsQuery.getCustomerDetails(customerDetails);

//            if(!(list.isEmpty()) && newWarehouseFlag == true)
//            {
//                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This Warehouswe already exists"), "Error message", JOptionPane.ERROR_MESSAGE);
//                newWarehouswe.requestFocus();
//                newWarehouseFlag = false;
//                return;
//            }
//            
//            
//                
//                customerDetails.setContact(contact.getText().trim());
//                customerDetails.setAddress(address.getText().trim());
//                customerDetails.setBalance(new BigDecimal(0.00));
//                customerDetails.setGstNumber(gstNumber.getText().trim());

                if(list.isEmpty())
                   // customerDetailsQuery.insertWarehouse(customerDetails);        
                    customerDetailsQuery.insertWarehouse(customerDetails);        
                else
                {
                    for(CustomerDetails cm: list)
                    {
                        customerDetails.setId(cm.getId());
                        customerDetails.setBalance(cm.getBalance().add(new BigDecimal(0.00)));
                    }
                    customerDetailsQuery.updateWarehouseBalance(customerDetails);
                }            
            
            CustomerPartialPayment customerPartialPayment = new CustomerPartialPayment();
            customerPartialPayment.setPaymentMode(paymentMode);
            customerPartialPayment.setBank("N/A");
            customerPartialPayment.setChequeOrCardNumber("N/A");
            customerPartialPayment.setCustomerDetails(customerDetails);
            customerPartialPayment.setDate(this.date.getDate());
            customerPartialPayment.setStatus("1");
            customerPartialPayment.setPaidAmount(new BigDecimal(total.getText().trim()));

            CustomerPartialPaymentQuery customerPartialPaymentQuery = new CustomerPartialPaymentQuery();

            if (!(paymentMode.equalsIgnoreCase("cash"))) {
                if (number.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/Card/Transaction Number"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    number.requestFocus();
                    return;
                }
                customerPartialPayment.setChequeOrCardNumber(number.getText().trim());
                if (paymentMode.equalsIgnoreCase("cheque")) {
                    Date saleDate = this.date.getDate();
                    Date chequeDate = this.chequeDate.getDate();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    String stringChequeDate = dateFormat.format(chequeDate);
                    String stringPurchaseDate = dateFormat.format(saleDate);

                    /*  try
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
                     */
                }

                if (!(paymentMode.equalsIgnoreCase("paytm"))) {
                    customerPartialPayment.setBank(bank.getSelectedItem().toString());
                }
            }

//            if(paymentMode.equalsIgnoreCase("cheque"))
//            {
//                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Can't make full payment with Cheque!!!<br>Go for Partial Payment"), "Error message", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            saleMaster.setGstAmount(BigDecimal.valueOf(getTotalGSTAmount()));
            //saleMaster.setIgstAmount(BigDecimal.valueOf(getTotalGSTAmount()));

            saleMaster.setBillAmount(new BigDecimal(getTotalBillAmount()));
            saleMaster.setFinalBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setDiscount(new BigDecimal(0));

            if (jCheckBoxDiscount.isSelected()) {
                if (discount.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) == 0) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) > Float.parseFloat(total.getText().trim())) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                saleMaster.setDiscount(new BigDecimal(discount.getText().trim()));
                saleMaster.setFinalBillAmount(new BigDecimal(finalAmount.getText().trim()));
                customerPartialPayment.setPaidAmount(new BigDecimal(finalAmount.getText().trim()));
            }
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of this Sale?"));
            if (confirm == JOptionPane.YES_OPTION) {
                saleMaster.setId(Integer.parseInt(billId.getText()));
                saleMaster.setCustomerDetails(customerDetails);
                saleMaster.setReference(reference.getText().trim());
                saleMaster.setStatus("1");
                String gstTypeTable2 = salesTabel.getValueAt(0, 10).toString();
                
                saleMaster.setRemark(gstTypeTable2); 
               
                saleMasterQuery.updateSaleMaster(saleMaster);

                customerPartialPaymentQuery.insertIntoCustomerPartialPayment(customerPartialPayment);
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Sale successful"));
                 gstTypeTable2 = salesTabel.getValueAt(0, 10).toString();
                 printBill(saleMaster, gstTypeTable2);
                 printBillByHsnCode(saleMaster, gstTypeTable2);
                clear();
                clear1();
                DefaultTableModel defaultTableModel = (DefaultTableModel) salesTabel.getModel();
                defaultTableModel.setRowCount(0);
                salesTabel.setModel(defaultTableModel);
               

                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Invalid Entry!!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

      private void save() {
        try {
             newWarehouseFlag = false;
            if (salesTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("No order placed"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String paymentMode = this.paymentMode.getSelectedItem().toString();

            SaleMaster saleMaster = new SaleMaster();
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();
            
          //  String warehouseName = this.warehouseName.getSelectedItem().toString();
            String warehouseName = this.warehouseName.getSelectedItem().toString();


            if(warehouseName.equalsIgnoreCase("--Select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select a Warehouswe"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.warehouseName.requestFocus();
                return;
            }
             

//            if(warehouseName.equalsIgnoreCase("--Add Warehouswe--"))
//            {
//                if(newWarehouswe.getText().trim().isEmpty())
//                {
//                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Warehouswe Name"), "Error message", JOptionPane.ERROR_MESSAGE);
//                    newWarehouswe.requestFocus();
//                    return;
//                }
//                warehouseName = newWarehouswe.getText().trim();
//                newWarehouseFlag = true;
//            }
           
            CustomerDetails customerDetails = new CustomerDetails();
            WarehoseDetailsQuery123 customerDetailsQuery = new WarehoseDetailsQuery123();

            customerDetails.setName(warehouseName);

            List<CustomerDetails> list = customerDetailsQuery.getCustomerDetails(customerDetails);

    /*        if(!(list.isEmpty()) && newWarehouseFlag == true)
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("This Warehouswe already exists"), "Error message", JOptionPane.ERROR_MESSAGE);
                newWarehouswe.requestFocus();
                newWarehouseFlag = false;
                return;
            }
            
            
                
                customerDetails.setContact(contact.getText().trim());
                customerDetails.setAddress(address.getText().trim());
                customerDetails.setBalance(new BigDecimal(0.00));
                customerDetails.setGstNumber(gstNumber.getText().trim());
*/
                if(list.isEmpty())
                    customerDetailsQuery.insertWarehouse(customerDetails);        
                else
                {
                    for(CustomerDetails cm: list)
                    {
                        customerDetails.setId(cm.getId());
                        customerDetails.setBalance(cm.getBalance().add(new BigDecimal(0.00)));
                    }
                    customerDetailsQuery.updateWarehouseBalance(customerDetails);
                }            
            
            CustomerPartialPayment customerPartialPayment = new CustomerPartialPayment();
            customerPartialPayment.setPaymentMode(paymentMode);
            customerPartialPayment.setBank("N/A");
            customerPartialPayment.setChequeOrCardNumber("N/A");
            customerPartialPayment.setCustomerDetails(customerDetails);
            customerPartialPayment.setDate(this.date.getDate());
            customerPartialPayment.setStatus("1");
            customerPartialPayment.setPaidAmount(new BigDecimal(total.getText().trim()));

            CustomerPartialPaymentQuery customerPartialPaymentQuery = new CustomerPartialPaymentQuery();

            if (!(paymentMode.equalsIgnoreCase("cash"))) {
                if (number.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/Card/Transaction Number"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    number.requestFocus();
                    return;
                }
                customerPartialPayment.setChequeOrCardNumber(number.getText().trim());
                if (paymentMode.equalsIgnoreCase("cheque")) {
                    Date saleDate = this.date.getDate();
                    Date chequeDate = this.chequeDate.getDate();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    String stringChequeDate = dateFormat.format(chequeDate);
                    String stringPurchaseDate = dateFormat.format(saleDate);

                }

                if (!(paymentMode.equalsIgnoreCase("paytm"))) {
                    customerPartialPayment.setBank(bank.getSelectedItem().toString());
                }
            }

//            if(paymentMode.equalsIgnoreCase("cheque"))
//            {
//                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Can't make full payment with Cheque!!!<br>Go for Partial Payment"), "Error message", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            saleMaster.setGstAmount(BigDecimal.valueOf(getTotalGSTAmount()));
            //saleMaster.setIgstAmount(BigDecimal.valueOf(getTotalGSTAmount()));

            saleMaster.setBillAmount(new BigDecimal(getTotalBillAmount()));
            saleMaster.setFinalBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setDiscount(new BigDecimal(0));

            if (jCheckBoxDiscount.isSelected()) {
                if (discount.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) == 0) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) > Float.parseFloat(total.getText().trim())) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                saleMaster.setDiscount(new BigDecimal(discount.getText().trim()));
                saleMaster.setFinalBillAmount(new BigDecimal(finalAmount.getText().trim()));
                customerPartialPayment.setPaidAmount(new BigDecimal(finalAmount.getText().trim()));
            }
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of this Sale?"));
            if (confirm == JOptionPane.YES_OPTION) {
                saleMaster.setId(Integer.parseInt(billId.getText()));
                saleMaster.setCustomerDetails(customerDetails);
                saleMaster.setReference(reference.getText().trim());
                saleMaster.setStatus("1");
                String gstTypeTable2 = salesTabel.getValueAt(0, 10).toString();
                
                saleMaster.setRemark(gstTypeTable2); 
               
                saleMasterQuery.updateSaleMaster(saleMaster);

                customerPartialPaymentQuery.insertIntoCustomerPartialPayment(customerPartialPayment);
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Sale successful"));
                 gstTypeTable2 = salesTabel.getValueAt(0, 10).toString();
                 //printBill(saleMaster, gstTypeTable2);
                clear();
                clear1();
                DefaultTableModel defaultTableModel = (DefaultTableModel) salesTabel.getModel();
                defaultTableModel.setRowCount(0);
                salesTabel.setModel(defaultTableModel);
               

                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Invalid Entry!!!"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private void checkDispose() {
        int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of closing this form?"));
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
    private void printBillByHsnCode(SaleMaster saleMaster, String flag){
     Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String joinQuery = "SELECT\n" +
                        "     counter.`Id` AS counter_Id,\n" +
                        "      sale_details.`gstPercent` AS sale_details_gstPercent,\n" +
                        "     sum(sale_details.`igstPercent` )AS  sale_details_igstPercent,\n" +

                        "     sum(sale_details.`sellingPrice` )AS  sale_details_sellingTotalPrice,\n" +

                        "     sale_details.`gstPercent` AS sale_details_gstPercent,\n" +

                        "     (SELECT SUM( `sale_details`.`igstPercent`)    FROM  `sale_details` sale_details \n" +

                        "     INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n" +

                        "	 WHERE sale_details.`gstPercent` ='5.00' and sale_master.id =  " + saleMaster.getId()+" group by sale_details.`gstPercent`) AS sale_details_total5GstAmount,\n" +

                        "          (SELECT SUM( `sale_details`.`igstPercent`)    FROM  `sale_details` sale_details \n" +

                        "     INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n" +

                        "	 WHERE sale_details.`gstPercent` ='12.00' and sale_master.id =  " + saleMaster.getId()+" group by sale_details.`gstPercent`) AS sale_details_total12GstAmount,\n" +

                        "          (SELECT SUM( `sale_details`.`igstPercent`)    FROM  `sale_details` sale_details \n" +

                        "     INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n" +

                        "	 WHERE sale_details.`gstPercent` ='18.00' and sale_master.id = " + saleMaster.getId()+" group by sale_details.`gstPercent`) AS sale_details_total18GstAmount,\n" +

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

                        "     customer_master.`Id` AS customer_master_Id,\n" +

                        "     customer_master.`name` AS customer_master_name,\n" +

                        "     customer_master.`contact` AS customer_master_contact,\n" +

                        "     customer_master.`address` AS customer_master_address,\n" +

                        "     customer_master.`balance` AS customer_master_balance,\n" +

                        "     customer_master.`gstNumber` AS customer_master_gstNumber,\n" +

                        "     sale_details.`Id` AS sale_details_Id,\n" +

                        "     sale_details.`saleId` AS sale_details_saleId,\n" +

                        "     sale_details.`itemId` AS sale_details_itemId,\n" +

                        "     sale_details.`unitPrice` AS sale_details_unitPrice,\n" +

                        "     sale_details.`gstPercent` AS sale_details_gstPercent,\n" +

                        "     sale_details.`sellingPrice` AS  sale_details_sellingPrice,\n" +

                        "     sale_details.`quantity` AS sale_details_quantity,\n" +

                        "     sale_details.`total` AS sale_details_total,\n" +

                        "     sale_master.`Id` AS sale_master_Id,\n" +

                        "     sale_master.`date` AS sale_master_date,\n" +

                        "     sale_master.`storeId` AS sale_master_storeId,\n" +

                        "     sale_master.`counterId` AS sale_master_counterId,\n" +

                        "     sale_master.`customerId` AS sale_master_customerId,\n" +

                        "     sale_master.`billAmount` AS sale_master_billAmount,\n" +

                        "     sale_master.`gstAmount` AS sale_master_gstAmount,\n" +

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

                        "     store_details.`photo` AS store_details_photo,\n" +
                   
                        "     number_to_string( sale_master.`finalBillAmount` )  AS wordFinalBillAmount \n"+

                        "FROM\n" +

                        "     `item_master` item_master INNER JOIN `sale_details` sale_details ON item_master.`Id` = sale_details.`itemId`\n" +

                        "     INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n" +

                        "     INNER JOIN `customer_master` customer_master ON sale_master.`customerId` = customer_master.`Id`\n" +

                        "     INNER JOIN `counter` counter ON sale_master.`counterId` = counter.`Id`\n" +

                        "     INNER JOIN `store_details` store_details ON sale_master.`storeId` = store_details.`Id`\n" +

                        "    WHERE sale_master.id = " + saleMaster.getId()+
                        "    GROUP BY hsnCode ,sale_details_gstPercent " ;
        
        try {
            connection = MyConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(joinQuery);

            String reportSource = "";

            if ("GST".equals(flag)) {
               // reportSource = ReadFile.getPath() + "Reports\\GstSaleHSN.jrxml";
                reportSource = ReadFile.getPath() + "Reports\\GstSaleHSN_new.jrxml";
                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, resultSetDataSource);
                JasperViewer.viewReport(jasperPrint, false);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    //    System.out.println("Statement");
                    resultSet.close();
                } catch (SQLException e) { /* ignored */

                }
            }
            if (statement != null) {
                try {
                    //    System.out.println("Statement");
                    statement.close();
                } catch (SQLException e) { /* ignored */

                }
            }

            if (connection != null) {
                try {
                    //    System.out.println("Connection");
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    private void printBill(SaleMaster saleMaster, String flag) {
     Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String joinQuery = "SELECT\n"
             
              + "   counter.`Id` AS counter_Id,\n"
              + "   counter.`name` AS counter_name,\n"
              + "    counter.`status` AS counter_status,\n"
              + "    item_master.`Id` AS item_master_Id,\n"
              + "    item_master.`name` AS item_master_name,\n"
              + "    item_master.`unitPrice` AS item_master_unitPrice,\n"
              + "    item_master.`gstPercent` AS item_master_gstPercent,\n"
              + "    item_master.`sellingPrice` AS item_master_sellingPrice,\n"
              + "   item_master.`sellingGstPercent` AS item_master_sellingGstPercent,\n"
              + "    item_master.`finalSellingPrice` AS item_master_finalSellingPrice,\n"
              + "    item_master.`hsnCode` AS hsnCode,\n"
              + "    customer_master.`Id` AS customer_master_Id,\n"
              + "    customer_master.`name` AS customer_master_name,\n"
              + "    customer_master.`contact` AS customer_master_contact,\n"
              + "    customer_master.`address` AS customer_master_address,\n"
              + "    customer_master.`balance` AS customer_master_balance,\n"
              + "    customer_master.`gstNumber` AS customer_master_gstNumber,\n"
              + "    sale_details.`Id` AS sale_details_Id,\n"
              + "    sale_details.`saleId` AS sale_details_saleId,\n"
              + "    sale_details.`itemId` AS sale_details_itemId,\n"
              + "    sale_details.`unitPrice` AS sale_details_unitPrice,\n"
              + "    sale_details.`gstPercent` AS sale_details_gstPercent,\n"
              + "    sale_details.`igstPercent` AS sale_details_igstPercent,\n"
              + "     sale_details.`sellingPrice` AS sale_details_sellingPrice,\n"
              + "    sale_details.`quantity` AS sale_details_quantity,\n"
              + "    sale_details.`total` AS sale_details_total,\n"
              + "    sale_master.`Id` AS sale_master_Id,\n"
              + "    sale_master.`date` AS sale_master_date,\n"
              + "    sale_master.`storeId` AS sale_master_storeId,\n"
              + "    sale_master.`counterId` AS sale_master_counterId,\n"
              + "    sale_master.`customerId` AS sale_master_customerId,\n"
              + "    sale_master.`billAmount` AS sale_master_billAmount,\n"
              + "     sale_master.`gstAmount` AS sale_master_gstAmount,\n"
              + "    sale_master.`discount` AS sale_master_discount,\n"
              + "    sale_master.`finalBillAmount` AS sale_master_finalBillAmount,\n"
              + "    sale_master.`status` AS sale_master_status,\n"
              + "    sale_master.`remark` AS sale_master_remark,\n"
              + "    store_details.`Id` AS store_details_Id,\n"
              + "    store_details.`name` AS store_details_name,\n"
              + "   store_details.`address` AS store_details_address,\n"
              + "   store_details.`city` AS store_details_city,\n"
              + "    store_details.`state` AS store_details_state,\n"
              + "    store_details.`pincode` AS store_details_pincode,\n"
              + "    store_details.`phone` AS store_details_phone,\n"
              + "    store_details.`website` AS store_details_website,\n"
              + "    store_details.`email` AS store_details_email,\n"
              + "   store_details.`gstNumber` AS store_details_gstNumber,\n"
              + "   store_details.`photo` AS store_details_photo,\n"          
              +"     number_to_string( sale_master.`finalBillAmount` )  AS wordFinalBillAmount \n"
            + " FROM\n"
             + "    `item_master` item_master INNER JOIN `sale_details` sale_details ON item_master.`Id` = sale_details.`itemId`\n"
             + "    INNER JOIN `sale_master` sale_master ON sale_details.`saleId` = sale_master.`Id`\n"
             + "    INNER JOIN `customer_master` customer_master ON sale_master.`customerId` = customer_master.`Id`\n"
             + "    INNER JOIN `counter` counter ON sale_master.`counterId` = counter.`Id`\n"
             + "    INNER JOIN `store_details` store_details ON sale_master.`storeId` = store_details.`Id`\n"
             + "    WHERE sale_master.id = " + saleMaster.getId();
        try {
            connection = MyConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(joinQuery);

            String reportSource = "";

            if ("GST".equals(flag)) {
                //  reportSource = ReadFile.getPath() + "Reports\\GstSaleDetails.jrxml"; 
                reportSource = ReadFile.getPath() + "Reports\\GstSaleDetailsNew.jrxml";
           
            } else if ("IGST".equals(flag)) {
                //  reportSource = ReadFile.getPath() + "Reports\\GstSaleDetails.jrxml"; 
                reportSource = ReadFile.getPath() + "Reports\\IGstSaleDetails.jrxml";
            } else {
                reportSource = ReadFile.getPath() + "Reports\\NonGstSaleDetails.jrxml";
            }
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, resultSetDataSource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    //    System.out.println("Statement");
                    resultSet.close();
                } catch (SQLException e) { /* ignored */

                }
            }
            if (statement != null) {
                try {
                    //    System.out.println("Statement");
                    statement.close();
                } catch (SQLException e) { /* ignored */

                }
            }

            if (connection != null) {
                try {
                    //    System.out.println("Connection");
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    private void changeQuantity() {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#0.000");
            int detailsId = Integer.parseInt(salesTabel.getValueAt(salesTabel.getSelectedRow(), 0).toString());
            int itemId = Integer.parseInt(salesTabel.getValueAt(salesTabel.getSelectedRow(), 1).toString());
            float quantity = Float.parseFloat(salesTabel.getValueAt(salesTabel.getSelectedRow(), 5).toString());
            float unitPrice = Float.parseFloat(salesTabel.getValueAt(salesTabel.getSelectedRow(), 4).toString());
            float sellingPrice = Float.parseFloat(salesTabel.getValueAt(salesTabel.getSelectedRow(), 8).toString());
            float gstPercent = Float.parseFloat(salesTabel.getValueAt(salesTabel.getSelectedRow(), 6).toString());

            String itemName = salesTabel.getValueAt(salesTabel.getSelectedRow(), 2).toString();
            
            String gstType = salesTabel.getValueAt(salesTabel.getSelectedRow(), 10).toString();
            float newQuantity = 0;

            JFrame frame = new JFrame("Input");

            ItemMaster itemMaster = new ItemMaster();
            itemMaster.setId(itemId);

            ItemAvailability eAvailability = new ItemAvailability();
            ItemAvailabilityQuery endProductAvailabilityQuery = new ItemAvailabilityQuery();

            eAvailability.setItemMaster(itemMaster);

            List<ItemAvailability> endProductAvalabilityList = endProductAvailabilityQuery.checkItem(eAvailability);
            for (ItemAvailability ea : endProductAvalabilityList) {
                eAvailability.setId(ea.getId());
                eAvailability.setAvailability(ea.getAvailability());
            }

            eAvailability.setAvailability(eAvailability.getAvailability().add(new BigDecimal(quantity)));

          //  newQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(eAvailability.getAvailability()) + "</FONT></HTML>"));
            newQuantity = Float.parseFloat(JOptionPane.showInputDialog(frame, "<HTML><FONT color=\"#000000\">Enter the quantity of: <strong><U>" + itemName + "</U></strong><br><strong><U>" + gstType + "</U></strong><br>Available Quantity = <strong><U>" + decimalFormat.format(eAvailability.getAvailability()) + "</FONT></HTML>"));
            int compare = new BigDecimal(newQuantity).compareTo(eAvailability.getAvailability());

            /*  if(compare == 1)
             {
             JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Entered Quantity is greater than Available Quantity"), "Error Message", JOptionPane.ERROR_MESSAGE);
             return;
             } */
            if (newQuantity == 0) {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Quantity can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            endProductAvailabilityQuery.updateItemAvailability(eAvailability);
            eAvailability.setAvailability(eAvailability.getAvailability().subtract(new BigDecimal(newQuantity)));

            endProductAvailabilityQuery.updateItemAvailability(eAvailability);
            float total = (newQuantity * unitPrice) * (gstPercent) / 100;

            SaleDetails saleDetails = new SaleDetails();
            saleDetails.setId(detailsId);
            saleDetails.setQuantity(new BigDecimal(newQuantity));
            saleDetails.setTotal(new BigDecimal(total));

            SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();
            saleDetailsQuery.updateSaleDetails(saleDetails);

            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the Item you want to change the quantity of"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFinalAmountPaid(String discount) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        finalAmount.setText(decimalFormat.format(Float.parseFloat(total.getText()) - Float.parseFloat(discount)));
    }

    private void getGstTaken() {
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();

        SaleMaster saleMaster = new SaleMaster();

        int i = 0;

        while (i < salesTabel.getRowCount()) {
            saleMaster.setId(Integer.parseInt(billId.getText().trim()));
            int itemId = Integer.parseInt(salesTabel.getValueAt(i, 1).toString());

            itemMaster.setId(itemId);

            saleDetails.setSaleMaster(saleMaster);
            saleDetails.setItemMaster(itemMaster);

            List<SaleDetails> list = saleDetailsQuery.checkItem(saleDetails);

            for (SaleDetails sd : list) {
                List<ItemMaster> itemList = itemQuery.getItemById(itemMaster);
                for (ItemMaster im : itemList) {
                    itemMaster.setSellingPrice(im.getSellingPrice());
                    itemMaster.setSellingGstPercent(im.getSellingGstPercent());
                    itemMaster.setFinalSellingPrice(im.getFinalSellingPrice());
                }
                saleDetails.setId(sd.getId());
                saleDetails.setGstPercent(itemMaster.getSellingGstPercent());
                saleDetails.setSellingPrice(itemMaster.getFinalSellingPrice());
                saleDetails.setTotal(sd.getQuantity().multiply(saleDetails.getSellingPrice()));

                itemMaster.getSellingGstPercent();
                saleDetailsQuery.updateGst(saleDetails);
            }
            i++;
        }
        getDetails();
    }

    private void getIGstTaken() {
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();

        SaleMaster saleMaster = new SaleMaster();

        int i = 0;

        while (i < salesTabel.getRowCount()) {
            saleMaster.setId(Integer.parseInt(billId.getText().trim()));
            int itemId = Integer.parseInt(salesTabel.getValueAt(i, 1).toString());

            itemMaster.setId(itemId);

            saleDetails.setSaleMaster(saleMaster);
            saleDetails.setItemMaster(itemMaster);

            List<SaleDetails> list = saleDetailsQuery.checkItem(saleDetails);

            for (SaleDetails sd : list) {
                List<ItemMaster> itemList = itemQuery.getItemById(itemMaster);
                for (ItemMaster im : itemList) {
                    itemMaster.setSellingPrice(im.getSellingPrice());
                    itemMaster.setSellingGstPercent(im.getSellingGstPercent());
                    itemMaster.setFinalSellingPrice(im.getFinalSellingPrice());
                }
                saleDetails.setId(sd.getId());
                if (itemMaster.getGstType() == "IGST") {
                  
                    saleDetails.setGstType(itemMaster.getGstType().toString());
                   // saleDetails.setIgstPercent(itemMaster.getSellingGstPercent());
                }
                saleDetails.setSellingPrice(itemMaster.getFinalSellingPrice());
                saleDetails.setTotal(sd.getQuantity().multiply(saleDetails.getSellingPrice()));

                itemMaster.getSellingGstPercent();
                saleDetailsQuery.updateGst(saleDetails);
            }
            i++;
        }
        getDetails();
    }

    private void getGstNotTaken() {
        SaleDetails saleDetails = new SaleDetails();
        SaleDetailsQuery saleDetailsQuery = new SaleDetailsQuery();

        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();

        SaleMaster saleMaster = new SaleMaster();

        int i = 0;

        while (i < salesTabel.getRowCount()) {
            saleMaster.setId(Integer.parseInt(billId.getText().trim()));
            int itemId = Integer.parseInt(salesTabel.getValueAt(i, 1).toString());

            itemMaster.setId(itemId);

            saleDetails.setSaleMaster(saleMaster);
            saleDetails.setItemMaster(itemMaster);

            List<SaleDetails> list = saleDetailsQuery.checkItem(saleDetails);

            for (SaleDetails sd : list) {
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

    private float calculateGst(float total, float gstPercent) {
        float gstAmount = (total * gstPercent) / 100;
        return gstAmount;
    }

    private void partialPayment() {
        try {
            if (salesTabel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("No order placed"), "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String paymentMode = this.paymentMode.getSelectedItem().toString();

            SaleMaster saleMaster = new SaleMaster();
            SaleMasterQuery saleMasterQuery = new SaleMasterQuery();

            CustomerDetails customerDetails = new CustomerDetails();

            customerDetails.setId(1);

            CustomerPartialPayment customerPartialPayment = new CustomerPartialPayment();
            customerPartialPayment.setPaymentMode(paymentMode);
            customerPartialPayment.setBank("N/A");
            customerPartialPayment.setChequeOrCardNumber("N/A");
            customerPartialPayment.setCustomerDetails(customerDetails);
            customerPartialPayment.setDate(this.date.getDate());
            customerPartialPayment.setStatus("1");
            customerPartialPayment.setPaidAmount(new BigDecimal(total.getText().trim()));

            CustomerPartialPaymentQuery customerPartialPaymentQuery = new CustomerPartialPaymentQuery();

            if (!(paymentMode.equalsIgnoreCase("cash"))) {
                if (number.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/Card/Transaction Number"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    number.requestFocus();
                    return;
                }
                customerPartialPayment.setChequeOrCardNumber(number.getText().trim());
                if (paymentMode.equalsIgnoreCase("cheque")) {
                    Date saleDate = this.date.getDate();
                    Date chequeDate = this.chequeDate.getDate();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    String stringChequeDate = dateFormat.format(chequeDate);
                    String stringPurchaseDate = dateFormat.format(saleDate);

                    try {
                        chequeDate = dateFormat.parse(stringChequeDate);
                        saleDate = dateFormat.parse(stringPurchaseDate);

                        if (chequeDate.compareTo(saleDate) < 0) {
                            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Cheque Date can't be ahead of Sale Date"), "Error message", JOptionPane.ERROR_MESSAGE);
                            this.chequeDate.requestFocus();
                            return;
                        }

                        customerPartialPayment.setChequeDate(chequeDate);
                        customerPartialPayment.setStatus("0");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (!(paymentMode.equalsIgnoreCase("paytm"))) {
                    customerPartialPayment.setBank(bank.getSelectedItem().toString());
                }
            }
            saleMaster.setBillAmount(new BigDecimal(total.getText().trim()));
            if (gstTaken.isSelected()) {
                saleMaster.setGstAmount(BigDecimal.valueOf(calculateGst(Float.valueOf(saleMaster.getBillAmount().toString()), Float.valueOf(gst.getSelectedItem().toString()))));
                saleMaster.setIgstAmount(BigDecimal.valueOf(0));

            } else if (igstTaken.isSelected()) {

                saleMaster.setIgstAmount(BigDecimal.valueOf(calculateGst(Float.valueOf(saleMaster.getBillAmount().toString()), Float.valueOf(gst.getSelectedItem().toString()))));
                saleMaster.setGstAmount(BigDecimal.valueOf(0));
            } else {
                saleMaster.setIgstAmount(BigDecimal.valueOf(0));
                saleMaster.setGstAmount(BigDecimal.valueOf(0));
            }
            saleMaster.setFinalBillAmount(new BigDecimal(total.getText().trim()));
            saleMaster.setDiscount(new BigDecimal(0));

            if (jCheckBoxDiscount.isSelected()) {
                if (discount.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) == 0) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if (Float.parseFloat(discount.getText().trim()) > Float.parseFloat(total.getText().trim())) {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be greater than Bill Amount"), "Error Message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                saleMaster.setDiscount(new BigDecimal(discount.getText().trim()));
                saleMaster.setFinalBillAmount(new BigDecimal(finalAmount.getText().trim()));
                customerPartialPayment.setPaidAmount(new BigDecimal(finalAmount.getText().trim()));
            }

            saleMaster.setId(Integer.parseInt(billId.getText()));
            saleMaster.setCustomerDetails(customerDetails);
            saleMaster.setReference(reference.getText().trim());
            saleMaster.setStatus("1");
            if (gstTaken.isSelected()) {
                saleMaster.setRemark("GST");
            } else if (igstTaken.isSelected()) {
                saleMaster.setRemark("IGST");
            } else {
                saleMaster.setRemark("NON-GST");
            }

            dispose();

            CustomerPartialPaymentView storeDetails = new CustomerPartialPaymentView(jDesktopPane, saleMaster, customerPartialPayment, counter.getSelectedItem().toString());
            storeDetails.setTitle("Warehouswe Partial Payment");
            jDesktopPane.add(storeDetails);
            SetDimension setDimension = new SetDimension();
            setDimension.setInternalFrameLocation(jDesktopPane, storeDetails);
            storeDetails.setVisible(true);
        } catch (Exception e) {

        }
    }
    
    private void loadWarehouswe() 
    {
        CustomerDetails customerDetails = new CustomerDetails();
        WarehoseDetailsQuery123 customerQuery = new WarehoseDetailsQuery123();
        
        if(warehouseFlag)
            customerDetails.setName(warehouseName.getSelectedItem().toString());
        
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel)warehouseName.getModel();
            
        List<CustomerDetails> list = customerQuery.getCustomerDetails(customerDetails);
        if(!(warehouseFlag))
        {
            defaultComboBoxModel.removeAllElements();
        
            defaultComboBoxModel.addElement("--Select--");
            defaultComboBoxModel.addElement("--Add Warehouswe--");
            defaultComboBoxModel.addElement("N/A");
            for(CustomerDetails vm: list)
                defaultComboBoxModel.addElement(vm.getName());
        }
        else
        {
            for(CustomerDetails vm: list)
            {
                warehouseName.setSelectedItem(vm.getName());
//                address.setText(vm.getAddress());
//                contact.setText(vm.getContact());
//                
//                gstNumber.setText(vm.getGstNumber());
            }      
        }
        warehouseName.setModel(defaultComboBoxModel);
    }

}
