package com.hackerrank.stocktrades.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.service.StockTradeService;

@RestController
@RequestMapping(path = "/trades")
public class StockTradeRestController {

	@Autowired
	private StockTradeService stockTradeService;

	@PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.CREATED)
	public StockTrade createTrade(@RequestBody @Valid StockTrade stockTrade) {
		return stockTradeService.createStockTrade(stockTrade);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<StockTrade> getStockTrades(@RequestParam(required = false) String type,
			@RequestParam(required = false) Integer userId) {
		if (!StringUtils.isEmpty(type) && userId != null) {
			return stockTradeService.getStockTrades(type, userId);
		}

		if (!StringUtils.isEmpty(type) && userId == null) {
			return stockTradeService.getStockTrades(type);
		}

		if (StringUtils.isEmpty(type) && userId != null) {
			return stockTradeService.getStockTrades(userId);
		}
		return stockTradeService.getStockTrades();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StockTrade> getStockTrade(@PathVariable Integer id) {
		StockTrade stockTrade = stockTradeService.getStockTrade(id);
		if (stockTrade != null)
			return new ResponseEntity<StockTrade>(stockTrade, HttpStatus.OK);
		else
			return new ResponseEntity<StockTrade>(stockTrade, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}")
	@PutMapping(value = "/{id}")
	@PatchMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public void updateStockTrade(@PathVariable Integer id) {

	}

}