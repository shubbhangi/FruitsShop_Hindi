package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StoreDetails generated by hbm2java
 */
public class StoreDetails  implements java.io.Serializable {

 private Integer id;
     private String name;
     private String address;
     private String city;
     private String state;
     private String pincode;
     private String phone;
     private String website;
     private String email;
     private String gstNumber;
     private byte[] photo;
     private String hsnCode;
     private Set vendorBillMasters = new HashSet(0);
     private Set saleMasters = new HashSet(0);

    public StoreDetails() {
    }

    public StoreDetails(String name, String address, String city, String state, String pincode, String phone, String website, String email, String gstNumber, byte[] photo, String hsnCode, Set vendorBillMasters, Set saleMasters) {
       this.name = name;
       this.address = address;
       this.city = city;
       this.state = state;
       this.pincode = pincode;
       this.phone = phone;
       this.website = website;
       this.email = email;
       this.gstNumber = gstNumber;
       this.photo = photo;
       this.hsnCode = hsnCode;
       this.vendorBillMasters = vendorBillMasters;
       this.saleMasters = saleMasters;
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
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
    public String getPincode() {
        return this.pincode;
    }
    
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGstNumber() {
        return this.gstNumber;
    }
    
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
    public byte[] getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public String getHsnCode() {
        return this.hsnCode;
    }
    
    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }
    public Set getVendorBillMasters() {
        return this.vendorBillMasters;
    }
    
    public void setVendorBillMasters(Set vendorBillMasters) {
        this.vendorBillMasters = vendorBillMasters;
    }
    public Set getSaleMasters() {
        return this.saleMasters;
    }
    
    public void setSaleMasters(Set saleMasters) {
        this.saleMasters = saleMasters;
    }

}


