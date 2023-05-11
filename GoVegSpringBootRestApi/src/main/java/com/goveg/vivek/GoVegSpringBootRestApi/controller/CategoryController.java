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

import com.goveg.vivek.GoVegSpringBootRestApi.bean.CategoryBean;
import com.goveg.vivek.GoVegSpringBootRestApi.service.CategoryService;

@RestController
@RequestMapping(path="category")
public class CategoryController {

	
	private final CategoryService categoryService;
	
	@Autowired
	private CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	@GetMapping
	public List<CategoryBean> getAllCategory() {
		return categoryService.getAllCategory();

	}
	
	@PostMapping
	public void addCategory(@RequestBody CategoryBean category){
		categoryService.saveCategory(category);
	}

	@DeleteMapping(path = "{id}")
	public void deleteCategoyr(@PathVariable("id") Long id){
		categoryService.deleteCategoryById(id);
	}
	
	@GetMapping(path = "{id}")
	public Optional<CategoryBean> getCategoryById(@PathVariable("id") Long id)  {
		return categoryService.findCategoryById(id);

	}
	
	@PutMapping(path = "{catId}")
	public void updateCategory(@PathVariable("catId") long catId,
			@RequestParam(required = false) String catName) {
		
		categoryService.updateCategory(catId,catName);
	}

}
