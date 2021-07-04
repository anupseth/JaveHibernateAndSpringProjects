package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.collections.EmployeeColl;
import com.entities.Player;
import com.one2Many.Employee;
import com.one2Many.Phone;

public class HibernateUntilAnup {
	
	private static Session session = null;
	private static Transaction transaction = null;
	
	public static Session getHibernateSession() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Player.class);
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Phone.class);
		configuration.addAnnotatedClass(EmployeeColl.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		session = factory.openSession();
		
		return session;
	}
	
	public static Transaction getTransaction() {
		session = getHibernateSession();
		
		if(session != null) {
			if(session.getTransaction() == null) {
				 transaction = session.beginTransaction();
			}else {
				transaction = session.getTransaction();
			}
		}
		
		return transaction;
	}
	
}
