package com.RESTAPI.CRUD.models;

public class ProductRes {

	private Integer Id;

	private String name;

	private Double price;

	private Integer category_id;

	public ProductRes() {
	}

	public ProductRes(Integer id, String name, Double price, Integer category_id) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
		this.category_id = category_id;
	}

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

	public Integer getcategory_id() {
		return category_id;
	}

	public void setcategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

}
