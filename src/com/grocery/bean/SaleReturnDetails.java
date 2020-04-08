package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SaleReturnDetails generated by hbm2java
 */
public class SaleReturnDetails  implements java.io.Serializable {


     private Integer id;
     private ItemMaster itemMaster;
     private SaleReturn saleReturn;
     private BigDecimal quantity;
     private BigDecimal unitPrice;
     private BigDecimal gstPercent;
     private BigDecimal gstAmount;
     private BigDecimal finalTotal;
     private Date efgDate;
     private Date expDate;

    public SaleReturnDetails() {
    }

    public SaleReturnDetails(ItemMaster itemMaster, SaleReturn saleReturn, BigDecimal quantity, BigDecimal unitPrice, BigDecimal gstPercent, BigDecimal gstAmount, BigDecimal finalTotal, Date efgDate, Date expDate) {
       this.itemMaster = itemMaster;
       this.saleReturn = saleReturn;
       this.quantity = quantity;
       this.unitPrice = unitPrice;
       this.gstPercent = gstPercent;
       this.gstAmount = gstAmount;
       this.finalTotal = finalTotal;
       this.efgDate = efgDate;
       this.expDate = expDate;
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
    public SaleReturn getSaleReturn() {
        return this.saleReturn;
    }
    
    public void setSaleReturn(SaleReturn saleReturn) {
        this.saleReturn = saleReturn;
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
    public Date getEfgDate() {
        return this.efgDate;
    }
    
    public void setEfgDate(Date efgDate) {
        this.efgDate = efgDate;
    }
    public Date getExpDate() {
        return this.expDate;
    }
    
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }




}


