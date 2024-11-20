package com.RESTAPI.CRUD.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RESTAPI.CRUD.Repositories.CategoryRepository;
import com.RESTAPI.CRUD.Repositories.ProductRepository;
import com.RESTAPI.CRUD.entities.Category;
import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.CategoryRes;
import com.RESTAPI.CRUD.models.ProductRes;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Integer id) {
		List<Product> productLists = productRepository.findAllByIdgrp(id);
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));

		List<Product> products = new ArrayList<Product>();
		for (Product product : productLists) {
			Product p = new Product();
			p.setId(product.getId());
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			products.add(p);
		}
		category.setProducts(products);
		return category;
	}

	@Override
	public Category updateCategory(Integer id, Category updatedCategory) {
		Category category = getCategoryById(id);
		category.setName(updatedCategory.getName());
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}

	private Pageable createPageRequestUsing(int page, int size) {
		return PageRequest.of(page, size);
	}

	@Override
	public Page<CategoryRes> getAllCategories(int page, int size) {
		List<CategoryRes> products = new ArrayList<CategoryRes>();
		Pageable pageRequest = createPageRequestUsing(page, size);
		List<CategoryRes> allCategories = categoryRepository.getAllCategories();
		int start = (int) pageRequest.getOffset();
		int end = Math.min((start + pageRequest.getPageSize()), allCategories.size());
		List<CategoryRes> pageContent = allCategories.subList(start, end);
		return new PageImpl<>(pageContent, pageRequest, allCategories.size());
	}

}
