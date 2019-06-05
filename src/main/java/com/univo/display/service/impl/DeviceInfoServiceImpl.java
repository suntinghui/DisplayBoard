package com.univo.display.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.service.DeviceInfoService;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceInfoServiceImpl.class);

	@Resource
	public MainMapper mainMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Long deviceActiveTotal() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(DDI_No) as DDI_creat");
		sql.append(" from t_device_device_info");
		sql.append(" where DDI_State =1");

		List<Map<String, Object>> list =  mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
		return (Long) list.get(0).get("DDI_creat");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> deviceActiveTypeCount() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select DDI_Type,count(DDI_No) as DDI_creat");
		sql.append(" from t_device_device_info");
		sql.append(" where DDI_State =1");
		sql.append(" group by DDI_Type");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> deviceNormalTotal() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(DDI_No) as DDI_run");
		sql.append(" from t_device_device_info");
		sql.append(" where DDI_State =1 and TIMESTAMPDIFF(MINUTE,ModifyDate, now())<=10");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> deviceNormalTypeCount() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select DDI_Type,count(DDI_No) as DDI_run");
		sql.append(" from t_device_device_info");
		sql.append(" where DDI_State =1 and TIMESTAMPDIFF(MINUTE,ModifyDate, now())<=10");
		sql.append(" group by DDI_Type");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> deviceCheckTotal() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(distinct DTL_DUid) as DDI_task");
		sql.append(" from t_device_tasks_list");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> deviceCheckTypeCount() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select DDI_Type,count(distinct b.DTL_DUid) as DDI_task");
		sql.append(" from t_device_device_info a join t_device_tasks_list b");
		sql.append(" on a.DDI_Uid=b.DTL_DUid");
		sql.append(" group by DDI_Type");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

}
