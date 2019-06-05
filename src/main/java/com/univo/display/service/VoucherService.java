package com.univo.display.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VoucherService {

	// 截止实时因移动增值业务发放代金券张数
	public Long voucherTotal();

	// 截止实时代金券兑换总金额
	public BigDecimal voucherMoney();

}
