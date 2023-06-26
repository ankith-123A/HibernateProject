package com.ankith.HibernateProject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ankith.HibernateProject1.entity.Customer;
import com.ankith.HibernateProject1.util.EntityManagerFactoryUtil;

public class CustomerRepository 
{
	private EntityManager manager=EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public String saveCustomer(Customer customer)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		return "Data is saved";
	}
	
	public Customer getCustomerById(int id)
	{
		EntityTransaction transaction = manager.getTransaction();
		Customer find = manager.find(Customer.class, id);
		return find;
	}
	
	public String deleteCustomerById(int id)
	{
		EntityTransaction transaction = manager.getTransaction();
		Customer find = manager.find(Customer.class, id);
		if(find!=null)
		{
			transaction.begin();
			manager.remove(find);
			transaction.commit();
			return"Data Is Deleted";
		}
		return"No data is Deleted";
		
	}
	public List getAllData()
	{
		String q="From Customer c";
		Query query = manager.createQuery(q);
		List list = query.getResultList();
		return list;
	}
}
