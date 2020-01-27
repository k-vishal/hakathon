package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PRODUCT")
public class Product {

	private Integer prod_id;
	private String prod_name;
	private String Prod_desc;
	private double prod_price;
	private Integer prod_qty;
	private Date date_creation;
	private Integer cat_id;
	private CategoryPojo catategory;
	
	@Id
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	@Column(length = 20)
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	@Column(length = 50)
	public String getProd_desc() {
		return Prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		Prod_desc = prod_desc;
	}
	@Column(length = 20)
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	@Column(length = 20)
	public Integer getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(Integer prod_qty) {
		this.prod_qty = prod_qty;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	@Column(name="pk_cat_id")
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	
	
	@ManyToOne
	public CategoryPojo getCatategory() {
		return catategory;
	}
	public void setCatategory(CategoryPojo catategory) {
		this.catategory = catategory;
	}
	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", Prod_desc=" + Prod_desc + ", prod_price="
				+ prod_price + ", prod_qty=" + prod_qty + ", date_creation=" + date_creation + "]";
	}
	
	
	
}
