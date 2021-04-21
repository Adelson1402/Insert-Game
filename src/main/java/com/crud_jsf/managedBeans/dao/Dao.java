package com.crud_jsf.managedBeans.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.crud_jsf.managedBeans.repository.GameRepository;


public class Dao<T extends GameRepository> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private static EntityManager manager = ConnectionFactory.getEntityManager();
	
	public T findById(Class<T> game, Long id) {
		return manager.find(game, id);
	}
	

	public void save(T game) {
		
		try {
			
			manager.getTransaction().begin();
			if(game.getId() == null) {
				
				manager.persist(game);
			}else {
				manager.merge(game);
			}
			
			manager.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
		
	}
	
	public void delete(Class<T> games, Long id) {
		T game = findById(games, id);
		
		try {
			manager.getTransaction().begin();
			
			manager.remove(game);
			
			manager.getTransaction().commit();
			
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String jpql){
		
		Query query = manager.createQuery(jpql);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> search(String jpql){
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}
}
