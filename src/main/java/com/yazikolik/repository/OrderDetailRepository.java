package com.yazikolik.repository;

import java.util.ArrayList;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.OrderDetail;
import com.yazikolik.model.Order_;

public interface OrderDetailRepository {
	 JpaFactory jpaFactory = new JpaFactoryImpl();
		
	 	void save(OrderDetail orderDetail);
		
		void delete(OrderDetail orderDetail);
		
		OrderDetail find(int id);
		
		ArrayList<OrderDetail> findByOrder(Order_ order);
			
	
		OrderDetail update(OrderDetail orderDetail);
}
