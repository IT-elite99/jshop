/**
 * 打开提示窗口
 * @param {Object} flag 标示符，true|false
 * @param {Object} message
 */
function openTip(flag, message) {
	if(!document.getElementById("tip-window")) {
		$(document.body).append('<div id="tip-window" style="width: 300px;height: 200px;border: 1px solid #57ABFF;border-radius: 5px;position: fixed;right: 5px;bottom: 5px;display: none;">' +
			'<div style = "height: 40px;line-height: 40px;text-indent: 1em; background-color: #57ABFF;font-weight: bold;" >' +
			'提示信息 </div> <div class = "tip-content"	style = "margin-top: 20px;margin-left: 20px;" ><span class = "success"' +
			'style = "color: green; background:url(img/accept.png) no-repeat left;text-indent: 1em;display: inline-block;" >' +
			'</span> <span class = "fail" style = "color: red;background:url(img/cancel.png) no-repeat left;text-indent: 1em;display: inline-block;" >' +
			'</span> </div> </div>');
	}

	var text = "操作成功.."; //默认的提示文本
	var tipWindow = $("#tip-window ");
	var isSuccess = true;
	if(flag != undefined) {
		isSuccess = flag;
	}

	var successObj = $(".success", tipWindow);
	var failObj = $(".fail", tipWindow);

	var obj;

	if(isSuccess) {
		successObj.show();
		failObj.hide();
		obj = successObj;
	} else {
		successObj.hide();
		failObj.show();
		obj = failObj;
		text = "操作失败";
	}

	if(message != null && message != undefined) {
		text = message;
	}
	obj.text(text);
	//打开提示框
	tipWindow.slideDown("slow");
	//5秒之后要关闭这个窗口
	setTimeout(function() {
		tipWindow.slideUp("slow");
	}, 5000);

}