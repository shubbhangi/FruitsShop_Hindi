package com.grocery.view;


import com.grocery.bean.Expenses;
import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
import com.grocery.bean.StockDetails;
import com.grocery.bean.StoreDetails;
import com.grocery.bean.VendorBillMaster;
import com.grocery.bean.VendorMaster;
import com.grocery.bean.VendorPartialPayment;
import com.grocery.dimension.SetDimension;
import com.grocery.query.BeginningCashQuery;
import com.grocery.query.ExpensesQuery;
import com.grocery.query.ItemAvailabilityQuery;
import com.grocery.query.ItemQuery;
import com.grocery.query.StockDetailsQuery;
import com.grocery.query.VendorBillMasterQuery;
import com.grocery.query.VendorPartialPaymentQuery;
import com.grocery.query.VendorQuery;
import com.grocery.read.MessageFormat;
import com.grocery.read.ReadFile;
import com.grocery.util.MyConnection;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_A;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
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
public class AddStockView extends javax.swing.JInternalFrame {

    private Date date = new Date();
    private JDesktopPane jDesktopPane;
    private JTextFieldDateEditor editor;
    private boolean vendorFlag;
    private boolean newVendorFlag;
    private boolean itemFlag;
    private BigDecimal beginningCash;
    private BigDecimal expenses;
    
    public AddStockView(JDesktopPane jDesktopPane) {
        initComponents();
        jLabel28.setVisible(false);
        registration.setVisible(false);
        gstNotTaken.setSelected(true);
        quantity.setFont(quantity.getFont().deriveFont(Font.BOLD, 11));
        total.setFont(total.getFont().deriveFont(Font.BOLD, 11));
        sellingPrice.setFont(sellingPrice.getFont().deriveFont(Font.BOLD, 11));
        this.jDesktopPane = jDesktopPane;
        
        add.setMnemonic(VK_A);
        fullPayment.setMnemonic(KeyEvent.VK_F);
        partialPayment.setMnemonic(KeyEvent.VK_P);
        
        jPanelNewVendor.setVisible(false);
        jPanelItem.setVisible(false);
        jPanelPaymentMode.setVisible(false);
        
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        
        purchaseDate.setDate(date);
        chequeDate.setDate(date);
        editor = (JTextFieldDateEditor)purchaseDate.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor)chequeDate.getDateEditor();
        editor.setEditable(false);
        
        jPanelDiscount.setVisible(false);

