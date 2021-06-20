package com.yazikolik.repository.Impl;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.yazikolik.jpaFactory.JpaFactory;
import com.yazikolik.jpaFactory.Impl.JpaFactoryImpl;
import com.yazikolik.model.User;
import com.yazikolik.queries.UserQueries;
import com.yazikolik.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private JpaFactory jpaFactory = new JpaFactoryImpl();
	
	private EntityManager entityManager = jpaFactory.getEntityManager();
	
	private EntityTransaction transaction = jpaFactory.getEntityTransaction();
	
	@Override
	public void save(User user) {
	
		this.transaction.begin();
		
		this.entityManager.persist(user);
			
		this.transaction.commit();

	}

	@Override
	public void delete(User user) {
	
		this.transaction.begin();
		
		this.entityManager.remove(user);
			
		this.transaction.commit();
		
		
		
	}

	@Override
	public User find(int id) {
		
		User user = this.entityManager.find(User.class, id);
		
		if(user != null) {
			
			return user;
			
		}
		
		return null;
	}
	
	
	@Override
	public User findByEmail(String email) {
		
		//Query query = this.entityManager.createQuery(UserQueries.findByEmail);
		
		//User user = query.getSingleResult();
		 TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findByEmail, User.class);
		 typedQuery.setParameter("email", email);
		 User user = typedQuery.getResultList().stream().findFirst().orElse(null);
		 return user;
	}

	@Override
	public User update(User user) {

		User updateUser = this.entityManager.merge(user);
		
		return updateUser;
	}

}
