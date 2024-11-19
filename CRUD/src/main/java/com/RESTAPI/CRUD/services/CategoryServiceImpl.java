package com.RESTAPI.CRUD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.RESTAPI.CRUD.Repositories.CategoryRepository;
import com.RESTAPI.CRUD.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(long id) {
		 return categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	}

	@Override
	public Category updateCategory(long id, Category updatedCategory) {
		Category category = getCategoryById(id);
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Page<Category> getAllCategories(org.springframework.data.domain.Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

}
