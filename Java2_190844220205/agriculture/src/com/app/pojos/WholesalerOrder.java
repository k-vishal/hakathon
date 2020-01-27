package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wholesaler_order")
public class WholesalerOrder {
	
	private int wholesalerOrderId;
	private int orderQty;
	private double perUnitPrice;
	private String cropName;
	private int farmerAdvId;
	private UserDetails userDetails;
	private Date date;
	private Address shippingAddress; 
	//private Set<FarmerAdv> farmerReq = new HashSet<>();
	
	WholesalerOrder()
	{
		System.out.println("inside user_details ctor");
	}
	public WholesalerOrder(int orderQty, double perUnitPrice, String cropName, int farmerAdvId, UserDetails userDetails,
			Date date) {
		super();
		this.orderQty = orderQty;
		this.perUnitPrice = perUnitPrice;
		this.cropName = cropName;
		this.farmerAdvId = farmerAdvId;
		this.userDetails = userDetails;
		this.date = date;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getWholesalerOrderId() {
		return wholesalerOrderId;
	}

	public void setWholesalerOrderId(int wholesalerOrderId) {
		this.wholesalerOrderId = wholesalerOrderId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="wholesaler_id")
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	public double getPerUnitPrice() {
		return perUnitPrice;
	}


	public void setPerUnitPrice(double perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}


	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public int getFarmerAdvId() {
		return farmerAdvId;
	}

	public void setFarmerAdvId(int farmerAdvId) {
		this.farmerAdvId = farmerAdvId;
	}
	@Override
	public String toString() {
		return "WholesalerOrder [wholesalerOrderId=" + wholesalerOrderId + ", orderQty=" + orderQty + ", perUnitPrice="
				+ perUnitPrice + ", cropName=" + cropName + ", farmerAdvId=" + farmerAdvId + ", date=" + date + "]";
	}
	
	
	

//	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//	@JoinTable(name = "Wholesaler_farmer",joinColumns = @JoinColumn(name="wholesaler_id"),inverseJoinColumns = @JoinColumn(name="farmer_id"))
//	public Set<FarmerAdv> getFarmerReq() {
//		return farmerReq;
//	}
//
//
//	public void setFarmerReq(Set<FarmerAdv> farmerReq) {
//		this.farmerReq = farmerReq;
//	}
//	

	

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="farmerAdvId") public FarmerAdv getFarmerAdv() { return
	 * farmerAdv; }
	 * 
	 * 
	 * public void setFarmerAdv(FarmerAdv farmerAdv) { this.farmerAdv = farmerAdv; }
	 */

	
	
	
	
	
}
