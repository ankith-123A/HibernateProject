package com.ankith.HibernateProject1.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ankith.HibernateProject1.entity.College;
import com.ankith.HibernateProject1.util.EntityManagerFactoryUtil;

public class CollegeRepository 
{
	private EntityManager manager=EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public String saveCollege(College c)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(c);
		transaction.commit();
		return c.toString()+" is added";
	}
	
	public College getCollegeById(int id)
	{
		return manager.find(College.class, id);
	}
}
