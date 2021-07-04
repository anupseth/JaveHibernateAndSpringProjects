package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.beans.House;

public class HouseDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager ptm;

	
	public int addHouse(House h) {
			int count =0;
			String query = "insert into house values(?,?)";
			return count = jdbcTemplate.update(query,h.getHouseNo(),h.getHouseAddress());
	}
	
	public List<House> getAllHouses(){
			String query = "select * from house";
			List<House> houseList = jdbcTemplate.query(query, new HouseMapper());
			houseList.forEach(System.out::println);
			return houseList;
	}
	
	public void performTransaction(House h) {
		System.out.println("Performing transaction .......");
		
		TransactionDefinition td = new DefaultTransactionDefinition();
		 TransactionStatus ts = ptm.getTransaction(td);
		 
		 try {
			 
			 	int count =0;
				String query = "insert into house values(?,?)";
				count = jdbcTemplate.update(query,h.getHouseNo(),h.getHouseAddress());
				System.out.println("Count .... = "+ count);
				
				query = "select * from house where houseNo > ?";
				List<House> houseList = jdbcTemplate.query(query, new HouseMapper(), 2);
				System.out.println("Printing house list where hounseNo > 2");
				houseList.forEach(System.out::println);
				ptm.commit(ts);
				
		 }catch(Exception ex) {
			 System.out.println("Transaction failed ...");
			 ptm.rollback(ts);
		 }
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getPtm() {
		return ptm;
	}

	public void setPtm(PlatformTransactionManager ptm) {
		this.ptm = ptm;
	}
	
	
	

}
