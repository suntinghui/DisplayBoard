package com.univo.display.controller;import java.math.BigDecimal;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.annotation.Resource;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;import com.alibaba.fastjson.JSONArray;import com.alibaba.fastjson.JSONObject;import com.univo.display.service.BusinessService;import com.univo.display.service.DeviceInfoService;import com.univo.display.service.MainService;import com.univo.display.service.RainbowService;import com.univo.display.service.TicketSellService;import com.univo.display.service.VoucherService;import com.univo.display.service.impl.TicketSellServiceImpl;import com.univo.display.util.DateUtil;@Controllerpublic class MainController {	private static final Logger logger = LoggerFactory.getLogger(MainController.class);	@Resource	private MainService mainServiceImpl;	@Resource	private DeviceInfoService deviceInfoServiceImpl;	@Resource	private RainbowService rainbowServiceImpl;	@Resource	private BusinessService businessServiceImpl;	@Resource	private VoucherService voucherServiceImpl;	@Resource	private TicketSellService ticketSellServiceImpl;	@RequestMapping("/")	public String queryCount() {		return "main";	}	@ResponseBody	@RequestMapping(value = "getDeviceInfo", produces = "application/json; charset=utf-8")	public String getDeviceInfo() {		// 各机型分别的激活设备数		List<Map<String, Object>> list1 = deviceInfoServiceImpl.deviceActiveTypeCount();		// 各机型分别的正常运行设备总数		List<Map<String, Object>> list2 = deviceInfoServiceImpl.deviceNormalTypeCount();		// 各机型分别的待检修设备总数		List<Map<String, Object>> list3 = deviceInfoServiceImpl.deviceCheckTypeCount();		logger.info(list1.toString());		logger.info(list2.toString());		logger.info(list3.toString());		JSONObject object1 = new JSONObject();		object1.put("value", 10);		object1.put("name", "正常运行");		JSONObject object2 = new JSONObject();		object2.put("value", 3);		object2.put("name", "待检修");		JSONArray array = new JSONArray();		array.add(object1);		array.add(object2);		JSONObject resp = new JSONObject();		resp.put("data", array);		logger.info(resp.toJSONString());		return resp.toJSONString();	}	@ResponseBody	@RequestMapping(value = "getRainbowInfo", produces = "application/json; charset=utf-8")	public String getRainbowInfo() {		List<Map<String, Object>> list = rainbowServiceImpl.user7DaysActive();		HashMap<String, Object> map = new HashMap<>();		ArrayList<Object> dtList = new ArrayList<>();		ArrayList<Object> totalList = new ArrayList<>();		ArrayList<Object> activeList = new ArrayList<>();		for (Map<String, Object> tempMap : list) {			if (tempMap.containsKey("DT")) {				dtList.add(DateUtil.toDate((java.sql.Date) tempMap.get("DT")));			} else {				dtList.add("");			}			if (tempMap.containsKey("Total_user")) {				totalList.add(tempMap.get("Total_user"));			} else {				totalList.add("0");			}			if (tempMap.containsKey("Activation")) {				activeList.add(tempMap.get("Activation"));			} else {				activeList.add("0.00");			}		}		map.put("DT", dtList);		map.put("Total_user", totalList);		map.put("Activation", activeList);		return JSONObject.toJSONString(map);	}	@ResponseBody	@RequestMapping(value = "getBusinessInfo", produces = "application/json; charset=utf-8")	public String getBusinessInfo() {		HashMap<String, Object> map = new HashMap<>();		Long realTimeCount = businessServiceImpl.businessCount();		map.put("realTimeCount", realTimeCount);		Long weekCount = businessServiceImpl.businessWeekCount();		map.put("weekCount", weekCount);		Long monthCount = businessServiceImpl.businessMonthCount();		map.put("monthCount", monthCount);		List<Map<String, Object>> realTimeList = businessServiceImpl.businessApply();		map.put("realTimeList", realTimeList);		List<Map<String, Object>> weeekList = businessServiceImpl.businessWeek();		map.put("weekList", weeekList);		List<Map<String, Object>> monthList = businessServiceImpl.businessMonth();		map.put("monthList", monthList);		// 下面是办理量趋势图		List<Map<String, Object>> list5 = businessServiceImpl.businessWeekCircle();		ArrayList<Object> dtList = new ArrayList<>();		ArrayList<Object> countList = new ArrayList<>();		ArrayList<Object> wowList = new ArrayList<>();		for (int i = list5.size() - 1; i >= 0; i--) {			Map<String, Object> tempMap = list5.get(i);			if (tempMap.containsKey("dt")) {				String dtStr = String.valueOf(tempMap.get("dt")).substring(4);				dtList.add("第" + dtStr + "周");			} else {				dtList.add("未知");			}			if (tempMap.containsKey("TYW_count")) {				countList.add(tempMap.get("TYW_count"));			} else {				countList.add("0");			}			if (tempMap.containsKey("WOW")) {				wowList.add(tempMap.get("WOW"));			} else {				wowList.add("0.00");			}		}		map.put("dtList", dtList);		map.put("countList", countList);		map.put("wowList", wowList);		return JSONObject.toJSONString(map);	}	@ResponseBody	@RequestMapping(value = "getTicketInfo", produces = "application/json; charset=utf-8")	public String getTicketInfo() {		HashMap<String, Object> map = new HashMap<>();		List<Map<String, Object>> list1 = ticketSellServiceImpl.ordersSale();		map.put("realtimeSellInfo", list1);		List<Map<String, Object>> list2 = ticketSellServiceImpl.ordersSaleTotal();		map.put("realtimeSellTotal", list2);		List<Map<String, Object>> list3 = ticketSellServiceImpl.lotteryLaunch();		map.put("realtimeSellCount", list3);		List<Map<String, Object>> list4 = ticketSellServiceImpl.ordersWeek();		map.put("weekSellInfo", list4);		List<Map<String, Object>> list5 = ticketSellServiceImpl.ordersWeekTotal();		map.put("weekSellTotal", list5);		List<Map<String, Object>> list6 = ticketSellServiceImpl.lotteryLaunchWeek();		map.put("weekSellCount", list6);		List<Map<String, Object>> list7 = ticketSellServiceImpl.ordersMonth();		map.put("monthSellInfo", list7);		List<Map<String, Object>> list8 = ticketSellServiceImpl.ordersMonthTotal();		map.put("monthSellTotal", list8);		List<Map<String, Object>> list9 = ticketSellServiceImpl.lotteryLaunchMonth();		map.put("monthSellCount", list9);		// 近5周周销售额和周环比		List<Map<String, Object>> list10 = ticketSellServiceImpl.ordersSaleWeekIncrease();		ArrayList<Object> dtList = new ArrayList<>();		ArrayList<Object> moneyList = new ArrayList<>();		ArrayList<Object> wowList = new ArrayList<>();		for (int i = list10.size() - 1; i >= 0; i--) {			Map<String, Object> tempMap = list10.get(i);			if (tempMap.containsKey("dt")) {				String dtStr = String.valueOf(tempMap.get("dt")).substring(4);				dtList.add("第" + dtStr + "周");			} else {				dtList.add("未知");			}			if (tempMap.containsKey("WTT_money")) {				moneyList.add(tempMap.get("WTT_money"));			} else {				moneyList.add("0");			}			if (tempMap.containsKey("WOW")) {				wowList.add(tempMap.get("WOW"));			} else {				wowList.add("0.00");			}		}		map.put("dtList", dtList);		map.put("moneyList", moneyList);		map.put("wowList", wowList);		return JSONObject.toJSONString(map);	}	@ResponseBody	@RequestMapping(value = "getVoucherInfo", produces = "application/json; charset=utf-8")	public String getVoucherInfo() {		Long total = voucherServiceImpl.voucherTotal();		BigDecimal money = voucherServiceImpl.voucherMoney();		HashMap<String, Object> map = new HashMap<String, Object>();		map.put("total", total);		map.put("money", money);		return JSONObject.toJSONString(map);	}	@ResponseBody	@RequestMapping("mobileBusiness")	public String mobileBusiness() {		List<Map<String, Object>> list = null;		list = mainServiceImpl.businessApply();		logger.info(list.toString());		list = mainServiceImpl.businessCount();		logger.info(list.toString());		list = mainServiceImpl.businessWeek();		logger.info(list.toString());		list = mainServiceImpl.businessWeekCount();		logger.info(list.toString());		list = mainServiceImpl.businessMonth();		logger.info(list.toString());		list = mainServiceImpl.businessMonthCount();		logger.info(list.toString());		list = mainServiceImpl.businessWeekCircle();		logger.info(list.toString());		list = mainServiceImpl.ordersSale();		logger.info(list.toString());		list = mainServiceImpl.ordersSaleTotal();		logger.info(list.toString());		list = mainServiceImpl.lotteryLaunch();		logger.info(list.toString());		list = mainServiceImpl.ordersWeek();		logger.info(list.toString());		list = mainServiceImpl.ordersWeekTotal();		logger.info(list.toString());		list = mainServiceImpl.lotteryLaunchWeek();		logger.info(list.toString());		list = mainServiceImpl.ordersMonth();		logger.info(list.toString());		list = mainServiceImpl.ordersMonthTotal();		logger.info(list.toString());		list = mainServiceImpl.lotteryLaunchMonth();		logger.info(list.toString());		list = mainServiceImpl.ordersSaleWeekIncrease();		logger.info(list.toString());		list = mainServiceImpl.usersWeekIncrease();		logger.info(list.toString());		return "";	}}