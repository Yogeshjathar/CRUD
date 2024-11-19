package com.RESTAPI.CRUD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RESTAPI.CRUD.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
