package com.spring.cal.entity;

public class StockPrice {
	
	private Integer stockId;
	private String companyName;
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
