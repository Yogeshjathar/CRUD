package com.RESTAPI.CRUD.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.RESTAPI.CRUD.entities.Category;

public interface CategoryService {
	
	public Page<Category> getAllCategories(Pageable pageable);
	
	public Category createCategory(Category category);
	
	public Category getCategoryById(long id);
	
	public Category updateCategory(long id,Category updatecategory);
	
	public void deleteCategory(long id);
}
