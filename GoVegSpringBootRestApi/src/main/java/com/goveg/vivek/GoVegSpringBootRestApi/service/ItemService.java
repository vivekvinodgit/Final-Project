package com.goveg.vivek.GoVegSpringBootRestApi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.ItemBean;
import com.goveg.vivek.GoVegSpringBootRestApi.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<ItemBean> getAllItem() {

		return itemRepository.findAll();
	}
	
	public void saveItem(ItemBean item) {
		
		itemRepository.save(item);
	}
	
	public void deleteItemById(Long id) {

		boolean exists=itemRepository.existsById(id);

		if(!exists) {
			throw new IllegalStateException("Item with id " + id + " does not exists");
		}
		else {
			itemRepository.deleteById(id);
		}
	}
	
	public Optional<ItemBean> findItemById(Long id) {
		
		Optional<ItemBean> itemById=
				itemRepository.findById(id);

		if(!(itemById.isPresent())){
			throw new IllegalStateException("ItemId not present");
		}
		return itemById;		
		
	}
	
	@Transactional
	public void updateCategory(Long itemId,String itemName,Long catId,float itemPrice) {
		
		ItemBean itemBean = itemRepository.findById(itemId)
				.orElseThrow(()->new IllegalStateException
						("Item Id "+itemId+ " does not exist"));
	
		itemBean.setItemName(itemName);
		itemBean.setCatId(catId);
		itemBean.setItemPrice(itemPrice);
	}
	
	public float findItempriceByItemId(Long id) {
		
		Optional<ItemBean> item=
				itemRepository.findById(id);

		if(!(item.isPresent())){
			throw new IllegalStateException("ItemId not present");
		}
		return item.get().getItemPrice();	
		
	}
	
	public Long findCatIdByItemId(Long id) {
		
		Optional<ItemBean> item=
				itemRepository.findById(id);
		
		if(!(item.isPresent())){
			throw new IllegalStateException("ItemId not present");
		}
		return item.get().getCatId();
	}
}
