package com.hackerrank.stocktrades.service;

import java.util.List;

import com.hackerrank.stocktrades.model.StockTrade;

public interface StockTradeService {

	StockTrade createStockTrade(StockTrade trade);

	List<StockTrade> getStockTrades();

	List<StockTrade> getStockTrades(String type);

	List<StockTrade> getStockTrades(Integer userId);
	
	List<StockTrade> getStockTrades(String type, Integer userId);

	StockTrade getStockTrade(Integer id);

}
