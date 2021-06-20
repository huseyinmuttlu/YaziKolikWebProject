package com.yazikolik.jpaFactory.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yazikolik.jpaFactory.JpaFactory;

public class JpaFactoryImpl implements JpaFactory {

	private EntityManager entityManager = null;
	
	
	@Override
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		
		this.entityManager = factory.createEntityManager();
		
		return entityManager;
	}

	@Override
	public EntityTransaction getEntityTransaction() {
		
		EntityTransaction transaction = this.entityManager.getTransaction();
		
		return transaction;
	}

}