        loadVendor();
        loadItem();
        loadBeginningCash();
        loadExpenses();
        loadCash();
        getTotal();
        
    }
    
   

    public AddStockView(DefaultTableModel defaultTableModel, JDesktopPane jDesktopPane, VendorMaster vendorMaster, VendorPartialPayment vendorPartialPayment, boolean newVendorFlag, String challanNumber, String discount, String finalAmount, String reference) 
    {
        initComponents();
        this.reference.setText(reference);
        jLabel28.setVisible(false);
        registration.setVisible(false);
        gstNotTaken.setSelected(true);
        jPanelDiscount.setVisible(false);
        jCheckBoxDiscount.setSelected(false);
        this.discount.setText(discount);
        this.finalAmountPaid.setText(finalAmount);
        
        this.jDesktopPane = jDesktopPane;
        jTable1.setModel(defaultTableModel);
        
        add.setMnemonic(VK_A);
        fullPayment.setMnemonic(KeyEvent.VK_F);
        partialPayment.setMnemonic(KeyEvent.VK_P);
        
        jPanelNewVendor.setVisible(false);
        jPanelItem.setVisible(false);
        jPanelPaymentMode.setVisible(false);
        
        jTable1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 11));
        
        purchaseDate.setDate(date);
        chequeDate.setDate(date);
        editor = (JTextFieldDateEditor)purchaseDate.getDateEditor();
        editor.setEditable(false);
        
        editor = (JTextFieldDateEditor)chequeDate.getDateEditor();
        editor.setEditable(false);     
        
        loadVendor();
        loadItem();
        loadBeginningCash();
        loadExpenses();
        loadCash();
        getTotal();
        
        registration.setText(vendorMaster.getRegistration());
        contact.setText(vendorMaster.getContact());
        address.setText(vendorMaster.getAddress());
        gstNumber.setText(vendorMaster.getGstNumber());
        
        if(newVendorFlag) 
        {
            vendorName.setSelectedItem("Add New");
       //     jPanelNewVendor.setVisible(true);
            newVendor.setText(vendorMaster.getName());
            registration.setText(vendorMaster.getRegistration());
            contact.setText(vendorMaster.getContact());
            address.setText(vendorMaster.getAddress());
            gstNumber.setText(vendorMaster.getGstNumber());
        }
        else
            vendorName.setSelectedItem(vendorMaster.getName());
        
        purchaseDate.setDate(vendorPartialPayment.getDate());
        
        paymentMode.setSelectedItem(vendorPartialPayment.getPaymentMode());
        challan.setText(challanNumber);
        
        if(vendorPartialPayment.getPaymentMode().equalsIgnoreCase("card"))
        {
            bank.setSelectedItem(vendorPartialPayment.getBank());
            cheque.setText(vendorPartialPayment.getChequeCardNumber());
        }
        if(vendorPartialPayment.getChequeDate() != null)
        {
            chequeDate.setDate(vendorPartialPayment.getChequeDate());
            cheque.setText(vendorPartialPayment.getChequeCardNumber());
            bank.setSelectedItem(vendorPartialPayment.getBank());
        }
        
        if(Float.parseFloat(discount) != 0)
        {
            jPanelDiscount.setVisible(true);
            jCheckBoxDiscount.setSelected(true);
            this.discount.setText(discount);
            this.finalAmountPaid.setText(finalAmount);
        }
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jPanelNewVendor = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        newVendor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        item = new javax.swing.JComboBox<String>();
        jPanelItem = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        newItem = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        gst = new javax.swing.JComboBox<String>();
        jLabel27 = new javax.swing.JLabel();
        challan = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        registration = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        purchaseDate = new com.toedter.calendar.JDateChooser();
        jSeparator5 = new javax.swing.JSeparator();
        vendorName = new javax.swing.JComboBox<String>();
        add = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        remove = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        availableCash = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        paymentMode = new javax.swing.JComboBox<String>();
        jPanelPaymentMode = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        bank = new javax.swing.JComboBox<String>();
        jLabel36 = new javax.swing.JLabel();
        cheque = new javax.swing.JTextField();
        chequeDate = new com.toedter.calendar.JDateChooser();
        fullPayment = new javax.swing.JButton();
        partialPayment = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        quantity = new javax.swing.JFormattedTextField();
        total = new javax.swing.JFormattedTextField();
        jCheckBoxDiscount = new javax.swing.JCheckBox();
        jPanelDiscount = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        jLabel38 = new javax.swing.JLabel();
        finalAmountPaid = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        sellingPrice = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        gstAmount = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        finalAmount = new javax.swing.JTextField();
        gstTaken = new javax.swing.JRadioButton();
        gstNotTaken = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        hsnCode = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        gstNumber = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Vendor Details:");

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Name:");

        jPanelNewVendor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Name:");

        newVendor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        newVendor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newVendor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newVendorFocusGained(evt);
            }
        });
        newVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVendorActionPerformed(evt);
            }
        });
        newVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newVendorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewVendorLayout = new javax.swing.GroupLayout(jPanelNewVendor);
        jPanelNewVendor.setLayout(jPanelNewVendorLayout);
        jPanelNewVendorLayout.setHorizontalGroup(
            jPanelNewVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewVendorLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(newVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelNewVendorLayout.setVerticalGroup(
            jPanelNewVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewVendorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelNewVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Contact #:");

        contact.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contact.setText("N/A");
        contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactFocusLost(evt);
            }
        });
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Address:");

        address.setColumns(20);
        address.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        address.setRows(5);
        address.setText("N/A");
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFocusLost(evt);
            }
        });
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(address);

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Item Details:");

        jLabel22.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Item Name:");

        item.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActionPerformed(evt);
            }
        });

        jPanelItem.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Item Name:");

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

        javax.swing.GroupLayout jPanelItemLayout = new javax.swing.GroupLayout(jPanelItem);
        jPanelItem.setLayout(jPanelItemLayout);
        jPanelItemLayout.setHorizontalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelItemLayout.setVerticalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemLayout.createSequentialGroup()
                .addGroup(jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Quantity:");

        jLabel25.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Total:");

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("GST %:");

        gst.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "5", "12", "18", "28" }));
        gst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gstActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Challan #:");

        challan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        challan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        challan.setText("N/A");
        challan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                challanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                challanFocusLost(evt);
            }
        });
        challan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                challanKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Registration #:");

        registration.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        registration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        registration.setText("N/A");
        registration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registrationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registrationFocusLost(evt);
            }
        });
        registration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrationKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Purchase Date:");

        purchaseDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        vendorName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vendorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorNameActionPerformed(evt);
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

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "HSN Code", "Quantity", "Total", "Unit Price", "GST %", "GST Amount", "Final Total", "Selling Price", "Selling GST %", "Selling GST Amount", "Final Selling Price", "Remark"
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

        remove.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        remove.setText("Remove");
        remove.setMnemonic(KeyEvent.VK_R);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Total:");

        availableCash.setEditable(false);
        availableCash.setBackground(new java.awt.Color(255, 255, 153));
        availableCash.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        availableCash.setForeground(new java.awt.Color(255, 0, 0));
        availableCash.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel31.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Available Cash:");

        amount.setEditable(false);
        amount.setBackground(new java.awt.Color(255, 255, 153));
        amount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 0, 0));
        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel33.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Payment Details:");

        jLabel34.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Payment Mode:");

        paymentMode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        paymentMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Cash", "Card", "Cheque", "NEFT" }));
        paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentModeActionPerformed(evt);
            }
        });

        jPanelPaymentMode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Bank Name:");

        bank.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        bank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A.P. Mahesh Co-Op Urban Bank Ltd", "Abhyudaya Co-op Bank Ltd", "Abu Dhabi Commercial Bank", "Ahmedabad Mercantile Co-operative Bank Ltd", "Allahabad Bank", "Andhra Bank", "Apna Sahakari Bank Ltd.", "Axis Bank", "Bank Of America", "Bank Of Bahrain And Kuwait", "Bank Of Baroda", "Bank Of Ceylon", "Bank Of India", "Bank Of Maharashtra", "Bank Of Nova Scotia", "Bank Of Rajasthan Ltd", "Bank Of Tokyo-Mitsubishi UFJ Ltd", "Barclays Bank PLC", "Bassein Catholic Co-Op Bank Ltd", "Bharat Co-operative Bank (Mumbai) Ltd", "Bharat Overseas Bank", "BNP Paribas", "Calyon Bank", "Canara Bank", "Catholic Syrian Bank Ltd", "Central Bank Of India", "Chinatrust Commercial Bank", "Citibank NA", "Citizencredit Co-operative Bank Ltd", "City Union Bank Ltd", "Corporation Bank", "Cosmos Co-operative Bank Ltd.", "Credit Agricole Corp N Invsmnt Bank", "DBS Bank Ltd", "Dena Bank", "Deutsche Bank AG", "Development Credit Bank Limited", "Dhanalakshmi Bank Ltd", "DICGC", "Dombivli Nagari Sahakari Bank Limited", "Federal Bank Ltd", "Firstrand Bank Limited", "Greater Bombay Co-op. Bank Ltd", "HDFC Bank Ltd", "HSBC", "ICICI Bank Ltd", "IDBI Bank Ltd", "Indian Bank", "Indian Overseas Bank", "Indusind Bank Ltd", "ING Vysya Bank Ltd", "Jammu And Kashmir Bank Ltd", "Janakalyan Sahakari Bank Ltd", "Janata Sahakari Bank Ltd (Pune)", "JP Morgan Chase Bank NA", "Kallappanna Awade Ich Janata S Bank", "Kalupur Commercial Co. Op. Bank Ltd.", "Kalyan Janata Sahakari Bank Ltd.", "Kapole Co Op Bank", "Karad Urban Co-Op Bank Ltd", "Karnataka Bank Ltd", "Karnataka State Apex  Coop. Bank Ltd.", "Karur Vysya Bank", "Kotak Mahindra Bank", "Lakshmi Vilas Bank Ltd", "Mahanagar Co-op Bank Ltd", "Maharashtra State Co Operative Bank", "Mashreq Bank PSC", "Mehsana Urban Cooperative Bank Ltd", "Mizuho Corporate Bank Ltd", "Nagpur Nagrik Sahakari Bank Ltd", "Nainital Bank Limited", "Nasik Merchants Co-Op Bank Ltd", "New India Co-operative Bank Ltd", "Nkgsb Co-op Bank Ltd", "Nutan Nagarik Sahakari Bank Ltd", "Oman International Bank Saog", "Oriental Bank Of Commerce", "Parsik Janata Sahakari Bank Ltd", "PMC Bank", "Punjab And Maharashtra Co-op Bank Ltd", "Punjab And Sind Bank", "Punjab National Bank", "Rajkot Nagarik Sahakari Bank Ltd", "Ratnakar Bank Ltd", "Reserve Bank Of India", "Saraswat Co-operative Bank Ltd", "Shamrao Vithal Co-operative Bank Limited", "Shinhan Bank", "Societe Generale", "South Indian Bank", "Standard Chartered Bank", "State Bank Of Bikaner And Jaipur", "State Bank Of Hyderabad", "State Bank Of India", "State Bank Of Indore", "State Bank Of Mauritius Ltd", "State Bank Of Mysore", "State Bank Of Patiala", "State Bank Of Travancore", "Surat Peoples Co-Op Bank Ltd", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd", "Tamilnadu State Apex Cooperative Bank Limited", "Thane Janata Sahakari Bank Ltd", "The Royal Bank Of Scotland NV", "UBS AG", "UCO Bank", "Union Bank Of India", "United Bank Of India", "Vijaya Bank", "West Bengal State Cooperative Bank Ltd", "Yes Bank Ltd" }));

        jLabel36.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Cheque/NEFT #:");

        cheque.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cheque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cheque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chequeKeyTyped(evt);
            }
        });

        chequeDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanelPaymentModeLayout = new javax.swing.GroupLayout(jPanelPaymentMode);
        jPanelPaymentMode.setLayout(jPanelPaymentModeLayout);
        jPanelPaymentModeLayout.setHorizontalGroup(
            jPanelPaymentModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaymentModeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cheque, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanelPaymentModeLayout.setVerticalGroup(
            jPanelPaymentModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPaymentModeLayout.createSequentialGroup()
                .addGroup(jPanelPaymentModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPaymentModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPaymentModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        fullPayment.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        fullPayment.setText("Full Payment");
        fullPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullPaymentActionPerformed(evt);
            }
        });

        partialPayment.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        partialPayment.setText("Partial Payment");
        partialPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partialPaymentActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Unit Price:");

        unitPrice.setEditable(false);
        unitPrice.setBackground(new java.awt.Color(255, 255, 153));
        unitPrice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        quantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.setText("0.000");
        quantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("0.00");
        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                totalFocusLost(evt);
            }
        });
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalKeyReleased(evt);
            }
        });

        jCheckBoxDiscount.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jCheckBoxDiscount.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxDiscount.setText("Discount");
        jCheckBoxDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDiscountActionPerformed(evt);
            }
        });

        jPanelDiscount.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Discount Amount:");

        discount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discount.setText("0.00");
        discount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jLabel38.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Final Amount Paid:");

        finalAmountPaid.setEditable(false);
        finalAmountPaid.setBackground(new java.awt.Color(255, 255, 153));
        finalAmountPaid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDiscountLayout.setVerticalGroup(
            jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiscountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(finalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel32.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Selling Price:");

        sellingPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        sellingPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sellingPrice.setText("0.00");
        sellingPrice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        });

        jLabel39.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("GST Amount:");

        gstAmount.setEditable(false);
        gstAmount.setBackground(new java.awt.Color(255, 255, 153));
        gstAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gstAmount.setForeground(new java.awt.Color(255, 0, 0));
        gstAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gstAmount.setText("0.00");

        jLabel40.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Final Amount:");

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

        buttonGroup1.add(gstTaken);
        gstTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gstTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstTaken.setText("GST");

        buttonGroup1.add(gstNotTaken);
        gstNotTaken.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        gstNotTaken.setForeground(new java.awt.Color(255, 0, 0));
        gstNotTaken.setText("Non-GST");

        jLabel42.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("HSN:");

        hsnCode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hsnCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hsnCode.setText("N/A");
        hsnCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hsnCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hsnCodeFocusLost(evt);
            }
        });
        hsnCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hsnCodeKeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Vendor GST #:");

        gstNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gstNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gstNumber.setText("N/A");
        gstNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gstNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gstNumberFocusLost(evt);
            }
        });
        gstNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gstNumberKeyTyped(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Reference:");

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
        reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceActionPerformed(evt);
            }
        });
        reference.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                referenceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                referenceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(494, 494, 494)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(availableCash, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(registration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel33)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vendorName, 0, 240, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanelNewVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)
                                        .addGap(31, 31, 31)
                                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(27, 27, 27)
                                        .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(gstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(partialPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelPaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fullPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jCheckBoxDiscount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(gstNotTaken)
                                .addGap(18, 18, 18)
                                .addComponent(gstTaken)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hsnCode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(challan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel39)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gstAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel40)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(purchaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vendorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanelNewVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(challan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hsnCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gstTaken)
                        .addComponent(gstNotTaken)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gstAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxDiscount)
                        .addComponent(fullPayment))
                    .addComponent(jPanelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partialPayment)
                    .addComponent(jPanelPaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void vendorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorNameActionPerformed
        newVendor.setText("");
        registration.setText("N/A");
        contact.setText("N/A");
        address.setText("N/A");
        gstNumber.setText("N/A");
        
        try
        {
            if(vendorName.getItemCount() != 0)
            {
                if(vendorName.getSelectedIndex() == 0)
                {
                    vendorFlag = false;
                    jPanelNewVendor.setVisible(false);
                }
                else
                    if(vendorName.getSelectedIndex() == 1)
                    {
                        vendorFlag = false;
                        jPanelNewVendor.setVisible(true);
                    }
                    else
                    {
                        vendorFlag = true;
                        jPanelNewVendor.setVisible(false);
                        loadVendor();
                    }
            }  
        }
        catch(Exception e)
        {
        }
        
    }//GEN-LAST:event_vendorNameActionPerformed

    private void newVendorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newVendorKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || c == '.' || c == '-'))
            evt.consume();
    }//GEN-LAST:event_newVendorKeyTyped

    private void addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
            evt.consume();
    }//GEN-LAST:event_addressKeyTyped

    private void addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyPressed
        address.setFocusTraversalKeysEnabled(false);
        if(evt.getKeyCode() == KeyEvent.VK_TAB)
             reference.requestFocus();
    }//GEN-LAST:event_addressKeyPressed

    private void registrationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrationKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == KeyEvent.VK_SPACE))
            evt.consume();
    }//GEN-LAST:event_registrationKeyTyped

    private void contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == '-'))
            evt.consume();
    }//GEN-LAST:event_contactKeyTyped

    private void newItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newItemKeyTyped
