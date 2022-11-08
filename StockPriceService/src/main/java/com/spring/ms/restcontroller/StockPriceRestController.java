package com.spring.ms.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ms.entity.StockPrice;
import com.spring.ms.repo.StockPriceRepository;

@RestController
public class StockPriceRestController {

	@Autowired
	private StockPriceRepository sprepo;
	@Autowired
	private Environment env;
	
	@GetMapping("/price/{companyName}")
	public ResponseEntity<StockPrice> getStockPrice(@PathVariable String companyName ){
		StockPrice stockPrice = sprepo.findByCompanyName(companyName);
		String port = env.getProperty("server.port");
		stockPrice.setPort(port);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.OK);
		
	}
	
}
