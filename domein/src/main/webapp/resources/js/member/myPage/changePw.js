let flags = [false, false, false];
const regex = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

const regForm = $(".reg-form");
regForm.each((i, v) => {
	$(v).keyup((e) => {
		let index = i;
		flags[i] = false;
		if (index == 0) {
			if (regForm[0].value != null) flags[index] = true;
		} else if (index == 1) {
			if (regex.test(regForm[1].value)) flags[index] = true;
		} else {
			if (regForm[1].value != null && regForm[2].value == regForm[1].value)
				flags[index] = true;
		}
		if (flags[index] == true) {
			$($(".icons")[index]).css({ "background-color": "var(--main-yellow)" });
			$($(".message-row")[index]).addClass("opacity0");
		} else {
			$($(".icons")[index]).css({ "background-color": "#C4C4C4" });
			$($(".message-row")[index]).removeClass("opacity0");
		}
		submitBtnChanger();
	});
});

const submitBtn = $("#submit-btn");
function submitBtnChanger() {
	if (flags.indexOf(false) == -1) {
		submitBtn
			.removeAttr("disabled")
			.removeClass("btn--primary2")
			.addClass("btn--primary");
	} else {
		submitBtn
			.attr({ disabled: "disabled" })
			.removeClass("btn--primary")
			.addClass("btn--primary2");
	}
}

submitBtn.click((e) => {
	let flag = false;
	$.ajax({
		url: path + "/rest/member/mypage/account/password",
		method: "POST",
		data: { password: $("#old-password").val() },
		async: false,
		success: (result) => {
			if (result) flag = result;
			else {
				$("#old-pw-message").html("기존 패스워드와 일치하지 않습니다!");
				$(regForm[0]).focus();
				flag = result;
			}
		},
	});
	$($(".message-row")[0]).removeClass("opacity0");
	return flag;
});
