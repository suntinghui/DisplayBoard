/**
 * 进销存
 */

function showInvoicingInfo(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genInvoicingInfo(resp);
	console.log(option);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genInvoicingInfo(data) {
	option = {
		color : ['#f25d5a', '#47a2fc', '#d261f2', '#7379fe' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend : {
			textStyle : {
				color : '#ffffff'
			},
			data : [ '5元', '10元', '20元' ]
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			top: '17%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			axisLine: {
	        	lineStyle: {
	        		color: '#fff'
	        	}
	        },
			data : [ '进票额', '出库额', '前置仓余量' ]
		} ],
		yAxis : [ {
			type : 'value',
			axisLine: {
	        	lineStyle: {
	        		color: '#fff'
	        	}
	        }
			
		} ],
		series : [ {
			name : '5元',
			type : 'bar',
			barWidth : 20,
			stack : '进销存',
			data : data['stock']
		}, {
			name : '10元',
			type : 'bar',
			barWidth : 20,
			stack : '进销存',
			data : data['supply'],
		}, {
			name : '20元',
			type : 'bar',
			barWidth : 20,
			stack : '进销存',
			data : data['surply']
		},

		]
	};

	return option;
}