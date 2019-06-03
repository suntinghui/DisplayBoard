package com.univo.display.mapper;

import java.util.List;
import java.util.Map;

public interface MainMapper {
	
	List<Map<String, Object>> selectBySql(Map<String, Object> condition);

}
