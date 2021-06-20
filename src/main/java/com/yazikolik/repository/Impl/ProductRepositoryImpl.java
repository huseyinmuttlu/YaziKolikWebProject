package com.yazikolik.repository.Impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.Product;
import com.yazikolik.queries.ProductQueries;

import com.yazikolik.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	
	private JpaFactory jpaFactory = new JpaFactoryImpl();
	
	private EntityManager entityManager = jpaFactory.getEntityManager();
	
	//private EntityTransaction transaction = jpaFactory.getEntityTransaction();
	
	@Override
	public ArrayList<Product> getAllProducts() {
		 TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.getAllProduct, Product.class);
		 ArrayList<Product> products = (ArrayList<Product>) typedQuery.getResultList();
		 return products;
	}
	
	@Override
	public ArrayList<Product> findByTitle(String title){
		 TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findByTitle, Product.class);
		 typedQuery.setParameter("search", title);
		 ArrayList<Product> products = (ArrayList<Product>) typedQuery.getResultList();
		 return products;
	}
	@Override
	public Product findProductByTitle(String title){
		 TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findByTitle, Product.class);
		 typedQuery.setParameter("search", title);
		 Product product = typedQuery.getResultList().stream().findFirst().orElse(null);
		 return product;
	}
}
