package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface RainbowService {

	// 彩红用户近7天每天新增长
	public List<Map<String, Object>> users7DaysIncrease();
		
	// 彩红用户近7天日活跃度
	public List<Map<String, Object>> user7DaysActive();
	
}
