package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface BusinessService {

	// 截止实时各项移动增值业务办理量
	public List<Map<String, Object>> businessApply();

	// 截止实时移动增值业务累计办理量
	public Long businessCount();

	// 本周各项移动增值业务办理量（周日-周六）
	public List<Map<String, Object>> businessWeek();

	// 本周移动增值业务累计办理量（周日-周六）
	public Long businessWeekCount();

	// 本月各项移动增值业务办理量
	public List<Map<String, Object>> businessMonth();

	// 本月移动增值业务累计办理量
	public Long businessMonthCount();

	// 近5周周办理理量量和周环比
	public List<Map<String, Object>> businessWeekCircle();
	
	

}
