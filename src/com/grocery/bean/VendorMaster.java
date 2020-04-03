package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * VendorMaster generated by hbm2java
 */
public class VendorMaster  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String contact;
     private String address;
     private String registration;
     private String city;
     private String state;
     private Integer pincode;
     private String gstNumber;
     private BigDecimal balance;
     private Float percentageMrp;
     private Set vendorBillMasters = new HashSet(0);
     private Set vendorPartialPayments = new HashSet(0);

    public VendorMaster() {
    }

    public VendorMaster(String name, String contact, String address, String registration, String city, String state, Integer pincode, String gstNumber, BigDecimal balance, Float percentageMrp, Set vendorBillMasters, Set vendorPartialPayments) {
       this.name = name;
       this.contact = contact;
       this.address = address;
       this.registration = registration;
       this.city = city;
       this.state = state;
       this.pincode = pincode;
       this.gstNumber = gstNumber;
       this.balance = balance;
       this.percentageMrp = percentageMrp;
       this.vendorBillMasters = vendorBillMasters;
       this.vendorPartialPayments = vendorPartialPayments;
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
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRegistration() {
        return this.registration;
    }
    
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public Integer getPincode() {
        return this.pincode;
    }
    
    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
    public String getGstNumber() {
        return this.gstNumber;
    }
    
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Float getPercentageMrp() {
        return this.percentageMrp;
    }
    
    public void setPercentageMrp(Float percentageMrp) {
        this.percentageMrp = percentageMrp;
    }
    public Set getVendorBillMasters() {
        return this.vendorBillMasters;
    }
    
    public void setVendorBillMasters(Set vendorBillMasters) {
        this.vendorBillMasters = vendorBillMasters;
    }
    public Set getVendorPartialPayments() {
        return this.vendorPartialPayments;
    }
    
    public void setVendorPartialPayments(Set vendorPartialPayments) {
        this.vendorPartialPayments = vendorPartialPayments;
    }




}

