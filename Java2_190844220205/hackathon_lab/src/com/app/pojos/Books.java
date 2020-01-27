package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	
	private int id;
	private String name;
	private String author;
	private String subject;
	private int price;
	private String isbn;
	
	private List<Copies> copies=new ArrayList<>();

	public Books() {
		super();
	}

	public Books(int id, String name, String author, String subject, int price, String isbn, List<Copies> copies) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
		this.copies = copies;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@OneToMany(mappedBy ="books",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Copies> getCopies() {
		return copies;
	}

	public void setCopies(List<Copies> copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ ", isbn=" + isbn + ", copies=" + copies + "]";
	}
}
