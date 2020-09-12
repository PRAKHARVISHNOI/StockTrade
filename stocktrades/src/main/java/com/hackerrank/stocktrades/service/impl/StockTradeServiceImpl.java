package com.hackerrank.stocktrades.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import com.hackerrank.stocktrades.service.StockTradeService;

@Service
public class StockTradeServiceImpl implements StockTradeService {

	@Autowired
	private StockTradeRepository stockTradeRepository;

	@Override
	public StockTrade createStockTrade(StockTrade trade) {
		return stockTradeRepository.save(trade);
	}

	@Override
	public List<StockTrade> getStockTrades() {
		List<StockTrade> stockTrades = stockTradeRepository.findAll();
		if (CollectionUtils.isEmpty(stockTrades)) {
			return Collections.emptyList();
		}
		return stockTrades;
	}

	@Override
	public List<StockTrade> getStockTrades(String type) {
		return getStockTrades().stream().filter(trade -> trade.getType().equals(type))
				.collect(Collectors.<StockTrade>toList());
	}

	@Override
	public List<StockTrade> getStockTrades(Integer userId) {
		return getStockTrades().stream().filter(trade -> trade.getUserId().equals(userId))
				.collect(Collectors.<StockTrade>toList());
	}

	@Override
	public List<StockTrade> getStockTrades(String type, Integer userId) {
		return getStockTrades().stream()
				.filter(trade -> trade.getUserId().equals(userId) && trade.getType().equals(type))
				.collect(Collectors.<StockTrade>toList());
	}

	@Override
	public StockTrade getStockTrade(Integer id) {
		return stockTradeRepository.findById(id).isPresent() ? stockTradeRepository.findById(id).get() : null;
	}

}
