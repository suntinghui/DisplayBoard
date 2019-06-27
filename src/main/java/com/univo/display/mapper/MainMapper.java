package com.univo.display.mapper;

import java.util.List;
import java.util.Map;

import com.univo.display.pojo.Fucai8Info;
import com.univo.display.pojo.Fucai9Info;
import com.univo.display.pojo.TicaiInfo;
import com.univo.display.pojo.YidongInfo;

public interface MainMapper {
	
	List<Map<String, Object>> selectBySql(Map<String, Object> condition);
	
	List<YidongInfo> getYidongList(Map<String, Object> condition);
	
	List<TicaiInfo> getTicaiList(Map<String, Object> condition);
	
	List<Fucai8Info> getFucai8List(Map<String, Object> condition);
	
	List<Fucai9Info> getFucai9List(Map<String, Object> condition);

}
