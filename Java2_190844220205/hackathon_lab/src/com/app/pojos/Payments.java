package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payments")
public class Payments {
	
	private int id;
	private double amount;
	private String type;
	private Date transaction_time;
	private Date next_payment_duedate;
	
	private Users users;

	public Payments() {
		super();
	}

	public Payments(int id, double amount, String type, Date transaction_time, Date next_payment_duedate, Users users) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.transaction_time = transaction_time;
		this.next_payment_duedate = next_payment_duedate;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "transaction_time")
	public Date getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	public Date getNext_payment_duedate() {
		return next_payment_duedate;
	}

	public void setNext_payment_duedate(Date next_payment_duedate) {
		this.next_payment_duedate = next_payment_duedate;
	}

	@ManyToOne
	@JoinColumn(name = "userid")
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Payments [id=" + id + ", amount=" + amount + ", type=" + type + ", transaction_time=" + transaction_time
				+ ", next_payment_duedate=" + next_payment_duedate + ", users=" + users + "]";
	}
}
