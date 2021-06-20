package com.yazikolik.repository;



import java.util.ArrayList;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;

import com.yazikolik.model.Order_;
import com.yazikolik.model.User;

public interface OrderRepository {
	 JpaFactory jpaFactory = new JpaFactoryImpl();
		
	 	void save(Order_ order);
		
		void delete(Order_ order);
		
		Order_ find(int id);
		
		ArrayList<Order_> findByUser(User user);
		
		ArrayList<Order_> getAllOrders();		
	
		Order_ lastOrder();
		
		Order_ update(Order_ order);
}
