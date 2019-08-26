/**
 * 渠道统计
 */

function showChannelStatis(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genChannelStatisOpt(resp);
	console.log(option);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genChannelStatisOpt(data) {
	option = {
			color : ['#f25d5a' ],
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    grid : {
				left : '5%',
				right : '8%',
				bottom : '4%',
				top : '3%', 
				containLabel : true
			},
		    xAxis: {
		        type: 'value',
		        axisLine: {
		        	lineStyle: {
		        		color: '#fff'
		        	}
		        }
		    },
		    yAxis: {
		        type: 'category',
		        axisLine: {
		        	lineStyle: {
		        		color: '#fff'
		        	}
		        },
		        data: data['key']
		    },
		    series: [
		        {
		            type: 'bar',
		            barWidth : 10,
		            data: data['value'],
		            label:{
		            	normal: {
		            		show: true,
		            		color: '#fff',
		            		position: 'right'
		            	}
		            }
		        }
		    ]
		};
	
	return option;
}