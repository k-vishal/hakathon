package com.app.pojos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="UserDetails")
//@JsonIgnoreProperties(value= {"wholesalerOrder","farmerReq"})
public class UserDetails {
	
	private int userId;
	private String password;
	private String firstName, lastName;
	private Role userRole;
	@JsonFormat(pattern = "yyyy-MM-DD", timezone = "IST")
	private Date dob;
	private String email;
	private byte[] photo;
	private String gender;
	private String status;
	private String phoneNo;
	@Embedded
	private Address address;

	private List<FarmerAdv> farmerReq = new ArrayList<>();
	private List<WholesalerOrder> wholesalerOrder = new ArrayList<>();
	private List<Course> course = new ArrayList<>();
	
	UserDetails()
	{
		System.out.println("inside user_details ctor");
	}

	public UserDetails(Integer userId, String password, String firstName, String lastName, Role userRole, Date dob,
			String email, byte[] photo, String gender, String status, String phoneNo) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.dob = dob;
		this.email = email;
		this.photo = photo;
		this.gender = gender;
		this.status = status;
		this.phoneNo=phoneNo;
		
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(length=20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="userRole",length=20)
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(length=50,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Column(length=20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	//@Enumerated(EnumType.STRING)
	@Column(name="userStatus",length=20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userDetails" , cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "userId", referencedColumnName = "userId")
	public List<FarmerAdv> getFarmerReq() {
		return farmerReq;
	}

	public void setFarmerReq(List<FarmerAdv> farmerReq) {
		this.farmerReq = farmerReq;
	}
	//helper methods
	public void addCourse(Course request)
	{
		course.add(request);
		request.setUserDetails(this);	
	}
	public void removeCourse(Course request)
	{
		course.remove(request);
		request.setUserDetails(null);	
	}
	public void addOrder(WholesalerOrder request)
	{
		wholesalerOrder.add(request);
		request.setUserDetails(this);	
	}
	public void addFarmerReq(FarmerAdv request)
	{
		farmerReq.add(request);
		request.setUserDetails(this);	
	}
	public void removeFarmerReq(FarmerAdv request)
	{
		farmerReq.remove(request);
		request.setUserDetails(null);	
	}
	
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userDetails" , cascade = CascadeType.ALL,orphanRemoval = true)
	public List<WholesalerOrder> getWholesalerOrder() {
		return wholesalerOrder;
	}

	public void setWholesalerOrder(List<WholesalerOrder> wholesalerOrder) {
		this.wholesalerOrder = wholesalerOrder;
	}
	
	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userDetails" , cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userRole=" + userRole + ", dob=" + dob + ", email=" + email + ", gender=" + gender
				+ ", status=" + status + ", phoneNo=" + phoneNo + "]";
	}

	

	
	

}