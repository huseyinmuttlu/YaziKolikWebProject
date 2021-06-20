package com.yazikolik.repository.Impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.OrderDetail;
import com.yazikolik.model.Order_;
import com.yazikolik.queries.OrderDetailQueries;
import com.yazikolik.repository.OrderDetailRepository;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {
	private JpaFactory jpaFactory = new JpaFactoryImpl();
	
	private EntityManager entityManager = jpaFactory.getEntityManager();
	
	private EntityTransaction transaction = jpaFactory.getEntityTransaction();
	
	@Override
	public void save(OrderDetail orderDetail) {
		this.transaction.begin();
		
		this.entityManager.persist(orderDetail);
			
		this.transaction.commit();
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		this.transaction.begin();
		
		this.entityManager.remove(orderDetail);
			
		this.transaction.commit();
		
	}

	@Override
	public OrderDetail find(int id) {
		OrderDetail orderDetail = this.entityManager.find(OrderDetail.class, id);
		
		if(orderDetail != null) {
			
			return orderDetail;
			
		}
		
		return null;
	}

	@Override
	public ArrayList<OrderDetail> findByOrder(Order_ order) {
		 TypedQuery<OrderDetail> typedQuery = this.entityManager.createQuery(OrderDetailQueries.findByOrder, OrderDetail.class);
		 typedQuery.setParameter("orderID", order.getOrderID());
		 ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>) typedQuery.getResultList();
		 return orderDetails;
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		OrderDetail updateOrderDetail = this.entityManager.merge(orderDetail);
		
		return updateOrderDetail;
	}

}
