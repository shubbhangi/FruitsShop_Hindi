package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * BeginningCash generated by hbm2java
 */
public class BeginningCash  implements java.io.Serializable {


     private Integer id;
     private Date date;
     private BigDecimal amount;
     private String newField;

    public BeginningCash() {
    }

    public BeginningCash(Date date, BigDecimal amount, String newField) {
       this.date = date;
       this.amount = amount;
       this.newField = newField;
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
    public String getNewField() {
        return this.newField;
    }
    
    public void setNewField(String newField) {
        this.newField = newField;
    }




}


