package com.goveg.vivek.GoVegSpringBootRestApi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.FarmerBean;
import com.goveg.vivek.GoVegSpringBootRestApi.repository.FarmerRepository;

@Service
public class FarmerService {
	
	@Autowired
	FarmerRepository farmerRepository;

	public void saveFarmer(FarmerBean farmer) {
		farmerRepository.save(farmer);
		
	}

	public List<FarmerBean> fetchAllFarmers() {
		return farmerRepository.findAll();
	}

	public void deletefarmerById(Long id) {
		
		boolean exists=farmerRepository.existsById(id);

		if(!exists) {
			throw new IllegalStateException("Farmer with id " + id + " does not exists");
		}
		else {
			farmerRepository.deleteById(id);
		}
		
	}

	public Optional<FarmerBean> findFarmerById(Long id) {

		Optional<FarmerBean> farmerById=
				farmerRepository.findById(id);

		if(!(farmerById.isPresent())){
			throw new IllegalStateException("Farmer with id " + id +" does not exists");
		}
		return farmerById;
	}
	
	@Transactional
	public void updateFarmer(long farmerId, String farmerName, String farmerAddress, String farmerPhoneNumber) {
		
		FarmerBean farmerBean = farmerRepository.findById(farmerId)
				.orElseThrow(()->new IllegalStateException
						("Farmer Id "+farmerId+ " does not exist"));
	
		farmerBean.setFarmerName(farmerName);
		farmerBean.setFarmerAddress(farmerAddress);
		farmerBean.setFarmerPhoneNumber(farmerPhoneNumber);
		
	}

}
