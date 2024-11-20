package com.RESTAPI.CRUD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.RESTAPI.CRUD.entities.Product;
import com.RESTAPI.CRUD.models.ProductRes;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "select * from machine_test.product where category_id = ?1", nativeQuery = true)
	java.util.List<Product> findAllByIdgrp(Integer id);
	
//	@Query(value = "select id, name, price, category_id from machine_test.product", nativeQuery = true)
//	java.util.List<ProdustRes> getAllProducts();
	
	
	  @Query(value = "select new com.RESTAPI.CRUD.models.ProductRes(p.id, p.name, p.price, p.category.id) from Product p")
	  java.util.List<ProductRes> getAllProducts();
	 
	
	

}
