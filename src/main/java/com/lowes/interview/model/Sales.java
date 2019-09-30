package com.lowes.interview.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="Sales")
public class Sales {
	@Id
	private Long orderId;
	private String region;
	private String country;
	private String itemType;
	private String salesChannel;
	private String priority;
	private String orderDate;
	private String shipDate;
	private Integer units;
	private Double price;
	private Double cost;
	private Double totRevenue;
	private Double totCost;
	private Double totProfit;

	public Sales() {
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getTotRevenue() {
		return totRevenue;
	}

	public void setTotRevenue(Double totRevenue) {
		this.totRevenue = totRevenue;
	}

	public Double getTotCost() {
		return totCost;
	}

	public void setTotCost(Double totCost) {
		this.totCost = totCost;
	}

	public Double getTotProfit() {
		return totProfit;
	}

	public void setTotProfit(Double totProfit) {
		this.totProfit = totProfit;
	}

	public Sales(Long orderId, String region, String country, String itemType, String salesChannel, String priority,
			String orderDate, String shipDate, Integer units, Double price, Double cost, Double totRevenue, Double totCost,
			Double totProfit) {
		super();
		this.orderId = orderId;
		this.region = region;
		this.country = country;
		this.itemType = itemType;
		this.salesChannel = salesChannel;
		this.priority = priority;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.units = units;
		this.price = price;
		this.cost = cost;
		this.totRevenue = totRevenue;
		this.totCost = totCost;
		this.totProfit = totProfit;
	}
	
	
}
