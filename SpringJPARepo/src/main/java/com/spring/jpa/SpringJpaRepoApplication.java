package com.spring.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jpa.entity.BookShop;
import com.spring.jpa.service.BookServiceImpl;

@SpringBootApplication
public class SpringJpaRepoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringJpaRepoApplication.class, args);
		
		BookServiceImpl bean = run.getBean(BookServiceImpl.class);
	
		
//		BookShop book = new BookShop("Atomic Habbits",799);
//		BookShop book1 = new BookShop("Think Like a Monk",450);
//		BookShop book2 = new BookShop("Numbers Dont Lie",599);
		
//		bean.saveBook(book1);
//		bean.saveBook(book2);
		
//		List<BookShop> bookName = bean.findByBookName("Think Like a Monk");
		
//		List<BookShop> bookName = bean.findBybookIdandbookName(3, "Numbers Dont Lie");
//		
		
		List<BookShop> allbooks = bean.findAllbooks();
		System.out.println(allbooks);
		
//		List<BookShop> list = bean.findByBookPrice(450);
//		System.out.println(list);
		
		bean.deleteBookByName("Secret");
		
//		bean.updateById(2, "Secret");
		
		
	}

}
