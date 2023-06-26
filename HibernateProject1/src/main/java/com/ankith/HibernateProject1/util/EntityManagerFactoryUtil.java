package com.ankith.HibernateProject1.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil 
{
	private static EntityManagerFactory factory;
	
	private EntityManagerFactoryUtil()
	{
		
	}
	public static EntityManagerFactory getFactory()
	{
		if(factory==null)
		{
			factory=Persistence.createEntityManagerFactory("abhi");
			return factory;
		}
		return factory;
	}
}
