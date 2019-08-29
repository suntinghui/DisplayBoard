package com.univo.display.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.univo.display.mapper.MainMapper;
import com.univo.display.pojo.Fucai8Info;
import com.univo.display.pojo.Fucai9Info;
import com.univo.display.pojo.QudaoInfo;
import com.univo.display.pojo.TicaiInfo;
import com.univo.display.pojo.YidongInfo;
import com.univo.display.service.GISInfoService;
import com.univo.display.util.CustomerContextHolder;

@Service
public class GISInfoServiceImpl implements GISInfoService {

	private static final Logger logger = LoggerFactory.getLogger(GISInfoServiceImpl.class);

	@Resource
	public MainMapper mainMapper;
	
	@Override
	public List<QudaoInfo> getQudaoList(String typeArr) {
		if (typeArr != null) {
			typeArr = typeArr.replace("[", "(").replace("]", ")");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select p.SHOP_Title,ifnull(t.sum_mony,0) sum_mony,ifnull(t.sum_order,0) sum_order,p.SHOP_Address,p.SHOP_Position,DDI_Type ");
		sql.append("from ");
		sql.append("(select a.ODER_SPUid,sum(a.ODER_Money) sum_mony,count(a.ODER_Uid) sum_order ");
		sql.append("from t_shop_order_info a ");
		sql.append("where date(a.CreateDate)>= '2019-07-01' ");
		sql.append("and a.ODER_State = 0 ");
		sql.append("group by ODER_SPUid) t ");
		sql.append("right join ");
		sql.append("(select distinct(SHOP_Title),c.SHOP_Address,c.SHOP_Position,c.SHOP_Uid,b.DDI_Type ");
		sql.append("from t_device_sub_list a left join t_device_device_info b ");
		sql.append("on a.DSL_DUid = b.DDI_Uid ");
		sql.append("left join t_shop_shop_info c ");
		sql.append("on c.SHOP_Uid = b.DDI_SPUid ");
		sql.append("where b.DDI_SPUid in (select SHOP_Uid from t_shop_shop_info where SHOP_State = 1) ");
		sql.append("and SHOP_Title <> '公司总部' ");

		sql.append(" AND b.DDI_Type IN ");
		sql.append(typeArr);
		
		sql.append("and exists (select * from t_storage_checkout_packages e where e.device_no = b.DDI_No) ) p ");
		sql.append("on p.SHOP_Uid = t.ODER_SPUid ");
		sql.append("left join netfiance_db.t_shop_shop_info a ");
		sql.append("on a.SHOP_Uid = p.SHOP_Uid ");
		sql.append("left join netfiance_db.t_shop_agent_list b  ");
		sql.append("on a.SHOP_AGUid = b.AGNT_Uid ");

		logger.info("qudao:{}", sql);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_A);
		return mainMapper.getQudaoList(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<YidongInfo> getYidongList(String typeArr, String areaArr) {
		if (typeArr != null) {
			typeArr = typeArr.replace("[", "(").replace("]", ")");
		}

		if (areaArr != null) {
			areaArr = areaArr.replace("[", "(").replace("]", ")");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_yidong_info where type IN ");
		sql.append(typeArr);
		sql.append(" AND area IN ");
		sql.append(areaArr);

		logger.info("yidong:{}", sql);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
		return mainMapper.getYidongList(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<TicaiInfo> getTicaiList(String areaArr) {
		if (areaArr != null) {
			areaArr = areaArr.replace("[", "(").replace("]", ")");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_ticai_info where area IN ");
		sql.append(areaArr);

		logger.info("ticai:{}", sql);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);

		return mainMapper.getTicaiList(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Fucai8Info> getFucai8List(String typeArr, String danjiArr, String wangdianArr) {
		if (typeArr != null) {
			typeArr = typeArr.replace("[", "(").replace("]", ")");
		}

		if (danjiArr != null) {
			danjiArr = danjiArr.replace("[", "(").replace("]", ")");
		}

		if (wangdianArr != null) {
			wangdianArr = wangdianArr.replace("[", "(").replace("]", ")");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_fucai_info_2018 where shopType IN ");
		sql.append(typeArr);
		sql.append(" AND danji IN ");
		sql.append(danjiArr);
		sql.append(" AND wangdian IN ");
		sql.append(wangdianArr);

		logger.info("fucai8:{}", sql);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
		return mainMapper.getFucai8List(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

	@Override
	public List<Fucai9Info> getFucai9List(String areaArr, String wangdianArr) {
		if (areaArr != null) {
			areaArr = areaArr.replace("[", "(").replace("]", ")");
		}

		if (wangdianArr != null) {
			wangdianArr = wangdianArr.replace("[", "(").replace("]", ")");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_fucai_info_2019 where shopType IN ");
		sql.append(wangdianArr);
		sql.append(" AND area IN ");
		sql.append(areaArr);

		logger.info("fucai9:{}", sql);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
		return mainMapper.getFucai9List(new HashMap() {
			{
				put("sql", sql.toString());
			}
		});
	}

}
