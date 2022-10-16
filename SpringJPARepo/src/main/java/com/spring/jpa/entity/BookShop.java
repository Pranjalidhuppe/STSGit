package com.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Details")
public class BookShop {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Book_ID")
Integer bookId;
@Column(name = "Book_Name")	
	String bookName;
@Column(name = "Price")		
	int price;

	@Override
public String toString() {
	return "BookShop [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + "]";
}

	public BookShop() {
	super();
}

	public BookShop( String bookName, int price) {
		super();
		
		this.bookName = bookName;
		this.price = price;
	}
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
