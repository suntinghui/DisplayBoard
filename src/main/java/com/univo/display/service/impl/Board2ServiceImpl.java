package com.univo.display.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.service.Board2Service;

@Service
public class Board2ServiceImpl implements Board2Service {

	private static final Logger logger = LoggerFactory.getLogger(Board2ServiceImpl.class);

	@Resource
	public MainMapper mainMapper;

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> tjk_day() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(ODER_Money) TJK_day ");
		sql.append(" from t_shop_order_info ");
		sql.append(" where ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(CreateDate)=curdate() ");
		sql.append(" and ODER_State = 0 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> tjk_week() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(ODER_Money) TJK_week ");
		sql.append(" from t_shop_order_info ");
		sql.append(" where ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and yearweek(date(CreateDate),1) = yearweek(curdate(),1) ");
		sql.append(" and ODER_State = 0 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> tjk_month() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(ODER_Money) TJK_month ");
		sql.append(" from t_shop_order_info ");
		sql.append(" where ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date_format(date(CreateDate),'%Y%m') = date_format(curdate(),'%Y%m') ");
		sql.append(" and ODER_State = 0 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> tjk_history() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(ODER_Money) TJK_history ");
		sql.append(" from t_shop_order_info ");
		sql.append(" where ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(CreateDate) >= '2019-05-01' ");
		sql.append(" and ODER_State = 0 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> hand_day() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ifnull(sum(d.COUP_Money*b.lottery_count),0) hand_sell ");
		sql.append(" from t_storage_checkout_packages a join t_storage_checkout_packages_detail b ");
		sql.append(" on a.id = b.id ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(b.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where right(a.memo,2) = '购买' ");
		sql.append(" and date(a.created_at) = curdate() ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> hand_week() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ifnull(sum(d.COUP_Money*b.lottery_count),0) hand_sell ");
		sql.append(" from t_storage_checkout_packages a join t_storage_checkout_packages_detail b ");
		sql.append(" on a.id = b.id ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(b.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where right(a.memo,2) = '购买' ");
		sql.append(" and yearweek(date(a.created_at),1) = yearweek(curdate(),1) ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> hand_month() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ifnull(sum(d.COUP_Money*b.lottery_count),0) hand_sell ");
		sql.append(" from t_storage_checkout_packages a join t_storage_checkout_packages_detail b ");
		sql.append(" on a.id = b.id ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(b.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where right(a.memo,2) = '购买' ");
		sql.append(" and date_format(date(a.created_at),'%Y%m') = date_format(curdate(),'%Y%m') ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> hand_history() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ifnull(sum(d.COUP_Money*b.lottery_count),0) hand_sell ");
		sql.append(" from t_storage_checkout_packages a join t_storage_checkout_packages_detail b ");
		sql.append(" on a.id = b.id ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(b.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where right(a.memo,2) = '购买' ");
		sql.append(" and date(a.created_at) <= curdate() ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> current_online() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(a.DDI_Uid) online_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where ((a.DDI_Type in ('A','B','C','D') and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) <= 15) ");
		sql.append(" or (a.DDI_Type = 'M' and a.DDI_Channel is not null)) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> current_offline() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(distinct(offline_device)) offline_device ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select a.DDI_Did offline_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where ((a.DDI_Type in ('A','B','C','D') and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) > 15) ");
		sql.append(" or (a.DDI_Type = 'M' and a.DDI_Channel is null)) ");
		sql.append(" and a.DDI_Did in ");
		sql.append(" (select distinct b.DDI_Did ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and SHOP_Title <> '公司总部' ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No)    ) ) t ");
		sql.append(" where offline_device<>'' ; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> current_total() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(ODER_Money) TJK_history ");
		sql.append(" from t_shop_order_info ");
		sql.append(" where ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(CreateDate) >= '2019-05-01' ");
		sql.append(" and ODER_State = 0 ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> current_avg() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select round(avg(aver_day),1) 单台日均 ");
		sql.append(" from ");
		sql.append(" (select 厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by SHOP_Title) t ");
		sql.append(" order by aver_day desc) roll ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> m_online() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(a.DDI_Uid) M_online_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where  (a.DDI_Type = 'M' and a.DDI_Channel is not null) ");
		sql.append(" and a.DDI_Did in (select distinct b.DDI_Did ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and SHOP_Title <> '公司总部' ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No)); ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> m_offline() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(distinct(M_offline_device)) M_offline_device ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select a.DDI_Did M_offline_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where  (a.DDI_Type = 'M' and a.DDI_Channel is null) ");
		sql.append(" and a.DDI_Did in ");
		sql.append(" (select distinct b.DDI_Did ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and SHOP_Title <> '公司总部' ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No)    ) ) t ");
		sql.append(" where M_offline_device<>'' ; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> m_total() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(a.ODER_Money) M_TJK_history ");
		sql.append(" from t_shop_order_info a join t_device_device_info b ");
		sql.append(" on a.ODER_DUid = b.DDI_Uid ");
		sql.append(" where a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(a.CreateDate) >= '2019-05-01' ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and b.DDI_Type = 'M' ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> m_avg() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select round(avg(aver_day),1) M单台日均 ");
		sql.append(" from ");
		sql.append(" (select 厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'M' ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by SHOP_Title) t ");
		sql.append(" order by aver_day desc) roll ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> d_online() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(a.DDI_Uid) D_online_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where  (a.DDI_Type = 'D' and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) <= 15) ");
		sql.append(" and a.DDI_Did in (select distinct b.DDI_Did ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and SHOP_Title <> '公司总部' ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No)) ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> d_offline() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(distinct(D_offline_device)) D_offline_device ");
		sql.append(" from ");
		sql.append(" (select a.DDI_Did D_offline_device ");
		sql.append(" from t_device_device_info a ");
		sql.append(" where  (a.DDI_Type = 'D' and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) > 15) ");
		sql.append(" and a.DDI_Did in (select distinct b.DDI_Did ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and SHOP_Title <> '公司总部' ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No)   ) )t ");
		sql.append(" where D_offline_device <> ''; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> d_total() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sum(a.ODER_Money) D_TJK_history ");
		sql.append(" from t_shop_order_info a join t_device_device_info b ");
		sql.append(" on a.ODER_DUid = b.DDI_Uid ");
		sql.append(" where a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(a.CreateDate) >= '2019-05-01' ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and b.DDI_Type = 'D' ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> d_avg() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select round(avg(aver_day),1) D单台日均 ");
		sql.append(" from ");
		sql.append(" (select 厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'D' ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by SHOP_Title) t ");
		sql.append(" order by aver_day desc) roll ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user_total() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select accum ");
		sql.append(" from ");
		sql.append(" (select *,(@accu:= @accu+用户数) as accum ");
		sql.append(" from ");
		sql.append(" (select @accu:=0) d, ");
		sql.append(" (select cast(CreateDate as date) as 日期, count(*) as 用户数 ");
		sql.append(" from t_customer_user_info ");
		sql.append(" where user_type = 2 and CreateDate >= '2019-04-30' ");
		sql.append(" group by 1) t    )o ");
		sql.append(" where 日期 = curdate() ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user_add_day() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) as 新增用户数 ");
		sql.append(" from t_customer_user_info ");
		sql.append(" where user_type = 2 and date(CreateDate) = curdate() ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user_add_week() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) as 周新增用户数 ");
		sql.append(" from t_customer_user_info ");
		sql.append(" where user_type = 2 and yearweek(date(CreateDate),1) = yearweek(curdate(),1) ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user_add_month() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) as 月新增用户数 ");
		sql.append(" from t_customer_user_info ");
		sql.append(" where user_type = 2 and date_format(date(CreateDate),'%Y%m') = date_format(curdate(),'%Y%m')  ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> mobile_history() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select MGD_Name 业务名称,sum(count_service) 历史办理量  ");
		sql.append(" from  ");
		sql.append(" (select d.SHOP_Title,b.MGD_Name,count(b.MGD_Name) count_service  ");
		sql.append(" from t_mobile_lehuo_list a join t_mobile_goods_info b  ");
		sql.append(" on a.MLH_Goods = b.MGD_Goods  ");
		sql.append(" join t_device_device_info c  ");
		sql.append(" on c.DDI_No = a.MLH_Source  ");
		sql.append(" join t_shop_shop_info d  ");
		sql.append(" on d.SHOP_Uid = c.DDI_SPUid  ");
		sql.append(" where date(a.CreateDate) <= curdate()  ");
		sql.append(" group by SHOP_Title,MGD_Name         ) t  ");
		sql.append(" group by MGD_Name  ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> mobile_today() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select MGD_Name 业务名称,sum(count_service) 日办理量 ");
		sql.append(" from ");
		sql.append(" (select d.SHOP_Title,b.MGD_Name,count(b.MGD_Name) count_service ");
		sql.append(" from t_mobile_lehuo_list a join t_mobile_goods_info b ");
		sql.append(" on a.MLH_Goods = b.MGD_Goods ");
		sql.append(" join t_device_device_info c ");
		sql.append(" on c.DDI_No = a.MLH_Source ");
		sql.append(" join t_shop_shop_info d ");
		sql.append(" on d.SHOP_Uid = c.DDI_SPUid ");
		sql.append(" where date(a.CreateDate) = curdate() ");
		sql.append(" group by SHOP_Title,MGD_Name         ) t ");
		sql.append(" group by MGD_Name ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> mobile_week() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select MGD_Name 业务名称,sum(count_service) 周办理量 ");
		sql.append(" from ");
		sql.append(" (select d.SHOP_Title,b.MGD_Name,count(b.MGD_Name) count_service ");
		sql.append(" from t_mobile_lehuo_list a join t_mobile_goods_info b ");
		sql.append(" on a.MLH_Goods = b.MGD_Goods ");
		sql.append(" join t_device_device_info c ");
		sql.append(" on c.DDI_No = a.MLH_Source ");
		sql.append(" join t_shop_shop_info d ");
		sql.append(" on d.SHOP_Uid = c.DDI_SPUid ");
		sql.append(" where yearweek(date(a.CreateDate),1) = yearweek(curdate(),1) ");
		sql.append(" group by SHOP_Title,MGD_Name         ) t ");
		sql.append(" group by MGD_Name ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_total_online() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) online_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where ((a.DDI_Type in ('A','B','C','D') and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) <= 15) ");
		sql.append(" or (a.DDI_Type = 'M' and a.DDI_Channel is not null)) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});

	}

