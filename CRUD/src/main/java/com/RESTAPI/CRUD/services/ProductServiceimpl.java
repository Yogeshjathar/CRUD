package com.RESTAPI.CRUD.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.RESTAPI.CRUD.Repositories.ProductRepository;
import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductRes;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	private Pageable createPageRequestUsing(int page, int size) {
		return PageRequest.of(page, size);
	}

	@Override
	public Page<ProductRes> getAllProducts(int page, int size) {

		Pageable pageRequest = createPageRequestUsing(page, size);

		List<ProductRes> allProducts = productRepository.getAllProducts();
		int start = (int) pageRequest.getOffset();
//		int end = Math.min((start + pageRequest.getPageSize()), allProducts.size());
		int end = allProducts.size();

		List<ProductRes> pageContent = allProducts.subList(start, end);
		return new PageImpl<>(pageContent, pageRequest, allProducts.size());
	}

	@Override
	public Product createProduct(Product product) {
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
		product.setName(updatedProduct.getName());
		product.setPrice(updatedProduct.getPrice());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

}
