/**
 * 业务信息
 */

function showBusinessInfo1(divId) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genBusinessOption1();
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genBusinessOption1() {
	option = {
		title : {
			text : '彩红用户增长对比',
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
				type : 'shadow'
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '0',
			containLabel : true
		},
		xAxis : {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		},
		yAxis : {
			type : 'category',
			data : [ '自然增长用户', '引流入驻用户', '业务入驻用户', '活动入驻用户' ]
		},
		series : [ {
			name : '用户数',
			type : 'bar',
			barWidth : 15,
			barGap : '150%',
			itemStyle : {
				normal : {
					// 颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
					color : new echarts.graphic.LinearGradient(0, 0, 1, 0, [ {
						offset : 0,
						color : "#ffa586" // 0% 处的颜色
					}, {
						offset : 0.5,
						color : "#f98171" // 60% 处的颜色
					}, {
						offset : 1,
						color : "#f25d5a" // 100% 处的颜色
					} ], false)
				}
			},
			data : [ 500, 600, 700, 800 ]
		} ]
	};

	return option;
}

function showBusinessInfo2(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genBusinessOption2(resp.data);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genBusinessOption2(data) {
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
		}],
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
						color : "#fd81ec" // 0% 处的颜色
					}, {
						offset : 1,
						color : "#7278fd" // 100% 处的颜色
					} ], false)
				}
			},
			data : [ 2.6, 5.9, 9.0, 26.4, 28.7 ]
		}]
	};

	return option;
}