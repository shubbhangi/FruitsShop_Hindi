package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemMaster generated by hbm2java
 */
public class ItemMaster  implements java.io.Serializable {

private Integer id;
     private PurchaseMaster purchaseMaster;
     private String name;
     private String brand;
     private String barCode;
     private BigDecimal weight;
     private String unit;
     private BigDecimal unitPrice;
     private BigDecimal quantity;
     private BigDecimal totalAmount;
     private Date efgDate;
     private Date expDate;
     private BigDecimal gstPercent;
     private BigDecimal sellingPrice;
     private BigDecimal sellingGstPercent;
     private BigDecimal finalSellingPrice;
     private String gstType;
     private BigDecimal igstPercent;
     private Integer isDeleted;
     private Set itemAvailabilities = new HashSet(0);
     private Set saleDetailses = new HashSet(0);
     private Set saleReturnDetailses = new HashSet(0);
     private Set purchaseReturnDetailses = new HashSet(0);

    public ItemMaster() {
    }

    public ItemMaster(PurchaseMaster purchaseMaster, String name, String brand, String barCode, BigDecimal weight, String unit, BigDecimal unitPrice, BigDecimal quantity, BigDecimal totalAmount, Date efgDate, Date expDate, BigDecimal gstPercent, BigDecimal sellingPrice, BigDecimal sellingGstPercent, BigDecimal finalSellingPrice, String gstType, BigDecimal igstPercent, Integer isDeleted, Set itemAvailabilities, Set saleDetailses, Set saleReturnDetailses, Set purchaseReturnDetailses) {
       this.purchaseMaster = purchaseMaster;
       this.name = name;
       this.brand = brand;
       this.barCode = barCode;
       this.weight = weight;
       this.unit = unit;
       this.unitPrice = unitPrice;
       this.quantity = quantity;
       this.totalAmount = totalAmount;
       this.efgDate = efgDate;
       this.expDate = expDate;
       this.gstPercent = gstPercent;
       this.sellingPrice = sellingPrice;
       this.sellingGstPercent = sellingGstPercent;
       this.finalSellingPrice = finalSellingPrice;
       this.gstType = gstType;
       this.igstPercent = igstPercent;
       this.isDeleted = isDeleted;
       this.itemAvailabilities = itemAvailabilities;
       this.saleDetailses = saleDetailses;
       this.saleReturnDetailses = saleReturnDetailses;
       this.purchaseReturnDetailses = purchaseReturnDetailses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public PurchaseMaster getPurchaseMaster() {
        return this.purchaseMaster;
    }
    
    public void setPurchaseMaster(PurchaseMaster purchaseMaster) {
        this.purchaseMaster = purchaseMaster;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBarCode() {
        return this.barCode;
    }
    
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public BigDecimal getWeight() {
        return this.weight;
    }
    
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public BigDecimal getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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
    public BigDecimal getGstPercent() {
        return this.gstPercent;
    }
    
    public void setGstPercent(BigDecimal gstPercent) {
        this.gstPercent = gstPercent;
    }
    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }
    
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public BigDecimal getSellingGstPercent() {
        return this.sellingGstPercent;
    }
    
    public void setSellingGstPercent(BigDecimal sellingGstPercent) {
        this.sellingGstPercent = sellingGstPercent;
    }
    public BigDecimal getFinalSellingPrice() {
        return this.finalSellingPrice;
    }
    
    public void setFinalSellingPrice(BigDecimal finalSellingPrice) {
        this.finalSellingPrice = finalSellingPrice;
    }
    public String getGstType() {
        return this.gstType;
    }
    
    public void setGstType(String gstType) {
        this.gstType = gstType;
    }
    public BigDecimal getIgstPercent() {
        return this.igstPercent;
    }
    
    public void setIgstPercent(BigDecimal igstPercent) {
        this.igstPercent = igstPercent;
    }
    public Integer getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Set getItemAvailabilities() {
        return this.itemAvailabilities;
    }
    
    public void setItemAvailabilities(Set itemAvailabilities) {
        this.itemAvailabilities = itemAvailabilities;
    }
    public Set getSaleDetailses() {
        return this.saleDetailses;
    }
    
    public void setSaleDetailses(Set saleDetailses) {
        this.saleDetailses = saleDetailses;
    }
    public Set getSaleReturnDetailses() {
        return this.saleReturnDetailses;
    }
    
    public void setSaleReturnDetailses(Set saleReturnDetailses) {
        this.saleReturnDetailses = saleReturnDetailses;
    }
    public Set getPurchaseReturnDetailses() {
        return this.purchaseReturnDetailses;
    }
    
    public void setPurchaseReturnDetailses(Set purchaseReturnDetailses) {
        this.purchaseReturnDetailses = purchaseReturnDetailses;
    }

}


