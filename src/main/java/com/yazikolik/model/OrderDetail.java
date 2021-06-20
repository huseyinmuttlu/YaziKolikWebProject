package com.yazikolik.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailID;
	
	@ManyToOne
	@JoinColumn(name = "orderID")
	private Order_ order;
	
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;
	
	private int quantity;
	
	private float price;
	
	private float totalAmaount;
	
	public OrderDetail() {
	
	}

	public OrderDetail(Order_ order, Product product, int quantity) {

		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = this.product.getPrice();
		this.setTotalAmaount();


	}

	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Order_ getOrder() {
		return order;
	}

	public void setOrder(Order_ order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalAmaount() {
		return totalAmaount;
	}
	
	public void setTotalAmaount() {
		this.totalAmaount = this.price * this.quantity;
	}
}
