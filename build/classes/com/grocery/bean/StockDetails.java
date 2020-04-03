package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * StockDetails generated by hbm2java
 */
public class StockDetails  implements java.io.Serializable {


     private Integer id;
     private ItemMaster itemMaster;
     private VendorBillMaster vendorBillMaster;
     private BigDecimal quantity;
     private BigDecimal unitPrice;
     private BigDecimal gstPercent;
     private BigDecimal gstAmount;
     private BigDecimal finalTotal;
     private BigDecimal igstPercent;
     private BigDecimal igstAmount;
     private BigDecimal discount;

    public StockDetails() {
    }

    public StockDetails(ItemMaster itemMaster, VendorBillMaster vendorBillMaster, BigDecimal quantity, BigDecimal unitPrice, BigDecimal gstPercent, BigDecimal gstAmount, BigDecimal finalTotal, BigDecimal igstPercent, BigDecimal igstAmount, BigDecimal discount) {
       this.itemMaster = itemMaster;
       this.vendorBillMaster = vendorBillMaster;
       this.quantity = quantity;
       this.unitPrice = unitPrice;
       this.gstPercent = gstPercent;
       this.gstAmount = gstAmount;
       this.finalTotal = finalTotal;
       this.igstPercent = igstPercent;
       this.igstAmount = igstAmount;
       this.discount = discount;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public ItemMaster getItemMaster() {
        return this.itemMaster;
    }
    
    public void setItemMaster(ItemMaster itemMaster) {
        this.itemMaster = itemMaster;
    }
    public VendorBillMaster getVendorBillMaster() {
        return this.vendorBillMaster;
    }
    
    public void setVendorBillMaster(VendorBillMaster vendorBillMaster) {
        this.vendorBillMaster = vendorBillMaster;
    }
    public BigDecimal getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public BigDecimal getGstPercent() {
        return this.gstPercent;
    }
    
    public void setGstPercent(BigDecimal gstPercent) {
        this.gstPercent = gstPercent;
    }
    public BigDecimal getGstAmount() {
        return this.gstAmount;
    }
    
    public void setGstAmount(BigDecimal gstAmount) {
        this.gstAmount = gstAmount;
    }
    public BigDecimal getFinalTotal() {
        return this.finalTotal;
    }
    
    public void setFinalTotal(BigDecimal finalTotal) {
        this.finalTotal = finalTotal;
    }
    public BigDecimal getIgstPercent() {
        return this.igstPercent;
    }
    
    public void setIgstPercent(BigDecimal igstPercent) {
        this.igstPercent = igstPercent;
    }
    public BigDecimal getIgstAmount() {
        return this.igstAmount;
    }
    
    public void setIgstAmount(BigDecimal igstAmount) {
        this.igstAmount = igstAmount;
    }
    public BigDecimal getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }




}

