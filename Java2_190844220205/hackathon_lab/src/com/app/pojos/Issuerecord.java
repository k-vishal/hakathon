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
@Table(name = "issuerecord")
public class Issuerecord {
	
	private int id;
	private Date issue_date;
	private Date return_duedate;
	private Date return_date;
	private double fine_amount;
	
	private Users users;

	private Copies copies;
	
	public Issuerecord() {
		super();
	}

	public Issuerecord(int id, Date issue_date, Date return_duedate, Date return_date, double fine_amount,
			Users users) {
		super();
		this.id = id;
		this.issue_date = issue_date;
		this.return_duedate = return_duedate;
		this.return_date = return_date;
		this.fine_amount = fine_amount;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date")
	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "returndue_date")
	public Date getReturn_duedate() {
		return return_duedate;
	}

	public void setReturn_duedate(Date return_duedate) {
		this.return_duedate = return_duedate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public double getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}

	@ManyToOne
	@JoinColumn(name = "memberid")
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne
	@JoinColumn(name = "copyid")
	public Copies getCopies() {
		return copies;
	}

	public void setCopies(Copies copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "Issuerecord [id=" + id + ", issue_date=" + issue_date + ", return_duedate=" + return_duedate
				+ ", return_date=" + return_date + ", fine_amount=" + fine_amount + ", users=" + users + "]";
	}
}
