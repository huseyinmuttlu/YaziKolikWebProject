package com.yazikolik.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	
	private String title;
	
	private String author;
	
	private String publisher;
	
	private String imageUrl;
	
	private float price;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category category;
	
	public Product() {
	
	}

	public Product(String title, String author, String publisher, float price, Date releaseDate, Category category) {

		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.releaseDate = releaseDate;
		this.category = category;
	}

	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", price=" + price + ", releaseDate=" + releaseDate + ", category=" + category + "]";
	}
	
	

}
