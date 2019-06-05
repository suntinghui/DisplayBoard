/**
 * 即开票
 */

function showTicketInfo1(divId) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genTicketOption1();
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genTicketOption1() {
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
			top : '40%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : [ '1月', '2月', '3月', '4月', '5月' ],
			axisPointer : {
				type : 'shadow'
			}
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
						color : "#47a2fc" // 0% 处的颜色
					}, {
						offset : 1,
						color : "#7379fc" // 100% 处的颜色
					} ], false)
				}
			},
			data : [ 2.6, 5.9, 9.0, 26.4, 28.7 ]
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
			axisPointer : {
				type : 'shadow'
			}
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