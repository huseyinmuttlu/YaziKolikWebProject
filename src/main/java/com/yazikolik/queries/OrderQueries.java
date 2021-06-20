package com.yazikolik.queries;

public class OrderQueries {
	public static final String findByUser = "select o from Order_ o where o.userID=:userID";
	public static final String getAllOrder = "select o from Order_ o";
	public static final String getLastOrder = "select o from Order_ o where orderID=(select max(o.orderID) from Order_ o)";
}
