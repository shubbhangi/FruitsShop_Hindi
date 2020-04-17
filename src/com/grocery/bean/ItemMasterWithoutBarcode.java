package com.grocery.bean;
// Generated Apr 4, 2020 10:49:19 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * ItemMasterWithoutBarcode generated by hbm2java
 */
public class ItemMasterWithoutBarcode  implements java.io.Serializable {


     private Integer id;
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
     private Integer isDeleted;

    public ItemMasterWithoutBarcode() {
    }

    public ItemMasterWithoutBarcode(Integer id, String name, String brand, String barCode, BigDecimal weight, String unit, BigDecimal unitPrice, BigDecimal quantity, BigDecimal totalAmount, Date efgDate, Date expDate, Integer isDeleted) {
        this.id = id;
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
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getEfgDate() {
        return efgDate;
    }

    public void setEfgDate(Date efgDate) {
        this.efgDate = efgDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

   
}


