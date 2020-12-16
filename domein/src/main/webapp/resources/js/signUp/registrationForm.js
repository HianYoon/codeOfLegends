const emailAdCheck = $("#email-ad-check");
const additionalInfoCheck = $("#additional-info-check");
const emailAdCheckImg = $("#email-ad-check-img");
const additionalInfoCheckImg = $("#additional-info-check-img");

const checked =
	path+"/resources/images/signUp/checked.png";
const unchecked =
	path+"/resources/images/signUp/unchecked.png";

emailAdCheck.change((e) => {
	if (emailAdCheck.prop("checked") == true) {
		emailAdCheckImg.prop({ src: checked });
	} else {
		emailAdCheckImg.prop({ src: unchecked });
	}
	console.log("패스다!");
	console.log(path);
});

additionalInfoCheck.change((e) => {
	if (additionalInfoCheck.prop("checked") == true) {
		additionalInfoCheckImg.prop({ src: checked });
	} else {
		additionalInfoCheckImg.prop({ src: unchecked });
	}
});

// 추후 아이디나 다른 것들이 정상 상태이면 아이콘의 배경이 초록색으로 바뀔 것!
