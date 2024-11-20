package com.RESTAPI.CRUD.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.RESTAPI.CRUD.Repositories.CategoryRepository;
import com.RESTAPI.CRUD.Repositories.ProductRepository;
import com.RESTAPI.CRUD.entities.Category;
import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductModel;
import com.RESTAPI.CRUD.models.ProductRes;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	private Pageable createPageRequestUsing(int page, int size) {
		return PageRequest.of(page, size);
	}

	@Override
	public Page<ProductRes> getAllProducts(int page, int size) {

		List<ProductRes> produsts = new ArrayList<ProductRes>();

		Pageable pageRequest = createPageRequestUsing(page, size);

		List<ProductRes> allProducts = productRepository.getAllProducts();
		int start = (int) pageRequest.getOffset();
		int end = Math.min((start + pageRequest.getPageSize()), allProducts.size());

		List<ProductRes> pageContent = allProducts.subList(start, end);
		return new PageImpl<>(pageContent, pageRequest, allProducts.size());

//		return productRepository.getAllProducts();
	}

	@Override
	public Product createProduct(Product product) {
//		Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//        product.setCategory(category);
		return productRepository.save(product);
	}

	@Override
	public ProductRes getProductById(Integer id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		return new ProductRes(product.getId(), product.getName(), product.getPrice(), product.getCategory().getId());

	}

	@Override
	public Product updateProduct(Integer id, Product updatedProduct) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		Category category = categoryRepository.findById(product.getCategory().getId())
				.orElseThrow(() -> new RuntimeException("Category not found"));
		product.setName(updatedProduct.getName());
		product.setPrice(updatedProduct.getPrice());
//        product.setCategory(category);
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

}
