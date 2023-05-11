package com.goveg.vivek.GoVegSpringBootRestApi.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class CustomerBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    
    @Column(name = "CustomerName", nullable = false)
    private String CustomerName;
    
    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "itemId", nullable = false)
    private Long itemId;
    
    @Column(name = "catId", nullable = false)
    private Long catId;
    
    @Column(name = "price", nullable = false)
    private float price;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;


    public Long getCustomerId() {

        return customerId;
    }
    public void setCustomerId(Long customerId) {

        this.customerId = customerId;
    }
    public String getCustomerName() {

        return CustomerName;
    }
    public void setCustomerName(String customerName) {

        CustomerName = customerName;
    }
    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {

        this.itemId = itemId;
    }
    public Long getCatId() {

        return catId;
    }
    public void setCatId(Long catId) {

        this.catId = catId;
    }
    public float getPrice() {

        return price;
    }
    public void setPrice(float price) {

        this.price = price;
    }
    public int getQuantity() {

        return quantity;
    }
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

}
