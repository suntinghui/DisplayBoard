package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface TicketSellService {

	// 截止实时各面额即开票销售情况
	public List<Map<String, Object>> ordersSale();

	// 截止实时即开票总销售⾦金金额、总销售票张
	public List<Map<String, Object>> ordersSaleTotal();

	// 截止实时即开票投放量
	public List<Map<String, Object>> lotteryLaunch();

	// 本周各面额即开票销售情况（周日-周六）
	public List<Map<String, Object>> ordersWeek();

	// 本周即开票总销售金额、总销售票张
	public List<Map<String, Object>> ordersWeekTotal();

	// 本周即开票投放量
	public List<Map<String, Object>> lotteryLaunchWeek();

	// 本月各面额即开票销售情况
	public List<Map<String, Object>> ordersMonth();

	// 本月即开票总销售金额、总销售票张
	public List<Map<String, Object>> ordersMonthTotal();

	// 本月即开票投放量
	public List<Map<String, Object>> lotteryLaunchMonth();

	// 近5周周销售额和周环比
	public List<Map<String, Object>> ordersSaleWeekIncrease();

}
