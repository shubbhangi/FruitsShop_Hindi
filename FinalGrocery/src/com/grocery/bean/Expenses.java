package com.grocery.bean;
// Generated Mar 27, 2018 12:20:04 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Expenses generated by hbm2java
 */
public class Expenses  implements java.io.Serializable {


     private Integer id;
     private Date date;
     private BigDecimal amount;
     private String remark;

    public Expenses() {
    }

    public Expenses(Date date, BigDecimal amount, String remark) {
       this.date = date;
       this.amount = amount;
       this.remark = remark;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }




}


