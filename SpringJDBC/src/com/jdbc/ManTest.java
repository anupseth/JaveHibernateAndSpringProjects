package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.House;
import com.dao.HouseDao;

public class ManTest {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		HouseDao houseDao = (HouseDao) appContext.getBean("houseDao");
		
		//System.out.println(houseDao.addHouse(new House(5,"aaaa")));
		
		houseDao.getAllHouses();
		
		houseDao.performTransaction(new House(6,"bbbb"));
		
		System.out.println("done ..........");

	}

}
