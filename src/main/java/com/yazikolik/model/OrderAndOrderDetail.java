package com.yazikolik.model;
import java.util.ArrayList;


public class OrderAndOrderDetail {

	private Order_ order;
	
	private ArrayList<OrderDetail> orderDetail;

	public OrderAndOrderDetail(Order_ order, ArrayList<OrderDetail> orderDetail) {
		super();
		this.order = order;
		this.orderDetail = orderDetail;
	}

	public Order_ getOrder() {
		return order;
	}

	public void setOrder(Order_ order) {
		this.order = order;
	}

	public ArrayList<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	

}
