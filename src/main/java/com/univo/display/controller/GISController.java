package com.univo.display.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.univo.display.pojo.Fucai8Info;
import com.univo.display.pojo.Fucai9Info;
import com.univo.display.pojo.QudaoInfo;
import com.univo.display.pojo.TicaiInfo;
import com.univo.display.pojo.YidongInfo;
import com.univo.display.service.GISInfoService;

@Controller
public class GISController {
	
	private static final Logger logger = LoggerFactory.getLogger(GISController.class);
	
	@Resource
	private GISInfoService gISInfoServiceImpl;
	
	@RequestMapping("/gis")
	public String queryCount() {
		return "gis";
	}
	
	@ResponseBody
	@RequestMapping(value = "getQudaoList", produces = "application/json; charset=utf-8")
	public String getQudaoList(@RequestParam("typeArr") String typeArr) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<QudaoInfo> list = gISInfoServiceImpl.getQudaoList(typeArr);
		map.put("qudao", list);
		logger.info("list {}", list.size());
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getYidongList", produces = "application/json; charset=utf-8")
	public String getYidongList(@RequestParam("typeArr") String typeArr, @RequestParam("areaArr") String areaArr) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<YidongInfo> list = gISInfoServiceImpl.getYidongList(typeArr, areaArr);
		map.put("yidong", list);
		logger.info("list {}", list.size());
		
		return JSONObject.toJSONString(map);
	}

	@ResponseBody
	@RequestMapping(value = "getTicaiList", produces = "application/json; charset=utf-8")
	public String getTicaiList(@RequestParam("areaArr") String areaArr) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<TicaiInfo> list = gISInfoServiceImpl.getTicaiList(areaArr);
		map.put("ticai", list);
		logger.info("list {}", list.size());
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getFucai8List", produces = "application/json; charset=utf-8")
	public String getFucai8List(@RequestParam("typeArr") String typeArr, @RequestParam("danjiArr") String danjiArr, @RequestParam("wangdianArr") String wangdianArr) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<Fucai8Info> list = gISInfoServiceImpl.getFucai8List(typeArr, danjiArr, wangdianArr);
		map.put("fucai8", list);
		logger.info("list {}", list.size());
		
		return JSONObject.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping(value = "getFucai9List", produces = "application/json; charset=utf-8")
	public String getFucai9List(@RequestParam("areaArr") String areaArr, @RequestParam("wangdianArr") String wangdianArr) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<Fucai9Info> list = gISInfoServiceImpl.getFucai9List(areaArr, wangdianArr);
		map.put("fucai9", list);
		logger.info("list {}", list.size());
		
		return JSONObject.toJSONString(map);
	}
}
