package com.ankith.HibernateProject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ankith.HibernateProject1.entity.Course;
import com.ankith.HibernateProject1.util.EntityManagerFactoryUtil;

public class CourseRepository 
{
	private EntityManager manager=EntityManagerFactoryUtil.getFactory().createEntityManager();
	
	public void saveCourse(Course c)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(c);//only accept the entity object type argument if we give list it will not accept
		transaction.commit();
	}
	
	public void saveAllCourse(List<Course> c)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		for(Course cc:c)
		{
			manager.persist(cc);
		}
		transaction.commit();
		
	}
}
