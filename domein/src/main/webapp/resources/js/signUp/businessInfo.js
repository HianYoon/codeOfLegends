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

let checker = [false, false];

const regexes = [/^\d{10}$/, /^\d{2,3}-\d{3,4}-\d{4}$/];

const businessNo = $("#businessNo");
const businessName = $("#businessName");
const businessNickname = $("#businessNickname");
const businessTel = $("#businessTel");
const businessAddress = $("#businessAddress");
const businessNoCheck = $("#businessNoCheck");

const businessTelCheck = $("#businessTelCheck");

businessNo.keyup((e) => {
	if (regexes[0].test(businessNo.val())) {
		$.ajax({
			method: "POST",
			url: path + "/rest/business/signup/business/no",
			data: { data: businessNo.val() },
			success: (result) => {
				if (businessName != null || businessName == "") {
					businessName.val(result["businessName"]);
					businessTel.val(result["businessTel"]);
          businessAddress.val(result["businessAddress"]);
          businessTel.trigger("keyup");
					businessNoSuccess();
				} else {
					businessNoFail();
				}
				submitBtnChanger();
			},
		}).fail(() => {
			businessNoFail();
			submitBtnChanger();
		});
	} else {
		businessNoFail();
		submitBtnChanger();
	}
});

businessTel.keyup((e) => {
  businessTelEvent();
  submitBtnChanger();
});

function businessTelEvent() {
	if (regexes[1].test(businessTel.val())) {
		businessTelCheck.removeClass("opacity0");
		checker[1] = true;
	} else {
    businessTelCheck.addClass("opacity0");
	  checker[1] = false;
	}
}

function businessNoSuccess() {
	businessNoCheck.removeClass("opacity0");
	checker[0] = true;
}
function businessNoFail() {
	businessNoCheck.addClass("opacity0");
	checker[0] = false;
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
