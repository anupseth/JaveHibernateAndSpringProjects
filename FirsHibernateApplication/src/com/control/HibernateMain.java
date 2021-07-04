package com.control;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Player;

public class HibernateMain {

	public static void main(String[] args) {
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Player.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		if(session.getTransaction() == null) {
			 transaction = session.beginTransaction();
		}else {
			transaction = session.getTransaction();
		}
		transaction.begin();
		
		
		// executions --------------------------------
		
		/*
		 * HQL QUERIES Query<Player> query =
		 * session.createQuery("From Player where age>:age order by age desc");
		 * query.setInteger("age", 100); List<Player> playerList = query.list();
		 * playerList.forEach(System.out::println);
		 */
		
		
		
		
		// --------------------------------------------------
		
		transaction.commit();
		session.close();
		System.out.println("Done.........");
	}

}
