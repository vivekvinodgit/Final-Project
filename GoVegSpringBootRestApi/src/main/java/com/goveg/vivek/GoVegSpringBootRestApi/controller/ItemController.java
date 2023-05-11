package com.goveg.vivek.GoVegSpringBootRestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.ItemBean;
import com.goveg.vivek.GoVegSpringBootRestApi.service.ItemService;

@RestController
@RequestMapping(path="item")
public class ItemController {
	
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService=itemService;
	}
	
	@GetMapping
	public List<ItemBean> getAllItem() {
		return itemService.getAllItem();

	}
	
	@PostMapping
	public void addItem(@RequestBody ItemBean item){
		itemService.saveItem(item);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteItem(@PathVariable("id") Long id){
		itemService.deleteItemById(id);
	}
	
	@GetMapping(path = "{id}")
	public Optional<ItemBean> getItemById(@PathVariable("id") Long id)  {
		return itemService.findItemById(id);
		
	}
	
	@PutMapping(path = "{itemId}")
	public void updateItem(@PathVariable("itemId") long itemId,
			@RequestParam(required = false) String itemName,
			@RequestParam(required = false) Long catId,
			@RequestParam(required = false) float itemPrice) {
		
		itemService.updateCategory(itemId,itemName,catId,itemPrice);
	}
	
}
