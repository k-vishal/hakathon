package com.app.pojos;


import javax.persistence.*;


@Entity
@Table(name="Farmer_adv")
public class FarmerAdv {
	
	private int farmerAdvId;
	private byte[] cropImage;
	private int qtyToSale;
	private double perUnitPrice;
	//private WholesalerOrder wholesalerOrder;
	private farmerAdvStatus advStatus;
	private UserDetails userDetails;

	private String cropName;
	
//	private Set<WholesalerOrder> wholesalerOrder = new HashSet<>();

	
	FarmerAdv()
	{
		System.out.println("inside Farmer_req ctor");
	}
	
	
	


	public FarmerAdv(int farmerAdvId, byte[] cropImage, int qtyToSale, double perUnitPrice, farmerAdvStatus advStatus,
		String cropName) {
	super();
	this.farmerAdvId = farmerAdvId;
	this.cropImage = cropImage;
	this.qtyToSale = qtyToSale;
	this.perUnitPrice = perUnitPrice;
	this.advStatus = advStatus;
	this.cropName = cropName;
}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getfarmerAdvId() {
		return farmerAdvId;
	}

	public void setfarmerAdvId(Integer farmerAdvId) {
		this.farmerAdvId = farmerAdvId;
	}
	public double getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(double perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	@Lob
	@Column(columnDefinition = "longblob")
	public byte[] getCropImage() {
		return cropImage;
	}

	public void setCropImage(byte[] cropImage) {
		this.cropImage = cropImage;
	}
	@Column(length=20)
	public int getQtyToSale() {
		return qtyToSale;
	}

	public void setQtyToSale(int qtyToSale) {
		this.qtyToSale = qtyToSale;
	}

	
	  @Column(length=20) 
	 //@Enumerated(EnumType.STRING)
	  public farmerAdvStatus getAdvStatus() 
	  
	  { return advStatus;
	  }
	  
	  public void setAdvStatus(farmerAdvStatus AdvStatus)
	  { this.advStatus = AdvStatus; }
	 
   // @JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="farmer_id")
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	

	@Column(length=20) 
	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	@Override
	public String toString() {
		return "FarmerAdv [farmerAdvId=" + farmerAdvId + ", qtyToSale=" + qtyToSale + ", perUnitPrice=" + perUnitPrice
				+ ", advStatus=" + advStatus + ", cropName=" + cropName + "]";
	}



	
	
	
	


	




	/*
	 * @OneToOne(mappedBy = "farmerAdv") public WholesalerOrder getWholesalerOrder()
	 * { return wholesalerOrder; }
	 * 
	 * public void setWholesalerOrder(WholesalerOrder wholesalerOrder) {
	 * this.wholesalerOrder = wholesalerOrder; }
	 */
	

	
	
	
	
}
