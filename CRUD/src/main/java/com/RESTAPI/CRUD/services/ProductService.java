package com.RESTAPI.CRUD.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RESTAPI.CRUD.entities.Product;

public interface ProductService {

    public Page<Product> getAllProducts(Pageable pageable);

    public Product createProduct(Product product, Long categoryId);

    public Product getProductById(Long id);

    public Product updateProduct(Long id, Product updatedProduct, Long categoryId);

    public void deleteProduct(Long id);
}
