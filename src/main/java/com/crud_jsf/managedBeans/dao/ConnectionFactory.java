package com.crud_jsf.managedBeans.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbPersist");
	
	public static EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
}
