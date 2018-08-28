package com.ap.persistent.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory  sessionFactory;
	
	static {
		try {
			StandardServiceRegistry standardServiceRegistry = 
					new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();
			sessionFactory = new MetadataSources(standardServiceRegistry).getMetadataBuilder()
					.build().getSessionFactoryBuilder().build();
		}catch (Throwable th) {

			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);

		}
	}
	
	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}
