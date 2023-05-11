package com.goveg.vivek.GoVegSpringBootRestApi.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "category")
@Table(name = "category")
public class CategoryBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    @Column(name = "catName", nullable = false)
    private String catName;

    public Long getCatId() {
        return catId;
    }
    public void setCatId(Long catId) {
        this.catId = catId;
    }
    public String getCatName() {
        return catName;
    }
    public void setCatName(String catName) {
        this.catName = catName;
    }

    public CategoryBean(String catName) {
        this.catName = catName;
    }
    public CategoryBean() {
    }
}
