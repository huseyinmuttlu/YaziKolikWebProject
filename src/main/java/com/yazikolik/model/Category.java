package com.yazikolik.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="categoryID")
	private int categoryID;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	public Category() {
	
	}
	

	public Category(String name) {

		this.name = name;
	}


	public int getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
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


	
}
