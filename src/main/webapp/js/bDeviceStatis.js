/**
 * 设备统计
 */

function showDeviceStatis(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genDeviceStatisOpt(resp);
	console.log(option);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genDeviceStatisOpt(data) {
	option = {
		color : ['#f25d5a', '#47a2fc', '#d261f2', '#7379fe' ],
		legend : {
			top : '1',
			textStyle : {
				color : '#ffffff'
			},
		},
		grid : {
			left : '5%',
			right : '8%',
			bottom : '4%',
			top : '25%',
			containLabel : true
		},
		tooltip : {},
		dataset : {
			source : [
					[ 'product', '实时开机', '实时关机', '总销售额' ],
					[ 'M型', data['m_online'], data['m_offline'],
							data['m_total'] ],
					[ 'D型', data['d_online'], data['d_offline'],
							data['d_total'] ] ]
		},
		xAxis : {
			type : 'category',
			axisLine : {
				lineStyle : {
					color : '#fff'
				}
			},
		},
		yAxis : [ {
			axisLine : {
				lineStyle : {
					color : '#fff'
				}
			},
		}, {
			splitLine : {
				show : false
			},
			axisLine : {
				lineStyle : {
					color : '#fff'
				}
			},
		} ],
		series : [ {
			type : 'bar',
			barWidth : 20,
			label:{
            	normal: {
            		show: true,
            		color: '#fff',
            		position: 'top'
            	}
            }
		}, {
			type : 'bar',
			barWidth : 20,
			label:{
            	normal: {
            		show: true,
            		color: '#fff',
            		position: 'top'
            	}
            }
		}, {
			type : 'line',
			yAxisIndex : 1
		} ]
	};

	return option;
}