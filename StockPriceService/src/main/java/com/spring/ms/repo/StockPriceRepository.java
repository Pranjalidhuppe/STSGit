package com.spring.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ms.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{
	
	public StockPrice findByCompanyName(String companyName);

}
