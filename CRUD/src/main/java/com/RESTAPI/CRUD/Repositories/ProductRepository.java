package com.RESTAPI.CRUD.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RESTAPI.CRUD.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
