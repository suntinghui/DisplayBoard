package com.univo.display.service;

import java.util.ArrayList;
import java.util.List;

import com.univo.display.pojo.Fucai8Info;
import com.univo.display.pojo.Fucai9Info;
import com.univo.display.pojo.QudaoInfo;
import com.univo.display.pojo.TicaiInfo;
import com.univo.display.pojo.YidongInfo;

public interface GISInfoService {
	
	// 获取渠道数据
	public List<QudaoInfo> getQudaoList(String typeArr);

	// 获取移动数据
	public List<YidongInfo> getYidongList(String typeArr, String areaArr);

	// 获取体彩数据
	public List<TicaiInfo> getTicaiList(String areaArr);

	// 获取福彩8数据
	public List<Fucai8Info> getFucai8List(String typeArr, String danjiArr, String wangdianArr);

	// 获取福彩9数据
	public List<Fucai9Info> getFucai9List(String areaArr, String wangdianArr);

}
