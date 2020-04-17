package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerDetails generated by hbm2java
 */
public class CustomerDetails  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String contact;
     private String address;
     private BigDecimal balance;
     private Set saleMasters = new HashSet(0);
     private Set customerPartialPayments = new HashSet(0);

    public CustomerDetails() {
    }

    public CustomerDetails(String name, String contact, String address, BigDecimal balance, Set saleMasters, Set customerPartialPayments) {
       this.name = name;
       this.contact = contact;
       this.address = address;
       this.balance = balance;
       this.saleMasters = saleMasters;
       this.customerPartialPayments = customerPartialPayments;
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
    public BigDecimal getBalance() {
        return this.balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Set getSaleMasters() {
        return this.saleMasters;
    }
    
    public void setSaleMasters(Set saleMasters) {
        this.saleMasters = saleMasters;
    }
    public Set getCustomerPartialPayments() {
        return this.customerPartialPayments;
    }
    
    public void setCustomerPartialPayments(Set customerPartialPayments) {
        this.customerPartialPayments = customerPartialPayments;
    }




}


