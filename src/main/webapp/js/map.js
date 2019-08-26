function getImgWithType(type) {
	var imageName = "image/icon-red.png";
	
	if (type === 'qudao') {
		imageName = "image/icon-a.png"
	} else if (type === 'yidong') {
		imageName = "image/icon-a.png"
	} else if (type === 'ticai') {
		imageName = "image/icon-a.png"
	} else if (type === 'fucai8') {
		imageName = "image/icon-b.png"
	} else if (type === 'fucai9') {
		imageName = "image/icon-b.png"
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
