const imgLabelsContainer = $(".img-labels-container");
imgLabelsContainer.click((e) => {
	// 이곳이 true인 까닭은 click이벤트가 먼저 일어난 뒤에, 체크가 일어나기 때문이다.
	// 클릭이 일어나는 시점에서는 check가 반대로 되어있기 때문.
	if (
		$("#" + $(e.target).parents("label").prop("for")).prop("checked") == true
	) {
		$(e.target).parents("label").children().css({
			"background-color": "ivory",
			"transition-duration": "0.5s",
		});
		$(e.target)
			.parents("label")
			.children()
			.removeClass("animate__shakeY")
			.addClass("animate__shakeX");
	} else {
		$(e.target).parents("label").children().css({
			"background-color": "#ffca28",
			"transition-duration": "0.5s",
		});
		$(e.target)
			.parents("label")
			.children()
			.removeClass("animate__shakeX")
			.addClass("animate__shakeY");
	}
});

const categories = $(".catCheck");
categories.each((i, v) => {
	if ($(v).prop("checked") == true) {
		$(imgLabelsContainer[i]).parents("label").children().css({
			"background-color": "#ffca28",
			"transition-duration": "0.5s",
		});
	}
});

let flag = false;
const regex = /^\d{2,3}-\d{3,4}-\d{4}$/;

const businessTel = $("#businessTel");

const businessTelCheck = $("#businessTelCheck");

businessTel.keyup((e) => {
	businessTelEvent();
	submitBtnChanger();
});

function businessTelEvent() {
	if (regex.test(businessTel.val())) {
		businessTelCheck.removeClass("opacity0");
		flag = true;
	} else {
		businessTelCheck.addClass("opacity0");
		flag = false;
	}
}

function submitBtnChanger() {
	if (flag == true) {
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
