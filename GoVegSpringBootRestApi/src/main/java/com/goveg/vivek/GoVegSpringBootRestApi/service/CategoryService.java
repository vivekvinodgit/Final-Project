package com.goveg.vivek.GoVegSpringBootRestApi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goveg.vivek.GoVegSpringBootRestApi.bean.CategoryBean;
import com.goveg.vivek.GoVegSpringBootRestApi.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<CategoryBean> getAllCategory() {

		return categoryRepository.findAll();
	}

	public void deleteCategoryById(Long id) {

		boolean exists=categoryRepository.existsById(id);

		if(!exists) {
			throw new IllegalStateException("Category with id " + id + " does not exists");
		}
		else {
			categoryRepository.deleteById(id);
		}
	}

	public void saveCategory(CategoryBean category) {
		
		categoryRepository.save(category);
	}
	
	public Optional<CategoryBean> findCategoryById(Long id) {
		
		Optional<CategoryBean> categoryById=
				categoryRepository.findById(id);

		if(!(categoryById.isPresent())){
			throw new IllegalStateException("CatId not present");
		}
		return categoryById;		
		
	}
	
	@Transactional
	public void updateCategory(Long catId, String catName) {
		
		CategoryBean categoryBean = categoryRepository.findById(catId)
				.orElseThrow(()->new IllegalStateException
						("Category Id "+catId+ " does not exist"));
	
		categoryBean.setCatName(catName);
	}
}
