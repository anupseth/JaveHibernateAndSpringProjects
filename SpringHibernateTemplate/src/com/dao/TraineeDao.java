package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.beans.Trainee;

public class TraineeDao {

	private HibernateTemplate hibernateTemplate;
	
	private DataSourceTransactionManager dataTransManager;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addTrainee(Trainee tnee) {
		dataTransManager.getTransaction(null);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int) session.save(tnee);
		session.getTransaction().commit();
		return id;
	}
	
	public List<Trainee> getAllTrainees(){
		List<Trainee> traineeList = hibernateTemplate.loadAll(Trainee.class);
		traineeList.forEach(System.out::println);
		return traineeList;
	}



}
