package com.ankith.HibernateProject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ankith.HibernateProject1.entity.OrderData;

public class OrderDataRepository 
{
	private EntityManager getEntityManager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abhi");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public String saveOrderData(OrderData orderData)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(orderData);
		transaction.commit();
		return "Data is Saved";
	}
	
	public String updateOrderData(OrderData orderData)
	{
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(orderData);
		transaction.commit();
		return "Data is Updated";
	}
	
	public OrderData getOrderDataById(int id)
	{
		EntityManager manager = getEntityManager();
		OrderData find = manager.find(OrderData.class, id);
		return find;
	}
	public String deleteOrderDataById(int id)
	{
		EntityManager manager = getEntityManager();
		OrderData find = manager.find(OrderData.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if(find!=null)
		{
			transaction.begin();
			manager.remove(find);
			transaction.commit();
			return"Data is Deleted";
		}
		return" No Data is Deleted";	
	}
	
	public List getAllData()
	{
		EntityManager manager = getEntityManager();
		String q="FROM OrderData o";
		Query query = manager.createQuery(q);
		List resultList = query.getResultList();
		return resultList;
	}
}
