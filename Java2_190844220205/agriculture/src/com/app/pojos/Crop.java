package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Crop")
public class Crop {

	private int cropId;
	private String cropName;
	
	Crop()
	{
		System.out.println("inside crop pojo");
	}

	public Crop(int cropId, String cropName) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	@Column(length=20)
	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	
}
