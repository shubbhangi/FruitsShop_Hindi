package com.grocery.bean;
// Generated Mar 28, 2020 3:09:43 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * ItemAvailability generated by hbm2java
 */
public class ItemAvailability  implements java.io.Serializable {


     private Integer id;
     private ItemMaster itemMaster;
     private BigDecimal availability;
     private BigDecimal threshold;

    public ItemAvailability() {
    }

    public ItemAvailability(ItemMaster itemMaster, BigDecimal availability, BigDecimal threshold) {
       this.itemMaster = itemMaster;
       this.availability = availability;
       this.threshold = threshold;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public ItemMaster getItemMaster() {
        return this.itemMaster;
    }
    
    public void setItemMaster(ItemMaster itemMaster) {
        this.itemMaster = itemMaster;
    }
    public BigDecimal getAvailability() {
        return this.availability;
    }
    
    public void setAvailability(BigDecimal availability) {
        this.availability = availability;
    }
    public BigDecimal getThreshold() {
        return this.threshold;
    }
    
    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }




}


