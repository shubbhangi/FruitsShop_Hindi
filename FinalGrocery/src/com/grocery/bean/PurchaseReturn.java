package com.grocery.bean;
// Generated Mar 27, 2018 12:20:04 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PurchaseReturn generated by hbm2java
 */
public class PurchaseReturn  implements java.io.Serializable {


     private Integer id;
     private VendorBillMaster vendorBillMaster;
     private Date date;
     private Date to;
     private BigDecimal amount;
     private Set purchaseReturnDetailses = new HashSet(0);

    public PurchaseReturn() {
    }

    public PurchaseReturn(VendorBillMaster vendorBillMaster, Date date, BigDecimal amount, Set purchaseReturnDetailses) {
       this.vendorBillMaster = vendorBillMaster;
       this.date = date;
       this.amount = amount;
       this.purchaseReturnDetailses = purchaseReturnDetailses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public VendorBillMaster getVendorBillMaster() {
        return this.vendorBillMaster;
    }
    
    public void setVendorBillMaster(VendorBillMaster vendorBillMaster) {
        this.vendorBillMaster = vendorBillMaster;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Set getPurchaseReturnDetailses() {
        return this.purchaseReturnDetailses;
    }
    
    public void setPurchaseReturnDetailses(Set purchaseReturnDetailses) {
        this.purchaseReturnDetailses = purchaseReturnDetailses;
    }

    /**
     * @return the to
     */
    public Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Date to) {
        this.to = to;
    }




}

