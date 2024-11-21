package com.RESTAPI.CRUD.services;
import org.springframework.data.domain.Page;

import com.RESTAPI.CRUD.entities.Category;
import com.RESTAPI.CRUD.models.CategoryRes;

public interface CategoryService {

	public Page<CategoryRes> getAllCategories(int page, int size);

	public Category createCategory(Category category);

	public Category getCategoryById(Integer id);

	public Category updateCategory(Integer id, Category updatecategory);

	public void deleteCategory(Integer id);
}
