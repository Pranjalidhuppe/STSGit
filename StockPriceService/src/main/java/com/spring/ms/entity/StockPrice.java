package com.spring.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_PRICE_DTLS")
public class StockPrice {

	@Id
	@Column(name = "StockId")
	private Integer stockId;
	
	@Column(name = "CompanyName")
	private String companyName;
	
	@Column(name = "CompanyPrice")
	private Double companyPrice;
	
	private String port;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getCompanyPrice() {
		return companyPrice;
	}

	public void setCompanyPrice(Double companyPrice) {
		this.companyPrice = companyPrice;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}


}
