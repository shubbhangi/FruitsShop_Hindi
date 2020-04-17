package com.grocery.bean;
// Generated Mar 27, 2018 12:20:04 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * PurchaseReturnDetails generated by hbm2java
 */
public class PurchaseReturnDetails  implements java.io.Serializable {


     private Integer id;
     private ItemMaster itemMaster;
     private PurchaseReturn purchaseReturn;
     private BigDecimal quantity;
     private BigDecimal unitPrice;
     private BigDecimal gstPercent;
     private BigDecimal gstAmount;
     private BigDecimal finalTotal;

    public PurchaseReturnDetails() {
    }

    public PurchaseReturnDetails(ItemMaster itemMaster, PurchaseReturn purchaseReturn, BigDecimal quantity, BigDecimal unitPrice, BigDecimal gstPercent, BigDecimal gstAmount, BigDecimal finalTotal) {
       this.itemMaster = itemMaster;
       this.purchaseReturn = purchaseReturn;
       this.quantity = quantity;
       this.unitPrice = unitPrice;
       this.gstPercent = gstPercent;
       this.gstAmount = gstAmount;
       this.finalTotal = finalTotal;
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
    public PurchaseReturn getPurchaseReturn() {
        return this.purchaseReturn;
    }
    
    public void setPurchaseReturn(PurchaseReturn purchaseReturn) {
        this.purchaseReturn = purchaseReturn;
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




}


