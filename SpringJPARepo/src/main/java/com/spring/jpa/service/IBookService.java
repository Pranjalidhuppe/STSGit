package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.entity.BookShop;


public interface IBookService {
	
	public void saveBook(BookShop Book);
	
	public void saveBookByName(String name);
	
	public List<BookShop> saveAllBooks();

	public BookShop findBybookId(Integer id);

	public List<BookShop> findBybookIdandbookName(Integer id,String name);
	
	public List<BookShop> findAllbooks();
	
	public void deleteBookById(Integer id);
	
	public void deleteBookByName(String name);
	
	public void deleteAllBooks();
	
	public List<BookShop> findByBookPriceGreaterThanEqual(Integer price);

	public List<BookShop> findByBookPrice(Integer price);

	public BookShop findByBookName(String name);

	public List<BookShop> findBybookPriceandbookName(Integer price , String name);
	
	public void updateById(Integer id , String name );

}
