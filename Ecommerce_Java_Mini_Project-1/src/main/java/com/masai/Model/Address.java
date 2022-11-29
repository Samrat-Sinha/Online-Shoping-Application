package com.masai.Model;

public class Address {

	private Integer addressId;
	private String BuildingName;
	private String StreetNo;
	private String City;
	private String State;
	private String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId, String buildingName, String streetNo, String city, String state, String pincode) {
		super();
		this.addressId = addressId;
		BuildingName = buildingName;
		StreetNo = streetNo;
		City = city;
		State = state;
		this.pincode = pincode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getBuildingName() {
		return BuildingName;
	}

	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}

	public String getStreetNo() {
		return StreetNo;
	}

	public void setStreetNo(String streetNo) {
		StreetNo = streetNo;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
}
