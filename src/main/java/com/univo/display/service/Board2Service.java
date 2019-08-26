package com.univo.display.service;

import java.util.List;
import java.util.Map;

public interface Board2Service {

	// -------------------销售额 - 设备销售

	// 日销售额
	public List<Map<String, Object>> tjk_day();

	// 周销售额
	public List<Map<String, Object>> tjk_week();

	// 周销售额
	public List<Map<String, Object>> tjk_month();

	// 历史总量
	public List<Map<String, Object>> tjk_history();

	// -------------------------销售额 - 直接销售
	// 日销售额
	public List<Map<String, Object>> hand_day();

	// 周销售额
	public List<Map<String, Object>> hand_week();

	// 周销售额
	public List<Map<String, Object>> hand_month();

	// 历史总量
	public List<Map<String, Object>> hand_history();

	// -----------------设备统计 - 当前总量
	// 实时开机数量
	public List<Map<String, Object>> current_online();

	// 实时关机数量
	public List<Map<String, Object>> current_offline();

	// 总销售额
	public List<Map<String, Object>> current_total();

	// 平均日销售额
	public List<Map<String, Object>> current_avg();

	// ---------------设备统计 - M型
	// 实时开机数量
	public List<Map<String, Object>> m_online();

	// 实时关机数量
	public List<Map<String, Object>> m_offline();

	// 总销售额
	public List<Map<String, Object>> m_total();

	// 平均日销售额
	public List<Map<String, Object>> m_avg();

	// -------------------设备统计 - D型
	// 实时开机数量
	public List<Map<String, Object>> d_online();

	// 实时关机数量
	public List<Map<String, Object>> d_offline();

	// 总销售额
	public List<Map<String, Object>> d_total();

	// 平均日销售额
	public List<Map<String, Object>> d_avg();

	// ----------------------用户统计
	// 累计总用户
	public List<Map<String, Object>> user_total();

	// 日新增用户
	public List<Map<String, Object>> user_add_day();

	// 周新增用户
	public List<Map<String, Object>> user_add_week();

	// 月新增用户
	public List<Map<String, Object>> user_add_month();

	// ---------------------------移动业务销量
	// 历史办理
	public List<Map<String, Object>> mobile_history();

	// 今日办理
	public List<Map<String, Object>> mobile_today();

	// 本周办理
	public List<Map<String, Object>> mobile_week();

	// ----------------------------渠道 - 全部机型
	// 实时开机数量
	public List<Map<String, Object>> qudao_total_online();

	// 实时关机数量
	public List<Map<String, Object>> qudao_total_offline();

	// 总销售额
	public List<Map<String, Object>> qudao_total_money();

	// 平均日销售额
	public List<Map<String, Object>> qudao_total_avg();

	// ----------------------------渠道 - M机型
	// 实时开机数量
	public List<Map<String, Object>> qudao_m_online();

	// 实时关机数量
	public List<Map<String, Object>> qudao_m_offline();

	// 总销售额
	public List<Map<String, Object>> qudao_m_money();

	// 平均日销售额
	public List<Map<String, Object>> qudao_m_avg();

	// ----------------------------渠道 - D机型
	// 实时开机数量
	public List<Map<String, Object>> qudao_d_online();

	// 实时关机数量
	public List<Map<String, Object>> qudao_d_offline();

	// 总销售额
	public List<Map<String, Object>> qudao_d_money();

	// 平均日销售额
	public List<Map<String, Object>> qudao_d_avg();

	// --------------------------进销存 - 进票额
	// 日总计
	public List<Map<String, Object>> stock_day_all();

	// 日细分
	public List<Map<String, Object>> stock_day_value();

	// 周总计
	public List<Map<String, Object>> stock_week_all();

	// 周细分
	public List<Map<String, Object>> stock_week_value();

	// 月总计
	public List<Map<String, Object>> stock_month_all();

	// 月细分
	public List<Map<String, Object>> stock_month_value();

	// --------------------------进销存 - 出库额
	// 日总计
	public List<Map<String, Object>> supply_day_all();

	// 日细分
	public List<Map<String, Object>> supply_day_value();

	// 周总计
	public List<Map<String, Object>> supply_week_all();

	// 周细分
	public List<Map<String, Object>> supply_week_value();

	// 月总计
	public List<Map<String, Object>> supply_month_all();

	// 月细分
	public List<Map<String, Object>> supply_month_value();

	// --------------------------进销存 - 前置仓余量
	// 当前余量-总计
	public List<Map<String, Object>> surply_all();

	// 当前余量-细分
	public List<Map<String, Object>> surply_value();

}
