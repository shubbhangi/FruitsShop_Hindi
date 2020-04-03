package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * CustomerPartialPayment generated by hbm2java
 */
public class CustomerPartialPayment  implements java.io.Serializable {


     private Integer id;
     private CustomerDetails customerDetails;
     private Date date;
     private Date to;
     private BigDecimal paidAmount;
     private String paymentMode;
     private String chequeOrCardNumber;
     private String bank;
     private Date chequeDate;
     private Date chequeClearanceDate;
     private String status;

    public CustomerPartialPayment() {
    }

    public CustomerPartialPayment(Integer id, CustomerDetails customerDetails, Date date, Date to, BigDecimal paidAmount, String paymentMode, String chequeOrCardNumber, String bank, Date chequeDate, Date chequeClearanceDate, String status) {
        this.id = id;
        this.customerDetails = customerDetails;
        this.date = date;
        this.to = to;
        this.paidAmount = paidAmount;
        this.paymentMode = paymentMode;
        this.chequeOrCardNumber = chequeOrCardNumber;
        this.bank = bank;
        this.chequeDate = chequeDate;
        this.chequeClearanceDate = chequeClearanceDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getChequeOrCardNumber() {
        return chequeOrCardNumber;
    }

    public void setChequeOrCardNumber(String chequeOrCardNumber) {
        this.chequeOrCardNumber = chequeOrCardNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public Date getChequeClearanceDate() {
        return chequeClearanceDate;
    }

    public void setChequeClearanceDate(Date chequeClearanceDate) {
        this.chequeClearanceDate = chequeClearanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}

