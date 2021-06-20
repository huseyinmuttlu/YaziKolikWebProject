package com.yazikolik.repository;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.User;

public interface UserRepository {

	 JpaFactory jpaFactory = new JpaFactoryImpl();
	
	void save(User user);
	
	void delete(User user);
	
	User find(int id);
	
	User findByEmail(String email);
	
	User update(User user);
}
