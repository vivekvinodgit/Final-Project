package com.goveg.vivek.GoVegSpringBootRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.ItemBean;

@Repository
public interface ItemRepository extends JpaRepository<ItemBean,Long> {
	
//	@Query("select u FROM item u where ItemId=:n")
//	public ItemBean getItemByItemId( @Param("n") Long ItemId); 
}
