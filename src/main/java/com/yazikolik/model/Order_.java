package com.yazikolik.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seq", initialValue=5000, allocationSize=100)
public class Order_ {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int orderID;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	private float paymentAmount;
	
	public Order_() {

	}



	public Order_(Date orderDate, User user, float paymentAmount) {

		this.orderDate = orderDate;
		this.user = user;
		this.paymentAmount = paymentAmount;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}
