package com.univo.display.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VoucherService {

	// 厅店活动代金券累计发放张数、累计发放金额
	public List<Map<String, Object>> activeTotal();

	// 代金券累计兑换金额（元）
	public BigDecimal voucherTotalMoney();
	
	// 累计发放量（张）、累计发放金额（元）
	public List<Map<String, Object>> total();

}
