package com.goveg.vivek.GoVegSpringBootRestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.FarmerBean;
import com.goveg.vivek.GoVegSpringBootRestApi.service.FarmerService;
import com.goveg.vivek.GoVegSpringBootRestApi.service.ItemService;

@RestController
@RequestMapping(path="farmer")
public class FarmerController {
	
	private FarmerService farmerService;
	private ItemService itemService;
	
	public FarmerController(FarmerService farmerService,ItemService itemService) {
        this.farmerService=farmerService;
        this.itemService=itemService;
    }
	
	@GetMapping
	public List<FarmerBean> getAllFarmers() {
		return farmerService.fetchAllFarmers();
	}
	
	@PostMapping
	public void addFarmer(@RequestBody FarmerBean farmer){	
		
		farmer.setCatId(itemService.findCatIdByItemId(farmer.getItemId()));
		farmerService.saveFarmer(farmer);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteFarmer(@PathVariable("id") Long id){
		farmerService.deletefarmerById(id);
	}
	
	@GetMapping(path = "{id}")
	public Optional<FarmerBean> getFarmerById(@PathVariable("id") Long id)  {
		return farmerService.findFarmerById(id);
		
	}
	
	@PutMapping(path = "{farmerId}")
	public void updateFarmer(@PathVariable("farmerId") long farmerId,
			@RequestParam(required = false) String farmerName,
			@RequestParam(required = false) String farmerAddress,
			@RequestParam(required = false) String farmerPhoneNumber) {
		
		farmerService.updateFarmer(farmerId,farmerName,farmerAddress,farmerPhoneNumber);
	}
}
