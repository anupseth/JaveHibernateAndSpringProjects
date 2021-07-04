package com.collections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUntilAnup;

public class TestCollections {

	public static void main(String[] args) {
		EmployeeColl emp = new EmployeeColl("TestEmp", "TestEmp1", "TestEmp2", "TestEmp3");
		
		Session session = HibernateUntilAnup.getHibernateSession();
		 Transaction trans = session.beginTransaction();
		 
		 
		 session.save(emp);
		 
		 trans.commit(); 
			session.close();
	}

}
