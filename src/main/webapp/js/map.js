function getImgWithType(type) {
	var imageName = "image/icon-a.png";
	
	if (type === 'qudao') {
		imageName = "image/img-shequ.jpg"
	} else if (type === 'yidong') {
		imageName = "image/img-yidong.jpg"
	} else if (type === 'ticai') {
		imageName = "image/img-ticai.jpg"
	} else if (type === 'fucai8') {
		imageName = "image/img-fucai8.jpg"
	} else if (type === 'fucai9') {
		imageName = "image/img-fucai9.jpg"
	} else if (type == "common") {
		imageName = "image/icon-a.png";
	}

	return {
		type: 'image',
		image: imageName,
		size: [12, 12],
		anchor: 'bottom-center',
		angel: 0,
		retina: true
	};
};

function getGenImg() {
	return {
		type: 'image',
		image: 'image/icon-red.png',
		size: [12, 12],
		anchor: 'bottom-center',
		angel: 0,
		retina: true
	};
};

function showTip (text) {
	return {
		content: text,
		direction:'bottom'
	};
};

function showTips(msg) {
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.msg(msg);
	});
}

function showTipWithCtrl (msg, id) {
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.tips(msg, id);
	});
}

var loadingIndex = 0;
function showLoading () {
	layui.use('layer', function() {
		var layer = layui.layer;
		loadingIndex = layer.load(1);
	});
}

function hideLoading() {
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.closeAll('loading'); 
	});
}
