package com.spring.cal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.cal.entity.StockPrice;

@FeignClient(name = "STOCK-PRICE-API")
public interface StockPriceClient {

	@GetMapping("/price/{cname}")
	public StockPrice getStockPrice(@PathVariable String cname);
	
}
