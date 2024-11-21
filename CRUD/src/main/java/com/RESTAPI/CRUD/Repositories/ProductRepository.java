package com.RESTAPI.CRUD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductRes;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from machine_test.product where category_id = ?1", nativeQuery = true)
	java.util.List<Product> findAllByIdgrp(Integer id);

	@Query(value = "select new com.RESTAPI.CRUD.models.ProductRes(p.id, p.name, p.price, p.category.id) from Product p")
	java.util.List<ProductRes> getAllProducts();
	
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM machine_test.product WHERE id = ?1", nativeQuery = true)
	void deleteProductById(@Param("id") Integer id);

}
