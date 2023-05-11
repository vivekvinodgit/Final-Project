package com.goveg.vivek.GoVegSpringBootRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.FarmerBean;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerBean, Long> {

}
