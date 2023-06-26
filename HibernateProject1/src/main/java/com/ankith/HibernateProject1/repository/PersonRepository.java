package com.ankith.HibernateProject1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ankith.HibernateProject1.entity.OrderData;
import com.ankith.HibernateProject1.entity.Person;

public class PersonRepository 
{
	private EntityManager getEntityManager()
	{
		//Persistence is class from javax.persistence package,is use to access the data from
		//Persistence.xml file and it will return object of EntityManagerFactory 
		//EntityManagerFactory is a interface that is use to build a connection to database
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abhi");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	public String savePerson(Person person)
	{
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abhi");
//		EntityManager manager = factory.createEntityManager();
		
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(person);//save the data
		transaction.commit();
		return "Data saved";
		
	}
	
	public String updatePerson(Person person)
	{
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abhi");
//		EntityManager manager = factory.createEntityManager();
		
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();//only for changing the data
		transaction.begin();
		manager.merge(person);// save the data and update the data
		transaction.commit();
		return "Data Updated";
		
	}
	
	public Person getPersonById(int id)
	{
		EntityManager manager = getEntityManager();
		Person find = manager.find(Person.class, id);
		return find;
	}
	public String deletePersonById(int id)
	{
		EntityManager manager = getEntityManager();
		Person person=manager.find(Person.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if(person!=null)
		{
			transaction.begin();
			manager.remove(person);// remove the data from database
			transaction.commit();
			return "Data deleted";
		}
		return "No data found to delete";
		
		
	}
	public List getAllData()
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("From Person p");//to create custom query(Hql this will convert sql before do the operation in database)
		List list = query.getResultList();//to get the list of data
		return list;
	}
	
	
	public List getPhoneNumberByName(String name)
	{
		EntityManager entityManager = getEntityManager();
		String q="FROM  Person p where p.name=?1";
		
		Query query = entityManager.createQuery(q);
		query.setParameter(1, name);
		List resultList = query.getResultList();
		return resultList;
	}
	
	
	public List getPhoneNumberByNameAndAge(String name ,int age)
	{
		EntityManager entityManager = getEntityManager();
		String q=" from Person p where p.name=?1 and p.age=?2";
		
		Query query = entityManager.createQuery(q);
		query.setParameter(1, name);
		query.setParameter(2, age);
		List resultList = query.getResultList();
		return resultList;
	}
}
