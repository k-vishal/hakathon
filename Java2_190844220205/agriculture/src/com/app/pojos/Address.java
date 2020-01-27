package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class Address {

	//private int addressId;
	private String houseNo;
	private String area, city, district,state,country;
	private String pincode ;
	
	
	Address()
	{
		System.out.println("in Address ctor");
	}


	public Address(String houseNo, String area, String city, String district, String state, String country,
			String pincode) {
		super();
		this.houseNo = houseNo;
		this.area = area;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", area=" + area + ", city=" + city + ", district=" + district
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

	
}