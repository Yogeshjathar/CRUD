package com.RESTAPI.CRUD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.RESTAPI.CRUD.entities.Category;
import com.RESTAPI.CRUD.models.CategoryRes;
import com.RESTAPI.CRUD.models.ProductRes;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "select new com.RESTAPI.CRUD.models.CategoryRes(c.id, c.name) from Category c")
	  java.util.List<CategoryRes> getAllCategories();
}
