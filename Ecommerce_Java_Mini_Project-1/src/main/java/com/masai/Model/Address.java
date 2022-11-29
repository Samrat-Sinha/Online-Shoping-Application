package com.masai.Model;


public class Address {


	private String addressId;
	private String BuildNo;
	private String Street;
	private String city;
	private String State;
	private String pincode;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressId, String buildNo, String street, String city, String state, String pincode) {
		super();
		this.addressId = addressId;
		BuildNo = buildNo;
		Street = street;
		this.city = city;
		State = state;
		this.pincode = pincode;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getBuildNo() {
		return BuildNo;
	}

	public void setBuildNo(String buildNo) {
		BuildNo = buildNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", BuildNo=" + BuildNo + ", Street=" + Street + ", city=" + city
				+ ", State=" + State + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
