package com.univo.display.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.service.BusinessService;
import com.univo.display.service.MainService;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

	@Resource
	public MainMapper mainMapper;

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> businessApply() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select MGD_Name as Product_name,count(MLH_GOODS) as YW_count ");
		sql.append(" from t_mobile_lehuo_list a left join t_mobile_goods_info b");
		sql.append(" on b.MGD_Goods= a.MLH_Goods");
		sql.append(" where cast(a.CreateDate as date) >= '2019-05-01' and a.CreateDate <= now()");
		sql.append(" group by MLH_GOODS");
		sql.append(" order by YW_count DESC");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long businessCount() {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" select count(MLH_GOODS) as YW_count");
			sql.append(" from t_mobile_lehuo_list");
			sql.append(" where cast(CreateDate as date) >= '2019-05-01' and CreateDate <= now()");

			List<Map<String, Object>> list = mainMapper.selectBySql(new HashMap() {
				{
					put("sql", sql.toString());
				}
			});
			
			logger.info("businessCount {}", list.toString());
			
			return (Long) list.get(0).get("YW_count");
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> businessWeek() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select YEARWEEK(date_format(a.CreateDate,'%Y-%m-%d')) as dt,MGD_Name as Product_name,count(MLH_GOODS) as YW_count");
		sql.append(" from t_mobile_lehuo_list a left join t_mobile_goods_info b");
		sql.append(" on b.MGD_Goods= a.MLH_Goods");
		sql.append(" where YEARWEEK(date_format(a.CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append(" group by dt,MLH_GOODS");
		sql.append(" order by YW_count DESC");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long businessWeekCount() {
		try {
			StringBuffer sql = new StringBuffer();

			sql.append(" select YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) as dt, count(MLH_GOODS) as TYW_count");
			sql.append(" from t_mobile_lehuo_list");
			sql.append(" where  YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
			sql.append(" group by dt");

			List<Map<String, Object>> list = mainMapper.selectBySql(new HashMap() {
				{
					put("sql", sql.toString());
				}
			});
			
			logger.info("businessWeekCount {}", list.toString());
			
			return (Long) list.get(0).get("TYW_count");
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> businessMonth() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select DATE_FORMAT( a.CreateDate, '%Y%m' )as dt,MGD_Name as Product_name, count(MLH_GOODS) as YW_count");
		sql.append(" from t_mobile_lehuo_list a left join t_mobile_goods_info b");
		sql.append(" on b.MGD_Goods= a.MLH_Goods");
		sql.append(" where DATE_FORMAT( a.CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		sql.append(" group by dt,MLH_GOODS");
		sql.append(" order by YW_count DESC");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long businessMonthCount() {
		try {
			StringBuffer sql = new StringBuffer();

			sql.append(" select DATE_FORMAT( CreateDate, '%Y%m' )as dt, count(MLH_GOODS) as TYW_count");
			sql.append(" from t_mobile_lehuo_list");
			sql.append(" where DATE_FORMAT( CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
			sql.append(" group by dt");

			List<Map<String, Object>> list = mainMapper.selectBySql(new HashMap() {
				{
					put("sql", sql.toString());
				}
			});
			
			logger.info("businessMonthCount {}",list.toString());
			
			return (Long) list.get(0).get("TYW_count");
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> businessWeekCircle() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select dt,TYW_count,WOW");
		sql.append(" from(select dt,TYW_count,");
		sql.append(" @student:=CASE WHEN @class <> TYW_count THEN format(((TYW_count-@class)/@class),2) ELSE 0 END AS WOW,");
		sql.append(" @class:=TYW_count AS clset");
		sql.append(" FROM");
		sql.append(" (SELECT @student:= 10) s,");
		sql.append(" (SELECT @class:= 5) c,");
		sql.append(" (select YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) as dt, count(MLH_GOODS) as TYW_count");
		sql.append(" from t_mobile_lehuo_list");
		sql.append(" where  DATE_SUB(CURDATE(), INTERVAL 60 DAY) <= date(CreateDate)");
		sql.append(" group by dt)t)p");
		sql.append(" order by dt DESC");
		sql.append(" limit 5 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

}
