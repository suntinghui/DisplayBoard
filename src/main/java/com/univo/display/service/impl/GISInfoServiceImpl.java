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
