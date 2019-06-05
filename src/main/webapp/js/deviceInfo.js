/**
 * 设置信息
 */

function showDeviceInfo1(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genDeviceOption1(resp.data);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genDeviceOption1(data) {
	option = {
		title : {
			text : '设备运行情况',
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
		color:['#5494fe','#d261fe','#a462ff','#ffa586'],
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			bottom : '10',
			data : [ '正常运行', '待检修' ]
		},
		series : [ {
			name : '设置运行情况',
			type : 'pie',
			center : [ '50%', '50%' ],
			radius : [ '30%', '50%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : data
		} ]
	};

	return option;
}

function showDeviceInfo2(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genDeviceOption2(resp.data);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genDeviceOption2(data) {
	option = {
		title : {
			text : '',
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
		color:['#5494fe','#d261fe','#a462ff','#ffa586'],
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			bottom : '10',
			data : [ '正常运行', '待检修' ]
		},
		series : [ {
			name : '设置运行情况',
			type : 'pie',
			center : [ '50%', '50%' ],
			radius : [ '30%', '50%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : data
		} ]
	};

	return option;
}