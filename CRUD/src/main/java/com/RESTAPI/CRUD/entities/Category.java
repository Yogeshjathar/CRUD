package com.RESTAPI.CRUD.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;;

@Entity
//@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column
	private Integer id;

//	@Column
	private String name;

	// @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//	  private List<Product> products;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();

	public Category() {

	}

	public Category(Integer id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

}