/*        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
            evt.consume(); */
    }//GEN-LAST:event_newItemKeyTyped

    private void registrationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registrationFocusLost
        if(registration.getText().trim().isEmpty())
            registration.setText("N/A");
    }//GEN-LAST:event_registrationFocusLost

    private void contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactFocusLost
        if(contact.getText().trim().isEmpty())
            contact.setText("N/A");
    }//GEN-LAST:event_contactFocusLost

    private void addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusLost
        if(address.getText().trim().isEmpty())
            address.setText("N/A");
    }//GEN-LAST:event_addressFocusLost

    private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
        newItem.setText("");
        if(item.getSelectedIndex() == 1)
                jPanelItem.setVisible(true);
        else
            jPanelItem.setVisible(false);              
    }//GEN-LAST:event_itemActionPerformed

    private void challanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_challanFocusLost
        if(challan.getText().trim().isEmpty())
            challan.setText("N/A");
    }//GEN-LAST:event_challanFocusLost

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        addToTable();
    }//GEN-LAST:event_addActionPerformed

    private void newVendorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newVendorFocusGained
        newVendor.selectAll();
    }//GEN-LAST:event_newVendorFocusGained

    private void newItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newItemFocusGained
        newItem.selectAll();
    }//GEN-LAST:event_newItemFocusGained

    private void challanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_challanFocusGained
        challan.selectAll();
    }//GEN-LAST:event_challanFocusGained

    private void chequeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chequeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_chequeKeyTyped

    private void paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentModeActionPerformed
        cheque.setText("");
        chequeDate.setDate(date);
        bank.setSelectedIndex(0);
        if(paymentMode.getSelectedIndex() == 0 || paymentMode.getSelectedIndex() == 1)
            jPanelPaymentMode.setVisible(false);
        else 
            if(paymentMode.getSelectedIndex() == 2)
            {
                jPanelPaymentMode.setVisible(true); 
                chequeDate.setVisible(false);
            }
            else
            {
                jPanelPaymentMode.setVisible(true); 
                chequeDate.setVisible(true);
            }
    }//GEN-LAST:event_paymentModeActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove();
    }//GEN-LAST:event_removeActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            addToTable();
    }//GEN-LAST:event_addKeyPressed

    private void fullPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullPaymentActionPerformed
        fullPayment();
    }//GEN-LAST:event_fullPaymentActionPerformed

    private void registrationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registrationFocusGained
        registration.selectAll();
    }//GEN-LAST:event_registrationFocusGained

    private void contactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactFocusGained
        contact.selectAll();
    }//GEN-LAST:event_contactFocusGained

    private void unitPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitPriceFocusGained
        
    }//GEN-LAST:event_unitPriceFocusGained

    private void gstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gstActionPerformed
        if(!(sellingPrice.getText().trim().isEmpty()))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float sellingPrice = Float.parseFloat(this.sellingPrice.getText());
            float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());
            
            float gstAmount = calculateGst(sellingPrice, gstPercent);
            this.gstAmount.setText(decimalFormat.format(gstAmount));
            
            finalAmount.setText(decimalFormat.format(sellingPrice + gstAmount));
        }
        else
            finalAmount.setText("0.00");
    }//GEN-LAST:event_gstActionPerformed

    private void partialPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partialPaymentActionPerformed
        partialPayment();
    }//GEN-LAST:event_partialPaymentActionPerformed

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusLost
        if(quantity.getText().trim().isEmpty())
            quantity.setText("0.00");
    }//GEN-LAST:event_quantityFocusLost

    private void quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusGained
        quantity.selectAll();
    }//GEN-LAST:event_quantityFocusGained

    private void totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusLost
        if(total.getText().trim().isEmpty())
        {
            total.setText("0.00");
            unitPrice.setText("0.00");
        }
        if(Float.parseFloat(total.getText()) == 0)
            unitPrice.setText("0.00");
    }//GEN-LAST:event_totalFocusLost

    private void totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusGained
        total.selectAll();
    }//GEN-LAST:event_totalFocusGained

    private void sellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingPriceKeyReleased
        if(!(sellingPrice.getText().trim().isEmpty()))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float sellingPrice = Float.parseFloat(this.sellingPrice.getText());
            float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());
            
            float gstAmount = calculateGst(sellingPrice, gstPercent);
            
            if(gstTaken.isSelected())
                this.gstAmount.setText(decimalFormat.format(gstAmount));     
            else
                this.gstAmount.setText("0.00");
            
            finalAmount.setText(decimalFormat.format(sellingPrice + gstAmount));  
        }
        else
        {
            gstAmount.setText("0.00");
            finalAmount.setText("0.00");
        }
    }//GEN-LAST:event_sellingPriceKeyReleased

    private void sellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellingPriceFocusGained
        sellingPrice.selectAll();
    }//GEN-LAST:event_sellingPriceFocusGained

    private void sellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellingPriceFocusLost
        if(sellingPrice.getText().trim().isEmpty())
            sellingPrice.setText("0.00");
    }//GEN-LAST:event_sellingPriceFocusLost

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            remove();
    }//GEN-LAST:event_jTable1KeyPressed

    private void discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusGained
        discount.selectAll();
    }//GEN-LAST:event_discountFocusGained

    private void discountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discountFocusLost
        if(discount.getText().trim().isEmpty())
            discount.setText("0.00");
    }//GEN-LAST:event_discountFocusLost

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        if(!(discount.getText().trim().isEmpty()))
            getFinalAmountPaid(discount.getText());
        else
            finalAmountPaid.setText("0.00");
    }//GEN-LAST:event_discountKeyReleased

    private void unitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceActionPerformed

    private void finalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalAmountActionPerformed

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

    private void totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyReleased
        if(!(total.getText().trim().isEmpty()))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            float quantity = Float.parseFloat(this.quantity.getText());
            float total = Float.parseFloat(this.total.getText());

            float unitPrice = getUnitPrice(total, quantity);
            this.unitPrice.setText(decimalFormat.format(unitPrice));
        }
        else
            unitPrice.setText("0.00");
    }//GEN-LAST:event_totalKeyReleased

    private void finalAmountPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalAmountPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalAmountPaidActionPerformed

    private void challanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_challanKeyTyped
