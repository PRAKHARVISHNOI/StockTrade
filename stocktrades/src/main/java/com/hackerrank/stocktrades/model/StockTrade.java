package com.hackerrank.stocktrades.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_TRADE")
public class StockTrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type")
	private String type;

	private Integer userId;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "shares")
	private Integer shares;

	@Column(name = "price")
	private Integer price;

	@Column(name = "timestamp")
	private Long timestamp;

	public StockTrade() {
	}

	public StockTrade(Integer id, String type, Integer userId, String symbol, Integer shares, Integer price,
			Long timestamp) {
		this.id = id;
		this.type = type;
		this.userId = userId;
		this.symbol = symbol;
		this.shares = shares;
		this.price = price;
		this.timestamp = timestamp;
	}

	public StockTrade(String type, Integer userId, String symbol, Integer shares, Integer price, Long timestamp) {
		this.type = type;
		this.userId = userId;
		this.symbol = symbol;
		this.shares = shares;
		this.price = price;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
