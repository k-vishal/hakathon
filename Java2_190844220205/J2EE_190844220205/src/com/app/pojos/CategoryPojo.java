package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_CATEGORY")
public class CategoryPojo {
	
private Integer cat_id;
private String cat_name;

private List<Product> list= new ArrayList<>();


public CategoryPojo()
{
	System.out.println("inside ctor of "+getClass().getName());
}


public CategoryPojo(Integer cat_id, String cat_name) {
	super();
	this.cat_id = cat_id;
	this.cat_name = cat_name;
}
@Id
public Integer getCat_id() {
	return cat_id;
}
public void setCat_id(Integer cat_id) {
	this.cat_id = cat_id;
}
@Column(length = 20)
public String getCat_name() {
	return cat_name;
}

public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}


@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true )
public List<Product> getList() {
	return list;
}

public void setList(List<Product> list) {
	this.list = list;
}
//helper method
public void addProduct(Product p)
{
	list.add(p);
	p.setCatategory(this);
}
public void removeProduct(Product p)
{
	list.remove(p);
	p.setCatategory(null);
}



@Override
public String toString() {
	return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + "]";
}



}






