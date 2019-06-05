package com.univo.display.util;

import java.util.List;
import java.util.Map;

public class Util {
	
	/**
	 * 从 List<Map<String, Object>>里面数据
	 * @param list
	 * @param index
	 * @param key
	 * @return
	 */
	public static Long getValue(List<Map<String, Object>> list, int index, String key) {
		try {
			return (Long) list.get(index).get(key);
		} catch(Exception e) {
			return 0L;
		}
	}

}