/*        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
            evt.consume(); */
    }//GEN-LAST:event_challanKeyTyped

    private void hsnCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hsnCodeFocusGained
        hsnCode.selectAll();
    }//GEN-LAST:event_hsnCodeFocusGained

    private void hsnCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hsnCodeFocusLost
        if(hsnCode.getText().trim().isEmpty())
            hsnCode.setText("N/A");
    }//GEN-LAST:event_hsnCodeFocusLost

    private void hsnCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hsnCodeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_hsnCodeKeyTyped

    private void gstNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gstNumberFocusGained
        gstNumber.selectAll();
    }//GEN-LAST:event_gstNumberFocusGained

    private void gstNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gstNumberFocusLost
        if(gstNumber.getText().trim().isEmpty())
            gstNumber.setText("N/A");
    }//GEN-LAST:event_gstNumberFocusLost

    private void gstNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gstNumberKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  c == KeyEvent.VK_DELETE || Character.isDigit(c)))
            evt.consume();
    }//GEN-LAST:event_gstNumberKeyTyped

    private void addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusGained
        address.selectAll();
    }//GEN-LAST:event_addressFocusGained

    private void referenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusGained
        reference.selectAll();
    }//GEN-LAST:event_referenceFocusGained

    private void referenceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referenceFocusLost
        if(reference.getText().trim().isEmpty())
            reference.setText("N/A");
    }//GEN-LAST:event_referenceFocusLost

    private void referenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_referenceKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c == KeyEvent.VK_BACK_SPACE)||  c == KeyEvent.VK_DELETE || Character.isDigit(c) || c == ',' || c == '.' || c == KeyEvent.VK_SPACE || c == '-' || c == ':'))
            evt.consume();
    }//GEN-LAST:event_referenceKeyTyped

    private void referenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_referenceActionPerformed

    private void newVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newVendorActionPerformed

    private void referenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_referenceKeyPressed
        reference.setFocusTraversalKeysEnabled(false);
        if(evt.getKeyCode() == KeyEvent.VK_TAB)
             gstNumber.requestFocus();
    }//GEN-LAST:event_referenceKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextArea address;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField availableCash;
    private javax.swing.JComboBox<String> bank;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField challan;
    private javax.swing.JTextField cheque;
    private com.toedter.calendar.JDateChooser chequeDate;
    private javax.swing.JTextField contact;
    private javax.swing.JFormattedTextField discount;
    private javax.swing.JTextField finalAmount;
    private javax.swing.JTextField finalAmountPaid;
    private javax.swing.JButton fullPayment;
    private javax.swing.JComboBox<String> gst;
    private javax.swing.JTextField gstAmount;
    private javax.swing.JRadioButton gstNotTaken;
    private javax.swing.JTextField gstNumber;
    private javax.swing.JRadioButton gstTaken;
    private javax.swing.JTextField hsnCode;
    private javax.swing.JComboBox<String> item;
    private javax.swing.JCheckBox jCheckBoxDiscount;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDiscount;
    private javax.swing.JPanel jPanelItem;
    private javax.swing.JPanel jPanelNewVendor;
    private javax.swing.JPanel jPanelPaymentMode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField newItem;
    private javax.swing.JTextField newVendor;
    private javax.swing.JButton partialPayment;
    private javax.swing.JComboBox<String> paymentMode;
    private com.toedter.calendar.JDateChooser purchaseDate;
    private javax.swing.JFormattedTextField quantity;
    private javax.swing.JTextField reference;
    private javax.swing.JTextField registration;
    private javax.swing.JButton remove;
    private javax.swing.JFormattedTextField sellingPrice;
    private javax.swing.JFormattedTextField total;
    private javax.swing.JTextField unitPrice;
    private javax.swing.JComboBox<String> vendorName;
    // End of variables declaration//GEN-END:variables

    private void loadVendor() 
    {
        VendorMaster vendorMaster = new VendorMaster();
        VendorQuery vendorQuery = new VendorQuery();
        
        if(vendorFlag)
            vendorMaster.setName(vendorName.getSelectedItem().toString());
        
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel)vendorName.getModel();
            
        List<VendorMaster> list = vendorQuery.getVendorDetails(vendorMaster);
        if(!(vendorFlag))
        {
            defaultComboBoxModel.removeAllElements();
        
            defaultComboBoxModel.addElement("--Select--");
            defaultComboBoxModel.addElement("Add New");
            defaultComboBoxModel.addElement("N/A");
            for(VendorMaster vm: list)
                defaultComboBoxModel.addElement(vm.getName());
        }
        else
        {
            for(VendorMaster vm: list)
            {
                vendorName.setSelectedItem(vm.getName());
                address.setText(vm.getAddress());
                contact.setText(vm.getContact());
                registration.setText(vm.getRegistration());
                gstNumber.setText(vm.getGstNumber());
            }      
        }
        vendorName.setModel(defaultComboBoxModel);
    }

    private void loadItem() 
    {
        ItemMaster itemMaster = new ItemMaster();
        ItemQuery itemQuery = new ItemQuery();
        
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel)item.getModel();
        defaultComboBoxModel.removeAllElements();
        
        defaultComboBoxModel.addElement("--Select--");
        defaultComboBoxModel.addElement("Add New");
        
        List<String> list = itemQuery.getDistinctItem();
        
        for(String string: list)
            defaultComboBoxModel.addElement(string);
        
        item.setModel(defaultComboBoxModel);
    }

    private void loadBeginningCash() 
    {
        BeginningCashQuery beginningCashQuery = new BeginningCashQuery();
        
        List<BigDecimal> list = beginningCashQuery.getBeginningCash();
        
        for(BigDecimal bd: list)
            beginningCash = bd;
    }

    private void loadExpenses() 
    {
        ExpensesQuery expensesQuery = new ExpensesQuery();
        
        List<BigDecimal> list = expensesQuery.getExpenses();
        
        for(BigDecimal bd: list)
            expenses = bd;
    }

    private void loadCash() 
    {
        availableCash.setText(String.valueOf(beginningCash.subtract(expenses)));
    }

    private void addToTable() 
    {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String itemName = item.getSelectedItem().toString();
        
        if(itemName.equalsIgnoreCase("--select--"))
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select an Item"), "Error Message", JOptionPane.ERROR_MESSAGE);
            item.requestFocus();
            return;
        }
        if(itemName.equalsIgnoreCase("add new"))
        {
            if(newItem.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the name of the Item"), "Error Message", JOptionPane.ERROR_MESSAGE);
                newItem.requestFocus();
                return;
            }
            else
                itemName = newItem.getText().trim();
        }
        if(quantity.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Quantity"), "Error Message", JOptionPane.ERROR_MESSAGE);
            quantity.requestFocus();
            return;
        }
        if(total.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Total"), "Error Message", JOptionPane.ERROR_MESSAGE);
            total.requestFocus();
            return;
        }
        
        DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();

        String hsnCode = this.hsnCode.getText().trim();
        float quantity = Float.parseFloat(this.quantity.getText().trim());
        float gstPercent = Float.parseFloat(gst.getSelectedItem().toString());
        float total = Float.parseFloat(this.total.getText().trim());
        float sellingPrice;
        float sellingGstPercent;
        float sellingGstAmount;
        float finalSellingPrice;
        String remarks = "";
     
        sellingPrice = Float.parseFloat(this.sellingPrice.getText().trim());
        if(gstTaken.isSelected())
        {
            remarks = "GST Taken";
            sellingGstPercent = Float.parseFloat(this.gst.getSelectedItem().toString());
        }
        else
        {
            remarks = "GST Not Taken";
            sellingGstPercent = 0;
        }
        
        sellingGstAmount = calculateGst(sellingPrice, sellingGstPercent);
        finalSellingPrice = sellingPrice + sellingGstAmount;
  
        float unitPrice = getUnitPrice(total, quantity);
        float gstAmount = calculateGst(total, gstPercent);
        float finalTotal = total + gstAmount;
        
        
        defaultTableModel.addRow(new Object[]{itemName, hsnCode, quantity, total, decimalFormat.format(unitPrice), decimalFormat.format(gstPercent), decimalFormat.format(gstAmount), decimalFormat.format(finalTotal), decimalFormat.format(sellingPrice), decimalFormat.format(sellingGstPercent), decimalFormat.format(sellingGstAmount), decimalFormat.format(finalSellingPrice), remarks});
        
        jTable1.setModel(defaultTableModel);
        
        getTotal();
        
        clear();
        item.requestFocus();
    }
    
    private float calculateGst(float total, float gstPercent)
    {
        float gstAmount = (total * gstPercent ) /100;      
        return gstAmount;
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
    
    private void clear()
    {
        quantity.setText("0.00");
        total.setText("0.00");
        unitPrice.setText("0.00");
        item.setSelectedIndex(0);
        gst.setSelectedIndex(0);
        sellingPrice.setText("0.00");
        finalAmount.setText("0.00");
        jCheckBoxDiscount.setSelected(false);
        discount.setText("0.00");
        finalAmountPaid.setText("0.00");
        jPanelDiscount.setVisible(false);
        hsnCode.setText("N/A");
    }
    
    private void getTotal()
    {
        int index = jTable1.getRowCount();
        int i = 0;
        float sum = 0;
        
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        
        while(i < index)
        {
            sum = sum + Float.parseFloat(jTable1.getValueAt(i, 7).toString());
            i++;
        }
        
        amount.setText(decimalFormat.format(sum));
    }

    private void fullPayment() 
    { 
        try
        {
            boolean flag = false;
            String bankName = bank.getSelectedItem().toString();
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
            if(vendorName.equalsIgnoreCase("add new"))
            {
                if(newVendor.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Vendor Name"), "Error message", JOptionPane.ERROR_MESSAGE);
                    newVendor.requestFocus();
                    return;
                }
                vendorName = newVendor.getText().trim();
                newVendorFlag = true;
            }
            
            String paymentMode = this.paymentMode.getSelectedItem().toString();

            Date purchaseDate = this.purchaseDate.getDate();
            Date chequeDate = this.chequeDate.getDate();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if(paymentMode.equalsIgnoreCase("--select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the payment mode"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.paymentMode.requestFocus();
                return;
            }
            if(paymentMode.equalsIgnoreCase("card"))
            {
                if(cheque.getText().trim().isEmpty())
                { 
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Card number"), "Error message", JOptionPane.ERROR_MESSAGE);
                    cheque.requestFocus();
                    return;
                }
                chequeNumber = cheque.getText().trim();
            }
            if(paymentMode.equalsIgnoreCase("cheque") || paymentMode.equalsIgnoreCase("neft"))
            {
                if(cheque.getText().trim().isEmpty())
                { 
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Cheque/NEFT number"), "Error message", JOptionPane.ERROR_MESSAGE);
                    cheque.requestFocus();
                    return;
                }

                String stringChequeDate = dateFormat.format(chequeDate);        
                String stringPurchaseDate = dateFormat.format(purchaseDate);

                try
                {
                    chequeDate = dateFormat.parse(stringChequeDate);
                    purchaseDate = dateFormat.parse(stringPurchaseDate);

                    if(chequeDate.compareTo(purchaseDate) < 0)
                    {
                        JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Cheque Date can't be ahead of Purchase Date"), "Error message", JOptionPane.ERROR_MESSAGE);
                        cheque.requestFocus();
                        return;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }   

                chequeNumber = cheque.getText().trim();
                vendorPartialPayment.setChequeDate(chequeDate);
            }
            if(paymentMode.equalsIgnoreCase("cash"))
            {
                int compare = new BigDecimal(availableCash.getText().trim()).compareTo(new BigDecimal(amount.getText().trim()));

                if(compare == -1)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Insufficient Funds!!!\nPlease pay by cheque or go for Partial Payment"), "Error message", JOptionPane.ERROR_MESSAGE);
                    this.paymentMode.requestFocus();
                    return;
                }

                bankName = "N/A";
                chequeNumber = "N/A";
            }
            if(paymentMode.equalsIgnoreCase("card"))
            {
                int compare = new BigDecimal(availableCash.getText().trim()).compareTo(new BigDecimal(amount.getText().trim()));

                if(compare == -1)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Insufficient Funds!!!\nPlease pay by cheque or go for Partial Payment"), "Error message", JOptionPane.ERROR_MESSAGE);
                    this.paymentMode.requestFocus();
                    return;
                }

                bankName = bank.getSelectedItem().toString();
                chequeNumber = cheque.getText().trim();
            }
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
                newVendor.requestFocus();
                newVendorFlag = false;
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(null, MessageFormat.getMessage("Are you sure of making this Purchase?"));
            
            if(confirm == JOptionPane.YES_OPTION)
            {
                BigDecimal balance;
                String status = "";
                
                if(paymentMode.equalsIgnoreCase("cash") || paymentMode.equalsIgnoreCase("card"))
                {
                    balance = new BigDecimal(0);
                    status = "1";
                }
                else
                {
                    balance = new BigDecimal(amount.getText()).subtract(new BigDecimal(discount.getText()));
                    status = "0";
                }
                
                vendorMaster.setRegistration(registration.getText().trim());
                vendorMaster.setContact(contact.getText().trim());
                vendorMaster.setAddress(address.getText().trim());
                vendorMaster.setBalance(balance);
                vendorMaster.setGstNumber(gstNumber.getText().trim());

                if(list.isEmpty())
                    vendorQuery.insertVendor(vendorMaster);        
                else
                {
                    for(VendorMaster vm: list)
                    {
                        vendorMaster.setId(vm.getId());
                        vendorMaster.setBalance(vm.getBalance().add(balance));
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
                vendorBillMaster.setChallan(challan.getText().trim());
                vendorBillMaster.setBillAmount(new BigDecimal(amount.getText().trim()));
                vendorBillMaster.setDiscount(new BigDecimal(discount.getText()));
                vendorBillMaster.setFinalBillAmount(new BigDecimal(amount.getText()).subtract(new BigDecimal(discount.getText())));
                vendorBillMaster.setRemark("GST Not Taken");
                vendorBillMaster.setReference(reference.getText().trim());
                
                vendorBillMasterQuery.insertIntoVendorBillMaster(vendorBillMaster);

                vendorPartialPayment.setDate(purchaseDate);
                vendorPartialPayment.setVendorMaster(vendorMaster);
                vendorPartialPayment.setPaidAmount(new BigDecimal(amount.getText().trim()).subtract(new BigDecimal(discount.getText())));
                vendorPartialPayment.setPaymentMode(paymentMode);
                vendorPartialPayment.setChequeCardNumber(chequeNumber);
                vendorPartialPayment.setBank(bankName);
                vendorPartialPayment.setStatus(status);

                VendorPartialPaymentQuery vendorPartialPaymentQuery = new VendorPartialPaymentQuery();
                vendorPartialPaymentQuery.insertIntoVendorPartialPayment(vendorPartialPayment);

                ItemMaster itemMaster = new ItemMaster();
                ItemAvailability itemAvailability = new ItemAvailability();
                StockDetails stockDetails = new StockDetails();

                ItemQuery itemQuery = new ItemQuery();
                StockDetailsQuery stockDetailsQuery = new StockDetailsQuery();
                ItemAvailabilityQuery itemAvailabilityQuery = new ItemAvailabilityQuery();
                
                String itemName = "";
                String hsnCode = "";
                BigDecimal quantity;
                BigDecimal total;
                BigDecimal unitPrice;
                BigDecimal gstPercent;
                BigDecimal gstAmount;                
                BigDecimal finalTotal;
                BigDecimal sellingPrice;
                BigDecimal sellingGstPercent;
                BigDecimal sellingGstAmount;
                BigDecimal finalSellingPrice;
                String remark = "";

                int i = 0;
                int count = 0;

                while(i < jTable1.getRowCount())
                {
                    itemName = jTable1.getValueAt(i, 0).toString();
                    hsnCode = jTable1.getValueAt(i, 1).toString();
                    quantity = new BigDecimal(jTable1.getValueAt(i, 2).toString());
                    total = new BigDecimal(jTable1.getValueAt(i, 3).toString());
                    unitPrice = new BigDecimal(jTable1.getValueAt(i, 4).toString());
                    gstPercent = new BigDecimal(jTable1.getValueAt(i, 5).toString());
                    gstAmount = new BigDecimal(jTable1.getValueAt(i, 6).toString());
                    finalTotal = new BigDecimal(jTable1.getValueAt(i, 7).toString());
                    sellingPrice = new BigDecimal(jTable1.getValueAt(i, 8).toString());
                    sellingGstPercent = new BigDecimal(jTable1.getValueAt(i, 9).toString());
                    sellingGstAmount = new BigDecimal(jTable1.getValueAt(i, 10).toString());
                    finalSellingPrice = new BigDecimal(jTable1.getValueAt(i, 11).toString());
                    remark = jTable1.getValueAt(i, 12).toString();
                    
                    if(!(flag))
                        if(remark.equalsIgnoreCase("gst taken"))
                        {
                            flag = true;
                            vendorBillMaster.setRemark("GST Taken");
                        }
                    itemMaster.setName(itemName);
                    itemMaster.setHsnCode(hsnCode);
                    itemMaster.setUnitPrice(unitPrice);
                    itemMaster.setGstPercent(gstPercent);
                    itemMaster.setSellingGstPercent(sellingGstPercent);
                    itemMaster.setSellingPrice(sellingPrice);
                    itemMaster.setFinalSellingPrice(finalSellingPrice);

                    List<ItemMaster> itemList = itemQuery.checkItem(itemMaster);
                    if(itemList.isEmpty())
                        itemQuery.insertItem(itemMaster);
                    else
                    {
                        for(ItemMaster im: itemList)
                            itemMaster.setId(im.getId());
                    }

                    stockDetails.setVendorBillMaster(vendorBillMaster);
                    stockDetails.setItemMaster(itemMaster);
                    stockDetails.setQuantity(quantity);
                    stockDetails.setUnitPrice(unitPrice);
                    stockDetails.setGstPercent(gstPercent);
                    stockDetails.setGstAmount(gstAmount);
                    stockDetails.setFinalTotal(finalTotal);

                    stockDetailsQuery.insertIntoStockDetails(stockDetails);
                    
                    BigDecimal thresholdPercent = new BigDecimal(0.25);
                    
                    itemAvailability.setItemMaster(itemMaster);
                    itemAvailability.setAvailability(quantity);
                    itemAvailability.setThreshold(thresholdPercent.multiply(quantity));
                    
                    List<ItemAvailability> itemAvailabilityList = itemAvailabilityQuery.checkItem(itemAvailability);
                    
                    if(itemAvailabilityList.isEmpty())
                        itemAvailabilityQuery.insertIntoItemAvailability(itemAvailability);
                    else
                    {
                        for(ItemAvailability ia: itemAvailabilityList)
                        {
                            itemAvailability.setId(ia.getId());
                            itemAvailability.setAvailability(ia.getAvailability().add(quantity));
                            itemAvailability.setThreshold(thresholdPercent.multiply(ia.getAvailability().add(quantity)));
                            
                            itemAvailabilityQuery.updateItemAvailability(itemAvailability);
                        }
                    }
                    i++;
                } 

                if(paymentMode.equalsIgnoreCase("cash") || paymentMode.equalsIgnoreCase("card"))
                {                   
                    expenses.setDate(purchaseDate);
                    expenses.setAmount(new BigDecimal(amount.getText().trim()).subtract(new BigDecimal(discount.getText())));
                    expenses.setRemark("Stock Purchased with bill Id: " + vendorBillMaster.getId());

                    expensesQuery.insertIntoExpenses(expenses);
                }
                if(flag)
                    vendorBillMasterQuery.updateVendorBillMaster(vendorBillMaster);
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Stock added successfully"));

                DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
                defaultTableModel.setRowCount(0);
                jTable1.setModel(defaultTableModel);
                getTotal();
                clear();

                jPanelPaymentMode.setVisible(false);
                this.paymentMode.setSelectedIndex(0);
                bank.setSelectedIndex(0);

                jPanelNewVendor.setVisible(false);
                jPanelItem.setVisible(false);
                challan.setText("N/A");
                loadVendor();
                loadItem();
                loadBeginningCash();
                loadExpenses();
                loadCash();
                this.vendorName.setSelectedIndex(0);
                printBill(vendorBillMaster, flag);  
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Stock Details failed to save"), "Error Mesage", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void partialPayment() 
    {
        boolean newVendorFlag = false;
        boolean newDiscount = false;
        
        float finalAmount = Float.parseFloat(amount.getText());
        VendorMaster vendorMaster = new VendorMaster();
        VendorPartialPayment vendorPartialPayment = new VendorPartialPayment();
        
        if(jTable1.getRowCount() == 0)
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Nothing to save"), "Error Message", JOptionPane.ERROR_MESSAGE);
        else
        {
            String chequeNumber = "";
            String vendorName = this.vendorName.getSelectedItem().toString();

            if(vendorName.equalsIgnoreCase("--select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select a vendor"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.vendorName.requestFocus();
                return;
            }
            if(vendorName.equalsIgnoreCase("add new"))
            {
                if(newVendor.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Vendor Name"), "Error message", JOptionPane.ERROR_MESSAGE);
                    newVendor.requestFocus();
                    return;
                }
                vendorName = newVendor.getText().trim();
                newVendorFlag = true;
            }
            
            vendorMaster.setName(vendorName);
            vendorMaster.setRegistration(registration.getText().trim());
            vendorMaster.setContact(contact.getText().trim());
            vendorMaster.setAddress(address.getText().trim());
            vendorMaster.setGstNumber(gstNumber.getText().trim());
            
            String paymentMode = this.paymentMode.getSelectedItem().toString();

            Date purchaseDate = this.purchaseDate.getDate();
            Date chequeDate = this.chequeDate.getDate();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if(paymentMode.equalsIgnoreCase("--select--"))
            {
                JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the payment mode"), "Error message", JOptionPane.ERROR_MESSAGE);
                this.paymentMode.requestFocus();
                return;
            }
            if(paymentMode.equalsIgnoreCase("cheque") || paymentMode.equalsIgnoreCase("neft") || paymentMode.equalsIgnoreCase("card"))
            {
                if(cheque.getText().trim().isEmpty())
                { 
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the Card/Cheque/NEFT number"), "Error message", JOptionPane.ERROR_MESSAGE);
                    cheque.requestFocus();
                    return;
                }

                String stringChequeDate = dateFormat.format(chequeDate);        
                String stringPurchaseDate = dateFormat.format(purchaseDate);

                try
                {
                    chequeDate = dateFormat.parse(stringChequeDate);
                    purchaseDate = dateFormat.parse(stringPurchaseDate);

                    if(chequeDate.compareTo(purchaseDate) < 0)
                    {
                        JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Cheque Date can't be ahead of Purchase Date"), "Error message", JOptionPane.ERROR_MESSAGE);
                        cheque.requestFocus();
                        return;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }   
                vendorPartialPayment.setChequeCardNumber(cheque.getText().trim());              
                vendorPartialPayment.setBank(bank.getSelectedItem().toString());
                
                if(!(paymentMode.equalsIgnoreCase("card")))
                    vendorPartialPayment.setChequeDate(chequeDate);
            }
            else
            {
                vendorPartialPayment.setChequeCardNumber("N/A");
                vendorPartialPayment.setBank("N/A");
            }
            vendorPartialPayment.setDate(purchaseDate);
            vendorPartialPayment.setPaymentMode(paymentMode);
            
            if(jCheckBoxDiscount.isSelected())
            {
                if(discount.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please enter the discount"), "Error message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                if(Float.parseFloat(discount.getText().trim()) == 0)
                {
                    JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Discount can't be zero"), "Error message", JOptionPane.ERROR_MESSAGE);
                    discount.requestFocus();
                    return;
                }
                
                newDiscount = true;
                finalAmount = Float.parseFloat(finalAmountPaid.getText().trim());
            }
            
            DefaultTableModel defaultTableModel = (DefaultTableModel)jTable1.getModel();
            
            PartialPaymentView partialPaymentView = new PartialPaymentView(defaultTableModel, jDesktopPane, vendorMaster, vendorPartialPayment, newVendorFlag, challan.getText().trim(), newDiscount, Float.parseFloat(discount.getText().trim()), finalAmount, reference.getText().trim());
            partialPaymentView.setTitle("Partial Payment");
            jDesktopPane.add(partialPaymentView);
            SetDimension setDimension = new SetDimension();
            setDimension.setInternalFrameLocation(jDesktopPane, partialPaymentView);
            partialPaymentView.setVisible(true);
            
            dispose();
        }
    }

    
    private void printBill(VendorBillMaster vendorBillMaster, boolean flag) 
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String joinQuery =  "SELECT\n" +
                            "     vendor_master.`Id` AS vendor_master_Id,\n" +
                            "     vendor_master.`name` AS vendor_master_name,\n" +
                            "     vendor_master.`contact` AS vendor_master_contact,\n" +
                            "     vendor_master.`address` AS vendor_master_address,\n" +
                            "     vendor_master.`registration` AS vendor_master_registration,\n" +
                            "     vendor_master.`balance` AS vendor_master_balance,\n" +
                            "     vendor_master.`gstNumber` AS gstNumber,\n" +
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
                            "     store_details.`photo` AS store_details_photo,\n" +
                            "     stock_details.`Id` AS stock_details_Id,\n" +
                            "     stock_details.`billId` AS stock_details_billId,\n" +
                            "     stock_details.`itemId` AS stock_details_itemId,\n" +
                            "     stock_details.`quantity` AS stock_details_quantity,\n" +
                            "     stock_details.`unitPrice` AS stock_details_unitPrice,\n" +
                            "     stock_details.`gstPercent` AS stock_details_gstPercent,\n" +
                            "     stock_details.`gstAmount` AS stock_details_gstAmount,\n" +
                            "     stock_details.`finalTotal` AS stock_details_finalTotal,\n" +
                            "     item_master.`Id` AS item_master_Id,\n" +
                            "     item_master.`name` AS item_master_name,\n" +
                            "     item_master.`unitPrice` AS item_master_unitPrice,\n" +
                            "     item_master.`gstPercent` AS item_master_gstPercent,\n" +
                            "     item_master.`sellingPrice` AS item_master_sellingPrice,\n" +
                            "     item_master.`sellingGstPercent` AS item_master_sellingGstPercent,\n" +
                            "     item_master.`finalSellingPrice` AS item_master_finalSellingPrice,\n" +
                            "     item_master.`hsnCode` AS item_master_hsnCode \n" +
                            "FROM\n" +
                            "     `vendor_master` vendor_master INNER JOIN `vendor_bill_master` vendor_bill_master ON vendor_master.`Id` = vendor_bill_master.`vendorId`\n" +
                            "     INNER JOIN `store_details` store_details ON vendor_bill_master.`storeId` = store_details.`Id`\n" +
                            "     INNER JOIN `stock_details` stock_details ON vendor_bill_master.`Id` = stock_details.`billId`\n" +
                            "     INNER JOIN `item_master` item_master ON stock_details.`itemId` = item_master.`Id` \n" +
                            "WHERE vendor_bill_master.id = " + vendorBillMaster.getId();

        try
        {
            connection = MyConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(joinQuery);
            
            String reportSource = ""; 
            
        
               reportSource = ReadFile.getPath() + "Reports\\GstPurchaseDetails.jrxml";
            
            
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

    private void remove() 
    {
        try
        {
            DefaultTableModel defaultTableModel= (DefaultTableModel)jTable1.getModel();  
            defaultTableModel.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(defaultTableModel);
            getTotal();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, MessageFormat.getMessage("Please select the row you want to remove"), "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFinalAmountPaid(String discount) 
    {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        finalAmountPaid.setText(decimalFormat.format(Float.parseFloat(amount.getText()) - Float.parseFloat(discount)));
    }
   
}
