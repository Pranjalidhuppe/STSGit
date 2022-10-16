package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.entity.BookShop;

@Repository
public interface IBookRepo extends JpaRepository<BookShop, Integer >{
	
	@Query("From BookShop")
	public void saveBook(BookShop book);
	
	@Query("From BookShop")
	public void saveBookByName(String name);
	
	@Query("From BookShop")
	public List<BookShop> saveAllBooks();
	
	@Query("From BookShop")
	public List<BookShop> findAllBooks();
	
	@Query("From BookShop where Book_Name = ?1")
	public List<BookShop> findByBookName(String name);
	
	@Query("From BookShop where Book_ID = ?1")
	public void deleteBookById(Integer id);
	
	@Transactional
	@Modifying
	@Query("delete From BookShop where Book_Name = :name")
	public void deleteBookByName(String name);
	
	@Query("From BookShop")
	public void deleteAllBooks();
	
	@Query("From BookShop where Book_ID = ?1 AND Book_Name = ?2")
	
	public List<BookShop> findBybookIdandbookName(Integer id , String name);
	
	@Query("From BookShop where Price = ?1")
	public List<BookShop>findByBookPriceGreaterThanEqual(Integer price);
	
	@Query("From BookShop where Price = ?1")
	public List<BookShop> findByBookPrice(Integer price);

	@Query("From BookShop where Price = ?1 AND Book_Name = ?2")
	public List<BookShop> findBybookPriceandbookName(Integer price , String name);

	
}
