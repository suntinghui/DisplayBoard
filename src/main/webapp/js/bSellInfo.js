/**
 * 销售额
 */

function showSellInfo(divId, resp) {
	var chart = echarts.init(document.getElementById(divId), "shine");
	var app = {};
	var option = genSellInfoOpt(resp);
	console.log(option);
	if (option && typeof option === "object") {
		chart.setOption(option, true);
	}
}

function genSellInfoOpt(data) {
	option = {
		color : ['#f25d5a', '#47a2fc', '#d261f2', '#7379fe' ],
		legend : {
			show : true,
			textStyle : {
				color : '#ffffff'
			},
			data : [ '设备销售', '直接销售' ]
		},
		angleAxis : {
			axisLine : {
				lineStyle : {
					color : '#fff'
				}
			},
		},
		radiusAxis : {
			type : 'category',
			axisLine : {
				lineStyle : {
					color : '#fff'
				}
			},
			data : [ '日销售', '周销售', '月销售', '累计销售' ],
			z : 10
		},
		polar : {
			radius: '55%',
		},
		series : [
				{
					type : 'bar',
					data : [ data['tjk_day'], data['tjk_week'], data['tjk_month'], data['tjk_history'] ],
					coordinateSystem : 'polar',
					name : '设备销售',
					stack : 'a'
				},
				{
					type : 'bar',
					data : [ data['hand_day'], data['hand_week'], data['hand_month'], data['hand_history'] ],
					coordinateSystem : 'polar',
					name : '直接销售',
					stack : 'a'
				} ]
	};

	return option;
}