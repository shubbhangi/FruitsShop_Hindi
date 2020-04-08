/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author RUPIN GUPTA
 */
public class GSTTaxInput extends JFrame{
    
    JTextField textField;
    JButton okButton;
    JButton cancelButton;
    JRadioButton nonGSTButton;
    JRadioButton GSTButton;
    JRadioButton IGSTButton;
  //  JLabel availableQnty;
   private String taxType = "";
   private float soldQuantity = 0f;
   private String inputQuantity ="";
   private String slectedTaxType = "";
    GSTTaxInput(String availableQnty){
        textField = new JTextField(15);
        okButton = new JButton("OK");
        cancelButton = new JButton("CANCEL");
        nonGSTButton = new JRadioButton("NON-GST");
        GSTButton = new JRadioButton("GST");
        IGSTButton = new JRadioButton("IGST");
        
        JLabel avlQuantityLabel = new JLabel("Available Quantity:");
        this.add(avlQuantityLabel);
        JLabel brackLine1 = new JLabel("<html><br></html>");
        this.add(brackLine1);
        JLabel avlQuantity = new JLabel(availableQnty);
        this.add(avlQuantity);
        this.add(brackLine1);
        JLabel quantityLabel = new JLabel("Please enter the quantity:");
        this.add(quantityLabel);
        add(textField);
        JLabel taxTypeLabel = new JLabel("Select Tax Type:");
        this.add(taxTypeLabel);
        this.add(brackLine1);
        add(nonGSTButton);
        add(GSTButton);
        add(IGSTButton);
        add(okButton);
        add(cancelButton);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(nonGSTButton);
        buttonGroup.add(GSTButton);
        buttonGroup.add(IGSTButton);
        
                
        setLayout(new FlowLayout());
        setTitle("Input");
        setVisible(true);
        setSize(400,200);
    

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GSTButton.isSelected()){
                    slectedTaxType = "GST";
                }else if(IGSTButton.isSelected()){
                    slectedTaxType = "IGST";
                }else{
                    slectedTaxType = "Non-GST";
                }
                inputQuantity = textField.getText();
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.soldQuantity = Float.parseFloat(inputQuantity);
        this.taxType = slectedTaxType;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public float getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(float soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
 
    
}