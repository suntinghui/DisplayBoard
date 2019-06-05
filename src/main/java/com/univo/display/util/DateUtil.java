package com.univo.display.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String toDate(String str) {
		Long d = Long.parseLong(str);

		Date date = new Date(d);
		return new SimpleDateFormat("MMdd").format(date);
	}
	
	public static String toDate(java.sql.Date date) {
		return new SimpleDateFormat("MMdd").format(date);
	}

}
