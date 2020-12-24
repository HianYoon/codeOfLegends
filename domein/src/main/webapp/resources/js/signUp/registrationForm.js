const emailAdCheck = $("#email-ad-check");
const additionalInfoCheck = $("#additional-info-check");
const emailAdCheckImg = $("#email-ad-check-img");
const additionalInfoCheckImg = $("#additional-info-check-img");
const form = $("#the-form");

const checked = path + "/resources/images/signUp/checked.png";
const unchecked = path + "/resources/images/signUp/unchecked.png";

emailAdCheck.change((e) => {
	if (emailAdCheck.prop("checked") == true) {
		emailAdCheckImg.prop({ src: checked });
	} else {
		emailAdCheckImg.prop({ src: unchecked });
	}
});

additionalInfoCheck.change((e) => {
	if (additionalInfoCheck.prop("checked") == true) {
		additionalInfoCheckImg.prop({ src: checked });
	} else {
		additionalInfoCheckImg.prop({ src: unchecked });
	}
});

let checker = [false, false, false, false, false, false, false];
let flags = [false, false, false, false, false, false, false];
const regexes = [
	/^[0-9a-z]{5,15}$/,
	/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/,
	,
	/^[가-힣a-zA-Z]{2,15}$/,
	/^[0-9ㄱ-ㅎa-zA-Z가-힣\s]{2,10}$/,
	/^\d{3}-\d{3,4}-\d{4}$/,
	/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i,
];

function ajaxForm(index, url, value) {
	$.ajax({
		url: path + "/rest/member/signup/" + url,
		method: "POST",
		data: { data: value },
		async: false,
		success: (result) => {
			flags[index] = result;
		}
	});
}

function statusChanger(index, value) {
	if ((index == 2 || regexes[index].test(value)) && flags[index]) {
		$($(".icons")[index]).css({ "background-color": "var(--main-yellow)" });
		$($(".message-row")[index]).addClass("opacity0");
		checker[index] = true;
	} else {
		$($(".icons")[index]).css({ "background-color": "#C4C4C4" });
		$($(".message-row")[index]).removeClass("opacity0");
		checker[index] = false;
	}
}

function submitBtnChanger() {
	if (checker.indexOf(false) == -1) {
		$("#submit-btn")
			.removeAttr("disabled")
			.removeClass("btn--primary2")
			.addClass("btn--primary");
	} else {
		$("#submit-btn")
			.attr({ disabled: "disabled" })
			.removeClass("btn--primary")
			.addClass("btn--primary2");
	}
}

const regForm = $(".reg-form");
regForm.each((i, v) => {
	$(v).keyup((e) => {
		let index = i;
		flags[i] = false;
		if (index == 0) {
			ajaxForm(index, "id", e.target.value);
		} else if (index == 1) {
			flags[1] = true;
			$(regForm[2]).trigger("keyup");
		} else if (index == 2) {
			if (
				regForm[2].value == regForm[1].value &&
				regForm[1].value != null
			)
				flags[2] = true;
		} else if (index == 3) {
			flags[3] = true;
		} else if (index == 4) {
			ajaxForm(index, "nickname", e.target.value);
		} else if (index == 5) {
			ajaxForm(index, "phone", e.target.value);
		} else if (index == 6) {
			ajaxForm(index, "email", e.target.value);
		}

		statusChanger(index, e.target.value);
		submitBtnChanger();
	});
});