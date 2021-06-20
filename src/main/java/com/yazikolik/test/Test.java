package com.yazikolik.test;

import com.yazikolik.model.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.yazikolik.repository.Impl.*;
import com.yazikolik.repository.*;
/**
 * UserDAOTest.java
 * Copyright by CodeJava.net
 */
public class Test {
 
    public static void main(String[] args) {
 
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
   EntityManager entityManager = factory.createEntityManager();
  //  ProductRepository productRepo = new ProductRepositoryImpl();
  //  List<Product> productList = productRepo.getAllProducts();
 //   System.out.println(productList.get(0));
        /*   
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Category category = new Category("roman");
        entityManager.persist(category);
        Product p = new Product("insan ne ile yasar", "Tolstoy", "Pegasus",new Float(10.99), new Date(), category);
        entityManager.persist(p);
        Order_ o1 = new Order_(new Date(),0);
        entityManager.persist(o1);
        float totalAmount = 0;
        // for product in session.getAttribute("basket") tuple (product, quantity)
        OrderDetail od1 = new OrderDetail(o1,p,2);
        totalAmount += od1.getTotalAmaount();
        entityManager.persist(od1);
        //for 
        o1.setPaymentAmount(totalAmount);
        transaction.commit();
       */
    }
}
