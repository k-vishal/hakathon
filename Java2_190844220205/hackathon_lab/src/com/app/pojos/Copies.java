package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "copies")
public class Copies {
	
	private int id;
	private int rack;
	private Status status;
	
	private List<Issuerecord> issuerecord=new ArrayList<>();

	private Books books;
	public Copies() {
		super();
	}

	public Copies(int id, int rack, Status status, List<Issuerecord> issuerecord) {
		super();
		this.id = id;
		this.rack = rack;
		this.status = status;
		this.issuerecord = issuerecord;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRack() {
		return rack;
	}

	public void setRack(int rack) {
		this.rack = rack;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "copies", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Issuerecord> getIssuerecord() {
		return issuerecord;
	}

	public void setIssuerecord(List<Issuerecord> issuerecord) {
		this.issuerecord = issuerecord;
	}

	@ManyToOne
	@JoinColumn(name = "bookid")
	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Copies [id=" + id + ", rack=" + rack + ", status=" + status + ", issuerecord=" + issuerecord + "]";
	}
}
