var yidong_typeData = [{
	"id": "专区",
	"name": "专区"
}, {
	"id": "业务代办点",
	"name": "业务代办点"
}, {
	"id": "号卡直供（商）",
	"name": "号卡直供（商）"
}, {
	"id": "号卡直供（店）",
	"name": "号卡直供（店）"
}, {
	"id": "合作厅",
	"name": "合作厅"
}, {
	"id": "大卖场",
	"name": "大卖场"
}, {
	"id": "委托加盟",
	"name": "委托加盟"
}, {
	"id": "家宽包干渠道",
	"name": "家宽包干渠道"
}, {
	"id": "引商入柜",
	"name": "引商入柜"
}, {
	"id": "手机卖场店",
	"name": "手机卖场店"
}, {
	"id": "授权代理店（点）",
	"name": "授权代理店（点）"
}, {
	"id": "终端分销",
	"name": "终端分销"
}, {
	"id": "营销活动渠道",
	"name": "营销活动渠道"
}, {
	"id": "零售",
	"name": "零售"
}];

function getYidongTypeKeyArr() {
	var arr = new Array();
	for (var index in yidong_typeData) {
		arr.push(yidong_typeData[index]['id'])
	}
	
	return arr;
}

var yidong_areaData = [{
	"id": "城区一分公司",
	"name": "城区一分公司"
}, {
	"id": "城区二分公司",
	"name": "城区二分公司"
}, {
	"id": "城区三分公司",
	"name": "城区三分公司"
}, {
	"id": "大兴分公司",
	"name": "大兴分公司"
}, {
	"id": "密云分公司",
	"name": "密云分公司"
}, {
	"id": "市场经营部",
	"name": "市场经营部"
}, {
	"id": "平谷分公司",
	"name": "平谷分公司"
}, {
	"id": "延庆分公司",
	"name": "延庆分公司"
}, {
	"id": "怀柔分公司",
	"name": "怀柔分公司"
}, {
	"id": "房山分公司",
	"name": "房山分公司"
}, {
	"id": "昌平分公司",
	"name": "昌平分公司"
}, {
	"id": "通州分公司",
	"name": "通州分公司"
}, {
	"id": "顺义分公司",
	"name": "顺义分公司"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getYidongAreaKeyArr() {
	var arr = new Array();
	for (var index in yidong_areaData) {
		arr.push(yidong_areaData[index]['id'])
	}
	
	return arr;
}

var ticai_areaData = [{
	"id": "东城",
	"name": "东城"
}, {
	"id": "丰台",
	"name": "丰台"
}, {
	"id": "大兴",
	"name": "大兴"
}, {
	"id": "密云",
	"name": "密云"
}, {
	"id": "平谷",
	"name": "平谷"
}, {
	"id": "延庆",
	"name": "延庆"
}, {
	"id": "怀柔",
	"name": "怀柔"
}, {
	"id": "房山",
	"name": "房山"
}, {
	"id": "昌平",
	"name": "昌平"
}, {
	"id": "朝阳",
	"name": "朝阳"
}, {
	"id": "海淀",
	"name": "海淀"
}, {
	"id": "石景山",
	"name": "石景山"
}, {
	"id": "西城",
	"name": "西城"
}, {
	"id": "通州",
	"name": "通州"
}, {
	"id": "门头沟",
	"name": "门头沟"
}, {
	"id": "顺义",
	"name": "顺义"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getTicaiAreaKeyArr() {
	var arr = new Array();
	for (var index in ticai_areaData) {
		arr.push(ticai_areaData[index]['id'])
	}
	
	return arr;
}

var fucai8_shopTypeData = [{
	"id": "PK拾快3网点",
	"name": "PK拾快3网点"
}, {
	"id": "PK拾网点",
	"name": "PK拾网点"
}, {
	"id": "即开票网点",
	"name": "即开票网点"
}, {
	"id": "快乐8快3网点",
	"name": "快乐8快3网点"
}, {
	"id": "快乐8网点",
	"name": "快乐8网点"
}, {
	"id": "手持终端网点",
	"name": "手持终端网点"
}, {
	"id": "普通快3网点",
	"name": "普通快3网点"
}, {
	"id": "普通网点",
	"name": "普通网点"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getFucai8ShopTypeKeyArr() {
	var arr = new Array();
	for (var index in fucai8_shopTypeData) {
		arr.push(fucai8_shopTypeData[index]['id'])
	}
	
	return arr;
}

var fucai8_danjiData = [{
	"id": "单",
	"name": "单彩店"
}, {
	"id": "双",
	"name": "双彩店"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getFucai8DanjiKeyArr() {
	var arr = new Array();
	for (var index in fucai8_danjiData) {
		arr.push(fucai8_danjiData[index]['id'])
	}
	
	return arr;
}

var fucai8_wangdianData = [{
	"id": "东城区",
	"name": "东城区"
}, {
	"id": "西城区",
	"name": "西城区"
}, {
	"id": "通州区",
	"name": "通州区"
}, {
	"id": "门头沟",
	"name": "门头沟"
}, {
	"id": "顺义区",
	"name": "顺义区"
}, {
	"id": "大兴区",
	"name": "大兴区"
}, {
	"id": "丰台区",
	"name": "丰台区"
}, {
	"id": "密云县",
	"name": "密云县"
}, {
	"id": "平谷区",
	"name": "平谷区"
}, {
	"id": "延庆县",
	"name": "延庆县"
}, {
	"id": "昌平区",
	"name": "昌平区"
}, {
	"id": "朝阳区",
	"name": "朝阳区"
}, {
	"id": "海淀区",
	"name": "海淀区"
}, {
	"id": "石景山",
	"name": "石景山"
}, {
	"id": "怀柔区",
	"name": "怀柔区"
}, {
	"id": "房山区",
	"name": "房山区"
}, {
	"id": "中创智想",
	"name": "中创智想"
}, {
	"id": "中宇世源",
	"name": "中宇世源"
}, {
	"id": "中心",
	"name": "中心"
}, {
	"id": "中油首汽",
	"name": "中油首汽"
}, {
	"id": "北广视彩",
	"name": "北广视彩"
}, {
	"id": "北控京彩",
	"name": "北控京彩"
}, {
	"id": "北控公司",
	"name": "北控公司"
}, {
	"id": "彩谐科技",
	"name": "彩谐科技"
}, {
	"id": "旭日",
	"name": "旭日"
}, {
	"id": "渠道旭日",
	"name": "渠道旭日"
}, {
	"id": "烟草",
	"name": "烟草"
}, {
	"id": "燕山区",
	"name": "燕山区"
}, {
	"id": "社区协会",
	"name": "社区协会"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getFucai8WangdianKeyArr() {
	var arr = new Array();
	for (var index in fucai8_wangdianData) {
		arr.push(fucai8_wangdianData[index]['id'])
	}
	
	return arr;
}

var fucai9_areaData = [{
	"id": "东城",
	"name": "东城"
}, {
	"id": "丰台",
	"name": "丰台"
}, {
	"id": "大兴",
	"name": "大兴"
}, {
	"id": "密云",
	"name": "密云"
}, {
	"id": "平谷",
	"name": "平谷"
}, {
	"id": "延庆",
	"name": "延庆"
}, {
	"id": "怀柔",
	"name": "怀柔"
}, {
	"id": "房山",
	"name": "房山"
}, {
	"id": "昌平",
	"name": "昌平"
}, {
	"id": "朝阳",
	"name": "朝阳"
}, {
	"id": "海淀",
	"name": "海淀"
}, {
	"id": "石景山",
	"name": "石景山"
}, {
	"id": "西城",
	"name": "西城"
}, {
	"id": "通州",
	"name": "通州"
}, {
	"id": "门头沟",
	"name": "门头沟"
}, {
	"id": "顺义",
	"name": "顺义"
}, {
	"id": "UNKOWN",
	"name": "未知"
}];

function getFucai9AreaKeyArr() {
	var arr = new Array();
	for (var index in fucai9_areaData) {
		arr.push(fucai9_areaData[index]['id'])
	}
	
	return arr;
}

var fucai9_shopTypeData = [{
	"id": "PK拾快3网点",
	"name": "PK拾快3网点"
}, {
	"id": "即开票网点",
	"name": "即开票网点"
}, {
	"id": "快乐8快3网点",
	"name": "快乐8快3网点"
}, {
	"id": "快乐8网点",
	"name": "快乐8网点"
}, {
	"id": "普通快3网点",
	"name": "普通快3网点"
}, {
	"id": "普通网点",
	"name": "普通网点"
}];

function getFucai9ShopTypeKeyArr() {
	var arr = new Array();
	for (var index in fucai9_shopTypeData) {
		arr.push(fucai9_shopTypeData[index]['id'])
	}
	
	return arr;
}
