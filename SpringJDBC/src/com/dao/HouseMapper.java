package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.House;

public class HouseMapper implements RowMapper<House>{

	@Override
	public House mapRow(ResultSet rs, int rowNum) throws SQLException {
		House h = new House();
		h.setHouseNo(rs.getInt("houseNo")); // these are database column names mapped to class fields
		h.setHouseAddress(rs.getString("houseAddress"));
		return h;
	}
	
	

}
