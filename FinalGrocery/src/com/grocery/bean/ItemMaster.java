package com.grocery.bean;
// Generated Mar 27, 2018 12:20:04 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemMaster generated by hbm2java
 */
public class ItemMaster  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String hsnCode;
     private BigDecimal unitPrice;
     private BigDecimal gstPercent;
     private BigDecimal sellingPrice;
     private BigDecimal sellingGstPercent;
     private BigDecimal finalSellingPrice;
     private Set itemAvailabilities = new HashSet(0);
     private Set saleDetailses = new HashSet(0);
     private Set stockDetailses = new HashSet(0);
     private Set saleReturnDetailses = new HashSet(0);
     private Set purchaseReturnDetailses = new HashSet(0);

    public ItemMaster() {
    }

    public ItemMaster(String name, String hsnCode, BigDecimal unitPrice, BigDecimal gstPercent, BigDecimal sellingPrice, BigDecimal sellingGstPercent, BigDecimal finalSellingPrice, Set itemAvailabilities, Set saleDetailses, Set stockDetailses, Set saleReturnDetailses, Set purchaseReturnDetailses) {
       this.name = name;
       this.hsnCode = hsnCode;
       this.unitPrice = unitPrice;
       this.gstPercent = gstPercent;
       this.sellingPrice = sellingPrice;
       this.sellingGstPercent = sellingGstPercent;
       this.finalSellingPrice = finalSellingPrice;
       this.itemAvailabilities = itemAvailabilities;
       this.saleDetailses = saleDetailses;
       this.stockDetailses = stockDetailses;
       this.saleReturnDetailses = saleReturnDetailses;
       this.purchaseReturnDetailses = purchaseReturnDetailses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public Set getStockDetailses() {
        return this.stockDetailses;
    }
    
    public void setStockDetailses(Set stockDetailses) {
        this.stockDetailses = stockDetailses;
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

    /**
     * @return the hsnCode
     */
    public String getHsnCode() {
        return hsnCode;
    }

    /**
     * @param hsnCode the hsnCode to set
     */
    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }




}

