package com.univo.display.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.service.MainService;
import com.univo.display.service.RainbowService;
import com.univo.display.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {

	@Resource
	public MainMapper mainMapper;

	@Override
	public Long voucherTotal() {
		try {
			StringBuffer sql = new StringBuffer();

			sql.append(" select count(MLH_CPUid) as CP_num");
			sql.append(" from t_mobile_lehuo_list");
			sql.append(" where MLH_CPUid is not null");

			List<Map<String, Object>> list = mainMapper.selectBySql(new HashMap() {
				{
					put("sql", sql.toString());
				}
			});
			return (Long) list.get(0).get("CP_num");
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	@Override
	public BigDecimal voucherMoney() {
		try {
			StringBuffer sql = new StringBuffer();

			sql.append(" select sum(a.ODER_CoupMoney) as CP_money");
			sql.append(" from t_shop_order_info a join t_shop_order_detail b");
			sql.append(" on a.ODER_Uid = b.ODDT_ODUid");
			sql.append(" where cast(a.CreateDate as date) >= '2019-05-01' and a.CreateDate <= now()");
			sql.append(" and a.ODER_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1)");

			List<Map<String, Object>> list = mainMapper.selectBySql(new HashMap() {
				{
					put("sql", sql.toString());
				}
			});
			return (BigDecimal) list.get(0).get("CP_money");
		} catch (Exception e) {
			e.printStackTrace();

			return new BigDecimal(0.00);
		}
	}

}
