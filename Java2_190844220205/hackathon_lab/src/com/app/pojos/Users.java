package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	private int id;
	private String name;
	private String email;
	private int phone;
	private String password;
	private Role role;
	
	private List<Payments> payments=new ArrayList<>();
	
	private List<Issuerecord> issuerecord=new ArrayList<>();
	public Users() {
		super();
		
		System.out.println("in user ctor");
	}

	public Users(int id, String name, String email, int phone, String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	/*@OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Issuerecord> getIssuerecord() {
		return issuerecord;
	}

	public void setIssuerecord(List<Issuerecord> issuerecord) {
		this.issuerecord = issuerecord;
	}*/

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
