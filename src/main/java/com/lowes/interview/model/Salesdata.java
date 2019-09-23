package com.lowes.interview.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Salesdata {
	
	@GraphId
	private Long orderId;
	private String region;
	private String country;
	private String itemType;
	private String salesChannel;
	private String priority;
	private Date orderDate;
	private Date shipDate;
	private Integer units;
	private Float price;
	private Float cost;
	private Float totRevenue;
	private Float totCost;
	private Float totProfit;

	public Salesdata() {
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getTotRevenue() {
		return totRevenue;
	}

	public void setTotRevenue(Float totRevenue) {
		this.totRevenue = totRevenue;
	}

	public Float getTotCost() {
		return totCost;
	}

	public void setTotCost(Float totCost) {
		this.totCost = totCost;
	}

	public Float getTotProfit() {
		return totProfit;
	}

	public void setTotProfit(Float totProfit) {
		this.totProfit = totProfit;
	}
	
	
	
	
	
	

}
