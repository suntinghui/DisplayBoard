function getImgWithType(type) {
	var imageName = "image/icon-red.png";
	
	if (type === 'yidong') {
		imageName = "image/icon-red.png"
	} else if (type === 'ticai') {
		imageName = "image/icon-white.png"
	} else if (type === 'fucai8') {
		imageName = "image/icon-yellow.png"
	} else if (type === 'fucai9') {
		imageName = "image/icon-green.png"
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


