window.count = 10;

var COUNT_TIME = 10;
var CHANGE_TIME = 10 // 表示切换周期，以秒为单位

function resetCount() {
	console.log("+++++++++++++++++++++++++++++++++");
	window.count = COUNT_TIME; // 更新count后仍然不能更新setInterval
}

function changeTimer() {
	var index = 0;
	setInterval(function() {
		if (window.count == 0) {
			index = (index == 1) ? 0 : index + 1;
			$(".div").hide('slow').eq(index).show('slow');
		}
		
	}, CHANGE_TIME*1000); // 每CHANGE_TIME秒执行切换一次
	
}

function countTimer() {
	
	setInterval(function() {
		if (window.count != 0) {
			window.count--;
		}
		
		console.log("------------"+window.count);
		
	}, 1000); // 每秒执行一次
}