	@Override
	public List<Map<String, Object>> qudao_total_offline() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) offline_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where ((a.DDI_Type in ('A','B','C','D') and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) > 15) ");
		sql.append(" or (a.DDI_Type = 'M' and a.DDI_Channel is null)) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_total_money() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select c.AGNT_Title,sum(a.ODER_Money) TJK_history_class ");
		sql.append(" from t_shop_order_info a join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.ODER_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(a.CreateDate) >= '2019-05-01' ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_total_avg() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select AGNT_Title,round(avg(aver_day),1) 单台日均 ");
		sql.append(" from ");
		sql.append(" (select AGNT_Title,厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select f.AGNT_Title,c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" left join netfiance_db.t_shop_shop_info e ");
		sql.append(" on a.ODER_SPUid = e.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list f ");
		sql.append(" on e.SHOP_AGUid = f.AGNT_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by AGNT_Title,厅店名称) t    ) roll ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_m_online() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) online_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where  (a.DDI_Type = 'M' and a.DDI_Channel is not null) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_m_offline() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) offline_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where  (a.DDI_Type = 'M' and a.DDI_Channel is null) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_m_money() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.AGNT_Title,sum(a.ODER_Money)  TJK_history_class_M ");
		sql.append(" from t_shop_order_info a join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.ODER_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" where a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(a.CreateDate) >= '2019-05-01' ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'M' ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_m_avg() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select AGNT_Title,round(avg(aver_day),1) M单台日均 ");
		sql.append(" from ");
		sql.append(" (select AGNT_Title,厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select f.AGNT_Title,c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" left join netfiance_db.t_shop_shop_info e ");
		sql.append(" on a.ODER_SPUid = e.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list f ");
		sql.append(" on e.SHOP_AGUid = f.AGNT_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'M' ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by AGNT_Title,厅店名称) t    ) roll ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_d_online() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) online_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where (a.DDI_Type in ('D') and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) <= 15 ) ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_d_offline() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.AGNT_Title,count(a.DDI_Uid) offline_device ");
		sql.append(" from t_device_device_info a left join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.DDI_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" where a.DDI_Type ='D' and TIMESTAMPDIFF(MINUTE,a.ModifyDate,now()) > 15 ");
		sql.append(" and exists (select * from t_storage_checkout_packages e where e.device_no = a.DDI_No) ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_d_money() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select c.AGNT_Title,sum(a.ODER_Money) TJK_history_class_D ");
		sql.append(" from t_shop_order_info a join netfiance_db.t_shop_shop_info b  ");
		sql.append(" on a.ODER_SPUid = b.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list c  ");
		sql.append(" on b.SHOP_AGUid = c.AGNT_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" where a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" and date(a.CreateDate) >= '2019-05-01' ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'D' ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> qudao_d_avg() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select AGNT_Title,round(avg(aver_day),1) D单台日均 ");
		sql.append(" from ");
		sql.append(" (select AGNT_Title,厅店名称,开机天数,MTT_money,round(MTT_money/开机天数,1) as aver_day ");
		sql.append(" from ");
		sql.append(" (select f.AGNT_Title,c.SHOP_Title 厅店名称,datediff(curdate(),date(c.CreateDate)) 开机天数,sum(b.ODDT_Count*b.ODDT_Money) as MTT_money ");
		sql.append(" from t_shop_order_info a join t_shop_order_detail b ");
		sql.append(" on a.ODER_Uid = b.ODDT_ODUid ");
		sql.append(" join t_shop_shop_info c ");
		sql.append(" on a.ODER_SPUid = c.SHOP_Uid ");
		sql.append(" join t_device_device_info d ");
		sql.append(" on a.ODER_DUid = d.DDI_Uid ");
		sql.append(" left join netfiance_db.t_shop_shop_info e  ");
		sql.append(" on a.ODER_SPUid = e.SHOP_Uid ");
		sql.append(" left join netfiance_db.t_shop_agent_list f  ");
		sql.append(" on e.SHOP_AGUid = f.AGNT_Uid ");
		sql.append(" where date(a.CreateDate) >= '2019-05-01' and date(a.CreateDate) < curdate() ");
		sql.append(" and a.ODER_State = 0 ");
		sql.append(" and d.DDI_Type = 'D' ");
		sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" group by AGNT_Title,厅店名称) t    ) roll ");
		sql.append(" group by AGNT_Title ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_day_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ifnull(sum(d.COUP_Money*a.lottery_count),0) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where date(a.created_at) = curdate() ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_day_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select d.COUP_Money,sum(d.COUP_Money*a.lottery_count) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where date(a.created_at) = curdate() ");
		sql.append(" group by COUP_Money ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_week_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(d.COUP_Money*a.lottery_count) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where yearweek(date(a.created_at),1) = yearweek(curdate(),1)  ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_week_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select d.COUP_Money,sum(d.COUP_Money*a.lottery_count) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where yearweek(date(a.created_at),1) = yearweek(curdate(),1) ");
		sql.append(" group by COUP_Money ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_month_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(d.COUP_Money*a.lottery_count) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where date_format(date(a.created_at),'%Y%m') = date_format(curdate(),'%Y%m')  ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> stock_month_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select d.COUP_Money,sum(d.COUP_Money*a.lottery_count) stock_value ");
		sql.append(" from t_storage_checkin_list a ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(a.lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" where date_format(date(a.created_at),'%Y%m') = date_format(curdate(),'%Y%m') ");
		sql.append(" group by COUP_Money ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_day_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(supply_value) T_supply_value ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and date(a.created_at) = curdate() ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_day_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select COUP_Money,sum(supply_value) supply_value ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and date(a.created_at) = curdate() ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");
		sql.append(" group by COUP_Money; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_week_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(supply_value) T_supply_value_week ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and yearweek(date(a.created_at),1) = yearweek(curdate(),1) ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_week_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select COUP_Money,sum(supply_value) supply_value_week ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and yearweek(date(a.created_at),1) = yearweek(curdate(),1) ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");
		sql.append(" group by COUP_Money; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_month_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(supply_value) T_supply_value_month ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and date_format(date(a.created_at),'%Y%m') = date_format(curdate(),'%Y%m') ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> supply_month_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select COUP_Money,sum(supply_value) supply_value_month ");
		sql.append(" from ");
		sql.append(" ( ");
		sql.append(" select f.SHOP_Title,e.DDI_Type,d.COUP_Title,d.COUP_Money,sum(d.COUP_Money*a.lottery_count) supply_value ");
		sql.append(" from t_storage_checkout_packages_detail a left join t_device_sub_list b ");
		sql.append(" on a.warehouse_id = b.DSL_Uid ");
		sql.append(" join t_customer_coupon_sub_info c ");
		sql.append(" on left(lottery_start_id, 5) COLLATE utf8mb4_unicode_ci = c.`COUPS_Prefix` ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on d.COUP_Uid = c.COUPS_CPUid ");
		sql.append(" join t_device_device_info e ");
		sql.append(" on e.DDI_Uid = b.DSL_DUid ");
		sql.append(" join t_shop_shop_info f ");
		sql.append(" on f.SHOP_Uid = e.DDI_SPUid ");
		sql.append(" where f.SHOP_State = 1 ");
		sql.append(" and date_format(date(a.created_at),'%Y%m') = date_format(curdate(),'%Y%m') ");
		sql.append(" group by SHOP_Title,COUP_Title,COUP_Money   ) o ");
		sql.append(" group by COUP_Money; ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> surply_all() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select sum(DSL_Count) 余票数量 ");
		sql.append(" from ");
		sql.append(" (select b.DDI_No,c.SHOP_Title,a.DSL_No,a.DSL_Count,d.COUP_Money ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on a.DSL_CPUid = d.COUP_Uid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" order by SHOP_Title,DSL_No  ) t ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> surply_value() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select COUP_Money 票面值,sum(DSL_Count) 余票数量 ");
		sql.append(" from ");
		sql.append(" (select b.DDI_No,c.SHOP_Title,a.DSL_No,a.DSL_Count,d.COUP_Money ");
		sql.append(" from t_device_sub_list a left join t_device_device_info b ");
		sql.append(" on a.DSL_DUid = b.DDI_Uid ");
		sql.append(" left join t_shop_shop_info c ");
		sql.append(" on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append(" join t_customer_coupon_info d ");
		sql.append(" on a.DSL_CPUid = d.COUP_Uid ");
		sql.append(" where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append(" order by SHOP_Title,DSL_No  ) t ");
		sql.append(" group by COUP_Money ");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

}
