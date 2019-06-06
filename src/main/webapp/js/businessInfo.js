/**
 * 业务信息
 */

function showBusinessInfo2(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genBusinessOption2(resp);
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
			data : data.dtList,
			axisTick: {
                alignWithLabel: true
            },
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		series : [ {
			name : '周办理量',
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
			data : data.countList,
			label : {
				normal : {
					show : true,
					position : 'top',
					align : "center",
					verticalAlign : "middle",
					formatter : function(params) {
						var tip;
						var yy = data.wowList[params.dataIndex] - 0;
						if (yy > 0) {
							tip = '{u|上升' + yy + '%}\n';
						} else {
							tip = '{d|下降' + yy + '%}\n';
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