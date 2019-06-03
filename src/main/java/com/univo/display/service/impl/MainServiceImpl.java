package com.univo.display.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.service.MainService;

@Service
public class MainServiceImpl implements MainService {

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
	public List<Map<String, Object>> businessCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(MLH_GOODS) as YW_count");
		sql.append(" from t_mobile_lehuo_list");
		sql.append(" where cast(CreateDate as date) >= '2019-05-01' and CreateDate <= now()");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
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
	public List<Map<String, Object>> businessWeekCount() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) as dt, count(MLH_GOODS) as TYW_count");
		sql.append(" from t_mobile_lehuo_list");
		sql.append(" where  YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append(" group by dt");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
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
	public List<Map<String, Object>> businessMonthCount() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select DATE_FORMAT( CreateDate, '%Y%m' )as dt, count(MLH_GOODS) as TYW_count");
		sql.append(" from t_mobile_lehuo_list");
		sql.append(" where DATE_FORMAT( CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		sql.append(" group by dt");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersSale() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ptype,sum(c.ODDT_Count) pcount,sum(c.ODDT_Money*c.ODDT_Count) as pmoney");
		sql.append(" from");
		sql.append(" (select b.COUP_Money as ptype");
		sql.append(" from t_customer_coupon_sub_info a join t_customer_coupon_info b");
		sql.append(" on a.COUPS_CPUid=b.COUP_Uid");
		sql.append(" group by b.COUP_Money) P_type join t_shop_order_detail c");
		sql.append(" on P_type.ptype = c.ODDT_Money");
		sql.append(" join t_shop_order_info d");
		sql.append(" on d.ODER_Uid = c.ODDT_ODUid");
		sql.append(" where cast(c.CreateDate as date) >= '2019-05-01' and c.CreateDate <= now()");
		sql.append(" and d.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");
		sql.append(" group by ptype");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersSaleTotal() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(b.ODDT_Count) as TT_num,sum(b.ODDT_Count*b.ODDT_Money) as TT_money");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid");
		sql.append(" where cast(a.CreateDate as date) >= '2019-05-01' and a.CreateDate <= now()");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> lotteryLaunch() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.COUP_Money as ptype,sum(a.lottery_count) as cplt_count");
		sql.append(" from t_storage_checkout_packages_detail a join t_customer_coupon_sub_info b");
		sql.append(" on left(a.lottery_start_id, 5) = b.COUPS_Prefix COLLATE utf8mb4_unicode_ci");
		sql.append(" join t_customer_coupon_info c");
		sql.append(" on b.COUPS_CPUid=c.COUP_Uid");
		sql.append(" where cast(c.CreateDate as date) >= '2019-05-01' and c.CreateDate <= now()");
		sql.append(" group by c.COUP_Money");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersWeek() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ptype,sum(c.ODDT_Count) pcount,sum(c.ODDT_Money*c.ODDT_Count) as pmoney");
		sql.append(" from");
		sql.append(" (select b.COUP_Money as ptype");
		sql.append(" from t_customer_coupon_sub_info a join t_customer_coupon_info b");
		sql.append(" on a.COUPS_CPUid=b.COUP_Uid");
		sql.append(" group by b.COUP_Money) P_type join t_shop_order_detail c");
		sql.append(" on P_type.ptype = c.ODDT_Money");
		sql.append(" join t_shop_order_info d");
		sql.append(" on d.ODER_Uid = c.ODDT_ODUid");
		sql.append(" where YEARWEEK(date_format(c.CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append(" and d.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");
		sql.append(" group by ptype");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersWeekTotal() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(b.ODDT_Count) as TT_num,sum(b.ODDT_Count*b.ODDT_Money) as TT_money");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid");
		sql.append(" where YEARWEEK(date_format(a.CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> lotteryLaunchWeek() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.COUP_Money as ptype,sum(a.lottery_count) as wplt_count");
		sql.append(" from t_storage_checkout_packages_detail a join t_customer_coupon_sub_info b");
		sql.append(" on left(a.lottery_start_id, 5) = b.COUPS_Prefix COLLATE utf8mb4_unicode_ci");
		sql.append(" join t_customer_coupon_info c");
		sql.append(" on b.COUPS_CPUid=c.COUP_Uid");
		sql.append(" where YEARWEEK(date_format(c.CreateDate,'%Y-%m-%d')) = YEARWEEK(now())");
		sql.append(" group by c.COUP_Money");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersMonth() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ptype,sum(c.ODDT_Count) pcount,sum(c.ODDT_Money*c.ODDT_Count) as pmoney");
		sql.append(" from");
		sql.append(" (select b.COUP_Money as ptype");
		sql.append(" from t_customer_coupon_sub_info a join t_customer_coupon_info b");
		sql.append(" on a.COUPS_CPUid=b.COUP_Uid");
		sql.append(" group by b.COUP_Money) P_type join t_shop_order_detail c");
		sql.append(" on P_type.ptype = c.ODDT_Money");
		sql.append(" join t_shop_order_info d");
		sql.append(" on d.ODER_Uid = c.ODDT_ODUid");
		sql.append(" where DATE_FORMAT( c.CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		sql.append(" and d.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");
		sql.append(" group by ptype");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersMonthTotal() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(b.ODDT_Count) as MTT_num,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid");
		sql.append(" where DATE_FORMAT( a.CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> lotteryLaunchMonth() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.COUP_Money as ptype,sum(a.lottery_count) as mplt_count");
		sql.append(" from t_storage_checkout_packages_detail a join t_customer_coupon_sub_info b");
		sql.append(" on left(a.lottery_start_id, 5) = b.COUPS_Prefix COLLATE utf8mb4_unicode_ci");
		sql.append(" join t_customer_coupon_info c");
		sql.append(" on b.COUPS_CPUid=c.COUP_Uid");
		sql.append(" where DATE_FORMAT( c.CreateDate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		sql.append(" group by c.COUP_Money");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> ordersSaleWeekIncrease() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select dt,WTT_money,WOW");
		sql.append(" from(select dt,WTT_money,");
		sql.append(" @student:=CASE WHEN @class <> WTT_money THEN format(((WTT_money-@class)/@class),2) ELSE 0 END AS WOW,");
		sql.append(" @class:=WTT_money AS clset");
		sql.append(" FROM");
		sql.append(" (SELECT @student:= 10) s,");
		sql.append(" (SELECT @class:= 4510) c,");
		sql.append(" (select YEARWEEK(date_format(a.CreateDate,'%Y-%m-%d')) dt,sum(b.ODDT_Count*b.ODDT_Money) as WTT_money");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid");
		sql.append(" where  DATE_SUB(CURDATE(), INTERVAL 60 DAY) <= date(a.CreateDate)");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");
		sql.append(" group by dt) t) p");
		sql.append(" order by dt DESC");
		sql.append(" limit 5 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> usersWeekIncrease() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select YEARWEEK(date_format(CreateDate,'%Y-%m-%d')) as dt,count(USER_Uid) as new_caihong");
		sql.append(" from t_customer_user_info");
		sql.append(" where DATE_SUB(CURDATE(), INTERVAL 60 DAY) <= date(CreateDate)");
		sql.append(" and USER_Type = 2");
		sql.append(" group by dt DESC");
		sql.append(" limit 5");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user7Days() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select p.dtt DT,m.act as User_log,p.ytt as Total_user,format((m.act/p.ytt),2) as Activation");
		sql.append(" from");
		sql.append(" (select date(CreateDate) dte,count(distinct UACT_USUid) as act");
		sql.append(" from t_customer_user_action_list b");
		sql.append(" where b.UACT_Action=1");
		sql.append(" group by dte) m");
		sql.append(" right join");
		sql.append(" (select date_sub(dte,interval 1 day) dtt,");
		sql.append(" @yTT:=case when @xdate>='2019-05-01' then (select sum(TT) from");
		sql.append(" (select date(CreateDate) dte,count(USER_Uid) TT");
		sql.append(" from t_customer_user_info");
		sql.append(" where date(CreateDate)>='2019-05-01'");
		sql.append(" group by dte) t");
		sql.append(" where dte<=@xdate) end as ytt,");
		sql.append(" @xdate:= dte");
		sql.append(" from");
		sql.append(" (select @yTT:=0) s,");
		sql.append(" (select @xdate:='2019-05-01' ) c,");
		sql.append(" (select date(CreateDate) dte,count(USER_Uid) TT");
		sql.append(" from t_customer_user_info");
		sql.append(" where date(CreateDate)>='2019-05-01'");
		sql.append(" group by dte) t )p");
		sql.append(" on p.dtt=m.dte");
		sql.append(" where date_sub(curdate(),interval 7 day)<=date(p.dtt)");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> deviceActiveTotal() {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(DDI_No) as DDI_creat");
		sql.append(" from t_device_device_info");
		sql.append(" where DDI_State =1");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

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
