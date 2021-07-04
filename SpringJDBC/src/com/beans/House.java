package com.beans;

public class House {
	
	private int houseNo;
	
	private String houseAddress;

	public House() {
		super();
	}

	public House(int houseNo, String houseAddress) {
		super();
		this.houseNo = houseNo;
		this.houseAddress = houseAddress;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	@Override
	public String toString() {
		return "House [houseNo=" + houseNo + ", houseAddress=" + houseAddress + "]";
	}
	
	
	

}
