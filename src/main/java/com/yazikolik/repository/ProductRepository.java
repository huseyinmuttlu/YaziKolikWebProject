package com.yazikolik.repository;


import java.util.ArrayList;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.Product;


public interface ProductRepository {
	 JpaFactory jpaFactory = new JpaFactoryImpl();
	 
	 ArrayList<Product> getAllProducts();
	 
	 ArrayList<Product> findByTitle(String title);
	 
	 Product findProductByTitle(String title);
}
