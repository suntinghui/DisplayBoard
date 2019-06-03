package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface MainService {

	// 截止实时各项移动增值业务办理量
	public List<Map<String, Object>> businessApply();

	// 截止实时移动增值业务累计办理量
	public List<Map<String, Object>> businessCount();

	// 本周各项移动增值业务办理量（周日-周六）
	public List<Map<String, Object>> businessWeek();

	// 本周移动增值业务累计办理量（周日-周六）
	public List<Map<String, Object>> businessWeekCount();

	// 本月各项移动增值业务办理量
	public List<Map<String, Object>> businessMonth();

	// 本月移动增值业务累计办理量
	public List<Map<String, Object>> businessMonthCount();

	// 近5周周办理理量量和周环比
	public List<Map<String, Object>> businessWeekCircle();

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

	// 彩红用户近5周每周增长
	public List<Map<String, Object>> usersWeekIncrease();
	
	// 彩红用户近7天日活跃度
	public List<Map<String, Object>> user7Days();
	
	// 激活的设备总数
	public List<Map<String, Object>> deviceActiveTotal();
	
	// 各机型分别的激活设备数
	public List<Map<String, Object>> deviceActiveTypeCount();
	
	// 正常运行的设备总数
	public List<Map<String, Object>> deviceNormalTotal();
	
	// 各机型分别的正常运行设备总数
	public List<Map<String, Object>> deviceNormalTypeCount();
	
	// 待检修的设备总数
	public List<Map<String, Object>> deviceCheckTotal();
	
	// 各机型分别的待检修设备总数
	public List<Map<String, Object>> deviceCheckTypeCount();

}
