package com.RESTAPI.CRUD.models;

import com.RESTAPI.CRUD.entities.Category;

public class ProductModel {

	private String name;

	private Double price;

	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
