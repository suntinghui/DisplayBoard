package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface DeviceInfoService {

	// 激活的设备总数
	public Long deviceActiveTotal();
	
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
