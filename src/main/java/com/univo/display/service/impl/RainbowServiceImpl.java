package com.univo.display.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.univo.display.controller.MainController;
import com.univo.display.mapper.MainMapper;
import com.univo.display.service.MainService;
import com.univo.display.service.RainbowService;

@Service
public class RainbowServiceImpl implements RainbowService {

	@Resource
	public MainMapper mainMapper;

	private static final Logger logger = LoggerFactory.getLogger(RainbowServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> users7DaysIncrease() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select date(CreateDate) as dt,count(USER_Uid) as new_caihong");
		sql.append(" from t_customer_user_info");
		sql.append(" where DATE_SUB(CURDATE(), INTERVAL 7 DAY) < date(CreateDate)");
		sql.append(" and USER_Type = 2");
		sql.append(" group by dt desc");

		return mainMapper.selectBySql(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Map<String, Object>> user7DaysActive() {
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

}
