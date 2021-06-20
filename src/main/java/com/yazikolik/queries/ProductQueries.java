package com.yazikolik.queries;

public class ProductQueries {
	public static final String getAllProduct = "SELECT p FROM Product p";
	public static final String findByTitle = "Select c from Product c where c.title like :search";

}
