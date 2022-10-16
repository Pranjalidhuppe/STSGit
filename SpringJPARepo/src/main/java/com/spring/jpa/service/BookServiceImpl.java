package com.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.entity.BookShop;
import com.spring.jpa.repository.IBookRepo;

@Service
public class BookServiceImpl implements IBookService{
	
  @Autowired
	private IBookRepo repository;
   
	public BookServiceImpl(IBookRepo repository) {
	super();
	this.repository = repository;
}
	@Override
	public List<BookShop> findBybookIdandbookName(Integer id ,String name) {
		List<BookShop> list = repository.findBybookIdandbookName(id, name);
	
		return list;
	}

	@Override
	public List<BookShop> findByBookPriceGreaterThanEqual(Integer price) {
		
		List<BookShop> greaterThanEqual = repository.findByBookPriceGreaterThanEqual(price);
		
		return greaterThanEqual;
	}

	@Override
	public List<BookShop> findByBookPrice(Integer price) {
		
		List<BookShop> byBookPrice = repository.findByBookPrice(price);
		
		return byBookPrice;
	}

	@Override
	public List<BookShop>findByBookName(String name) {
		List<BookShop> bookName = repository.findByBookName(name);

		return bookName;
	}

	@Override
	public List<BookShop> findBybookPriceandbookName(Integer price , String name) {
		List<BookShop> priceandbookName = repository.findBybookPriceandbookName(price, name);
		
		return priceandbookName;
	}

	@Override
	public BookShop findBybookId(Integer id) {
		BookShop id2 = repository.findById(id).orElse(null);
		return id2;
	}

	@Override
	public void saveBook(BookShop book) {
		//repository.saveBook(book);
		repository.save(book);
	}

	@Override
	public void saveBookByName(String name) {
		repository.saveBookByName(name);
		
	}

	@Override
	public List<BookShop> saveAllBooks() {
		List<BookShop> allBooks = repository.saveAllBooks();
		
		return allBooks;
	}

	@Override
	public List<BookShop> findAllbooks() {
		List<BookShop> allBooks = repository.findAllBooks();
		return allBooks;
	}

	@Override
	public void deleteBookById(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void deleteBookByName(String name) {
		repository.deleteBookByName(name);
		
	}

	@Override
	public void deleteAllBooks() {
		repository.deleteAllBooks();
		
	}
	

}
