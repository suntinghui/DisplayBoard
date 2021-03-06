/**
 * 即开票
 */

function showTicketInfo1(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genTicketOption1(resp);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genTicketOption1(data) {
	option = {
		title : {
			text : '即开票趋势图',
			textStyle : {
				color : '#4c4c4c',
				fontWeight : 'bold',
				fontFamily : '微软雅黑',
				fontSize : '14'
			},
			left : '30',
			top : '20',
			bottom : '10'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross'
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '10',
			top : '40%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : data.dtList,
			axisTick : {
				alignWithLabel : true
			},
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		series : [ {
			name : '周销售金额',
			type : 'bar',
			barWidth : 40,
			barGap : '50%',
			itemStyle : {
				normal : {
					// 颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
					color : new echarts.graphic.LinearGradient(0, 1, 0, 0, [ {
						offset : 0,
						color : "#47a2fc" // 0% 处的颜色
					}, {
						offset : 1,
						color : "#7379fc" // 100% 处的颜色
					} ], false)
				}
			},
			data : data.moneyList,
			label : {
				normal : {
					show : true,
					position : 'top',
					align : "center",
					verticalAlign : "middle",
					formatter : function(params) {
						var tip;
						var yy = (data.wowList[params.dataIndex] - 0)*100;
						if (yy > 0) {
							tip = '{u|上升' + yy.toFixed(0) + '%}\n';
						} else {
							tip = '{d|下降' + yy.toFixed(0) + '%}\n';
						}

						return tip;
					},
					rich : {
						d : {
							color : '#1f19ce',
							fontSize : 10,
						},
						u : {
							color : '#cc5ce7',
							fontSize : 10,
						}
					}
				}
			}

		} ]
	};

	return option;
}

function showTicketInfo2(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genTicketOption2(resp.data);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genTicketOption2(data) {
	option = {
		title : {
			text : '办理量趋势图',
			textStyle : {
				color : '#4c4c4c',
				fontWeight : 'bold',
				fontFamily : '微软雅黑',
				fontSize : '14'
			},
			left : '30',
			top : '0',
			bottom : '10'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				crossStyle : {
					color : '#999'
				}
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '10',
			top : '20%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : [ '1月', '2月', '3月', '4月', '5月' ],
			axisTick : {
				alignWithLabel : true
			},
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		series : [ {
			name : '用户增长',
			type : 'bar',
			barWidth : 40,
			barGap : '50%',
			itemStyle : {
				normal : {
					// 颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
					color : new echarts.graphic.LinearGradient(0, 1, 0, 0, [ {
						offset : 0,
						color : "#7278fd" // 0% 处的颜色
					}, {
						offset : 0.5,
						color : "#41a8fc" // 50% 处的颜色
					}, {
						offset : 1,
						color : "#22c7f8" // 100% 处的颜色
					} ], false)
				}
			},
			data : [ 2.6, 5.9, 9.0, 26.4, 28.7 ]
		} ]
	};

	return option;
}