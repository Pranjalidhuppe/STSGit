package com.spring.cal.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.cal.entity.StockPrice;
import com.spring.cal.feign.StockPriceClient;

public class StockCalcRestController {
	
	@Autowired
	private StockPriceClient spclient;
	
	@GetMapping("/calc/{cname}/{qty}")
	public ResponseEntity<String>calculate(@PathVariable String cname , @PathVariable Integer qty){
		
		StockPrice price = spclient.getStockPrice(cname);
		Double companyPrice = price.getCompanyPrice();
		String port = price.getPort();
		
		Double totalPrice = companyPrice*qty;
		
		String msg = "Total price : "+ totalPrice +" Port :: "+port ;
				
		return new ResponseEntity<String>(msg , HttpStatus.OK);
		
	}

}
