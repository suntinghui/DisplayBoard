package com.univo.display.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.univo.display.pojo.QudaoInfo;
import com.univo.display.service.Board2Service;
import com.univo.display.service.GISInfoService;

@Controller
public class Board2Controller {

	private static final Logger logger = LoggerFactory.getLogger(Board2Controller.class);

	@Resource
	private Board2Service board2ServiceImpl;

	@Resource
	private GISInfoService gISInfoServiceImpl;

	@RequestMapping("/")
	public String startApp() {
		return "board2";
	}

	@ResponseBody
	@RequestMapping(value = "getQudaoList2", produces = "application/json; charset=utf-8")
	public String getQudaoList2(@RequestParam("typeArr") String typeArr) {
		HashMap<String, Object> map = new HashMap<>();

		List<QudaoInfo> list = gISInfoServiceImpl.getQudaoList(typeArr);
		map.put("qudao", list);
		logger.info("list {}", list.size());

		return JSONObject.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping(value = "getSellInfo", produces = "application/json; charset=utf-8")
	public String getSellInfo() {
		List<Map<String, Object>> tjk_day = board2ServiceImpl.tjk_day();
		List<Map<String, Object>> tjk_week = board2ServiceImpl.tjk_week();
		List<Map<String, Object>> tjk_month = board2ServiceImpl.tjk_month();
		List<Map<String, Object>> tjk_history = board2ServiceImpl.tjk_history();

		List<Map<String, Object>> hand_day = board2ServiceImpl.hand_day();
		List<Map<String, Object>> hand_week = board2ServiceImpl.hand_week();
		List<Map<String, Object>> hand_month = board2ServiceImpl.hand_month();
		List<Map<String, Object>> hand_history = board2ServiceImpl.hand_history();

		HashMap<String, Object> map = new HashMap<>();
		map.put("tjk_day", tjk_day.get(0).get("TJK_day"));
		map.put("tjk_week", tjk_week.get(0).get("TJK_week"));
		map.put("tjk_month", tjk_month.get(0).get("TJK_month"));
		map.put("tjk_history", tjk_history.get(0).get("TJK_history"));
		map.put("hand_day", hand_day.get(0).get("hand_sell"));
		map.put("hand_week", hand_week.get(0).get("hand_sell"));
		map.put("hand_month", hand_month.get(0).get("hand_sell"));
		map.put("hand_history", hand_history.get(0).get("hand_sell"));

		return JSONObject.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping(value = "getDeviceStatis", produces = "application/json; charset=utf-8")
	public String getDeviceStatis() {
		List<Map<String, Object>> m_online = board2ServiceImpl.m_online();
		List<Map<String, Object>> m_offline = board2ServiceImpl.m_offline();
		List<Map<String, Object>> m_avg = board2ServiceImpl.m_avg();
		List<Map<String, Object>> m_total = board2ServiceImpl.m_total();

		List<Map<String, Object>> d_online = board2ServiceImpl.d_online();
		List<Map<String, Object>> d_offline = board2ServiceImpl.d_offline();
		List<Map<String, Object>> d_avg = board2ServiceImpl.d_avg();
		List<Map<String, Object>> d_total = board2ServiceImpl.d_total();

		HashMap<String, Object> map = new HashMap<>();
		map.put("m_online", m_online.get(0).get("M_online_device"));
		map.put("m_offline", m_offline.get(0).get("M_offline_device"));
		map.put("m_avg", m_avg.get(0).get("M单台日均"));
		map.put("m_total", m_total.get(0).get("M_TJK_history"));
		map.put("d_online", d_online.get(0).get("D_online_device"));
		map.put("d_offline", d_offline.get(0).get("D_offline_device"));
		map.put("d_avg", d_avg.get(0).get("D单台日均"));
		map.put("d_total", d_total.get(0).get("D_TJK_history"));

		return JSONObject.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping(value = "getChannelMStatis", produces = "application/json; charset=utf-8")
	public String getChannelMStatis() {
		List<Map<String, Object>> m_total = board2ServiceImpl.qudao_m_money();

		ArrayList<String> keyList = new ArrayList<>();
		ArrayList<String> valueList = new ArrayList<>();

		try {
			// 遍历M型
			for (Map<String, Object> map : m_total) {
				keyList.add(new String(((byte[]) map.get("AGNT_Title")), "utf-8"));
				valueList.add(((BigDecimal) map.get("TJK_history_class_M")).stripTrailingZeros().toPlainString());
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("key", keyList);
		map.put("value", valueList);
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getChannelDStatis", produces = "application/json; charset=utf-8")
	public String getChannelDStatis() {
		List<Map<String, Object>> d_total = board2ServiceImpl.qudao_d_money();

		ArrayList<String> keyList = new ArrayList<>();
		ArrayList<String> valueList = new ArrayList<>();

		try {
			// 遍历D型
			for (Map<String, Object> map : d_total) {
				keyList.add(new String(((byte[]) map.get("AGNT_Title")), "utf-8"));
				valueList.add(((BigDecimal) map.get("TJK_history_class_D")).stripTrailingZeros().toPlainString());
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("key", keyList);
		map.put("value", valueList);
		

		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserInfo", produces = "application/json; charset=utf-8")
	public String getUserInfo() {
		List<Map<String, Object>> user_add_day = board2ServiceImpl.user_add_day();
		List<Map<String, Object>> user_add_week = board2ServiceImpl.user_add_week();
		List<Map<String, Object>> user_add_month = board2ServiceImpl.user_add_month();
		List<Map<String, Object>> user_total = board2ServiceImpl.user_total();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("user_add_day", user_add_day.get(0).get("新增用户数"));
		map.put("user_add_week", user_add_week.get(0).get("周新增用户数"));
		map.put("user_add_month", user_add_month.get(0).get("月新增用户数"));
		map.put("user_total", user_total.get(0).get("accum"));
		
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getInvoicingInfo", produces = "application/json; charset=utf-8")
	public String getInvoicingInfo() {
		List<Map<String, Object>> stock_value = board2ServiceImpl.stock_month_value();
		List<Map<String, Object>> supply_value = board2ServiceImpl.supply_month_value();
		List<Map<String, Object>> surply_value = board2ServiceImpl.surply_value();
		
		HashMap<String, ArrayList> map = new HashMap<>();
		map.put("stock", new ArrayList<String>(Arrays.asList("0", "0", "0")));
		map.put("supply", new ArrayList<String>(Arrays.asList("0", "0", "0")));
		map.put("surply", new ArrayList<String>(Arrays.asList("0", "0", "0")));
		
		for (Map<String, Object> temp : stock_value) {
			if (temp.get("COUP_Money").toString().equals("5")) {
				map.get("stock").set(0, temp.get("stock_value"));
			} else if (temp.get("COUP_Money").toString().equals("10")) {
				map.get("stock").set(1, temp.get("stock_value"));
			}  else if (temp.get("COUP_Money").toString().equals("20")) {
				map.get("stock").set(2, temp.get("stock_value"));
			} 
		}
		
		for (Map<String, Object> temp : supply_value) {
			if (temp.get("COUP_Money").toString().equals("5")) {
				map.get("supply").set(0, temp.get("supply_value_month"));
			} else if (temp.get("COUP_Money").toString().equals("10")) {
				map.get("supply").set(1, temp.get("supply_value_month"));
			}  else if (temp.get("COUP_Money").toString().equals("20")) {
				map.get("supply").set(2, temp.get("supply_value_month"));
			} 
		}
		
		for (Map<String, Object> temp : surply_value) {
			if (temp.get("票面值").toString().equals("5")) {
				map.get("surply").set(0, temp.get("余票数量"));
			} else if (temp.get("票面值").toString().equals("10")) {
				map.get("surply").set(1, temp.get("余票数量"));
			}  else if (temp.get("票面值").toString().equals("20")) {
				map.get("surply").set(2, temp.get("余票数量"));
			} 
		}
		
		return JSONObject.toJSONString(map);
	}

}
