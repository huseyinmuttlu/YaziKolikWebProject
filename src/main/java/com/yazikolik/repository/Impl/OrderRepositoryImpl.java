package com.yazikolik.repository.Impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.Order_;

import com.yazikolik.model.User;
import com.yazikolik.queries.OrderQueries;
import com.yazikolik.queries.UserQueries;
import com.yazikolik.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {
	
	private JpaFactory jpaFactory = new JpaFactoryImpl();
	
	private EntityManager entityManager = jpaFactory.getEntityManager();
	
	private EntityTransaction transaction = jpaFactory.getEntityTransaction();
	
	@Override
	public void save(Order_ order) {
		this.transaction.begin();
		
		this.entityManager.persist(order);
			
		this.transaction.commit();

	}

	@Override
	public void delete(Order_ order) {
		this.transaction.begin();
		
		this.entityManager.remove(order);
			
		this.transaction.commit();
		
		
	}

	@Override
	public Order_ find(int id) {
		Order_ order = this.entityManager.find(Order_.class, id);
		
		if(order != null) {
			
			return order;
			
		}
		
		return null;
	}

	@Override
	public ArrayList<Order_> findByUser(User user) {
		 TypedQuery<Order_> typedQuery = this.entityManager.createQuery(OrderQueries.findByUser, Order_.class);
		 typedQuery.setParameter("userID", user.getId());
		 ArrayList<Order_> orders = (ArrayList<Order_>) typedQuery.getResultList();
		 return orders;
	}

	@Override
	public ArrayList<Order_> getAllOrders() {
		 TypedQuery<Order_> typedQuery = this.entityManager.createQuery(OrderQueries.getAllOrder, Order_.class);
		 ArrayList<Order_> orders = (ArrayList<Order_>) typedQuery.getResultList();
		 return orders;
	}

	@Override
	public Order_ update(Order_ order) {

		Order_ updateOrder = this.entityManager.merge(order);
		
		return updateOrder;
	}
	
	@Override
	public Order_ lastOrder() {
		 TypedQuery<Order_> typedQuery = this.entityManager.createQuery(OrderQueries.getLastOrder, Order_.class);
		 Order_ order = typedQuery.getResultList().stream().findFirst().orElse(null);
		 return order;
	}
}
