package com.goveg.vivek.GoVegSpringBootRestApi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "farmer")
public class FarmerBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerId;
    
    @Column(name = "farmerName", nullable = false)
    private String farmerName;
    
    @Column(name = "farmerPhoneNumber", nullable = false)
    private String farmerPhoneNumber;
    
    @Column(name = "farmerAddress", nullable = false)
    private String farmerAddress;
    
    @Column(name = "itemId", nullable = false)
    private Long itemId;
    
    @Column(name = "catId", nullable = false)
    private Long catId;

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerPhoneNumber() {
        return farmerPhoneNumber;
    }

    public void setFarmerPhoneNumber(String farmerPhoneNumber) {
        this.farmerPhoneNumber = farmerPhoneNumber;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
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

	@Override
	public String toString() {
		return "farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmerPhoneNumber="
				+ farmerPhoneNumber + ", farmerAddress=" + farmerAddress + ", itemId=" + itemId + ", catId=" + catId
				;
	}
}
