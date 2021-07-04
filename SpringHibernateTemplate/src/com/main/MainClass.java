package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Trainee;
import com.dao.TraineeDao;

public class MainClass {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TraineeDao traineeDao = context.getBean("traineeDao",TraineeDao.class);
		
		System.out.println(traineeDao.addTrainee(new Trainee("T1", 40)));
		System.out.println(traineeDao.addTrainee(new Trainee("T2", 30)));
		
		traineeDao.getAllTrainees();
		
		traineeDao.getAllTrainees();
	}

}
