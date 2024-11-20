package com.RESTAPI.CRUD.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductRes;

public interface ProductService {

    public Page<ProductRes> getAllProducts(int page, int size);

    public Product createProduct(Product product);

    public ProductRes getProductById(Integer id);

    public Product updateProduct(Integer id, Product updatedProduct);

    public void deleteProduct(Integer id);
}
