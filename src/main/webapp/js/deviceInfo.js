/**
 *  设置信息
 */

function showDeviceInfo(divId) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genOption();
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genOption() {
	option = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			bottom : '-10',
			data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			center: [ '50%', '40%' ],
			radius : [ '50%', '70%' ],
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
			data : [ {
				value : 335,
				name : '直接访问'
			}, {
				value : 310,
				name : '邮件营销'
			}, {
				value : 234,
				name : '联盟广告'
			}, {
				value : 135,
				name : '视频广告'
			}, {
				value : 1548,
				name : '搜索引擎'
			} ]
		} ]
	};

	return option;
}