package com.one2Many;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Player;
import com.util.HibernateUntilAnup;

public class One2Many {
	
	public static void main(String[] args) {
		
		 Session session = HibernateUntilAnup.getHibernateSession();
		 Transaction trans = session.beginTransaction();
		 
		 Employee emp1 = new Employee("Bhima", new ArrayList<Phone>());
		 
		 Phone p1 = new Phone(8765);
		 Phone p2 = new Phone(999);
		 
		 emp1.getPhoneList().add(p1);
		 emp1.getPhoneList().add(p2);
		 
		 session.save(emp1);
		 session.save(p1);
		 session.save(p2);
		
		trans.commit(); 
		session.close();
	}

}
