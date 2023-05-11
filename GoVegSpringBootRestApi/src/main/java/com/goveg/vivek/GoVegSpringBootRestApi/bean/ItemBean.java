package com.goveg.vivek.GoVegSpringBootRestApi.bean;

import javax.persistence.*;

@Entity(name="item")
@Table(name = "item")
public class ItemBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ItemId;
    @Column(name = "item_name", nullable = false)
    private String ItemName;
    @Column(name = "cat_id", nullable = false)
    private Long catId;
    @Column(name = "item_price", nullable = false)
    private float itemPrice;

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "ItemId=" + ItemId +
                ", ItemName='" + ItemName + '\'' +
                ", catId=" + catId +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
