const checked = path + "/resources/images/signUp/checked.png";
const unchecked = path + "/resources/images/signUp/unchecked.png";
const emailAdCheckImg = $("#email-ad-check-img");
const emailAdCheck = $("#email-ad-check");
const regForm = $(".reg-form");

const originalVal = ["","","",""];

emailAdCheck.change((e) => {
	if (emailAdCheck.prop("checked") == true) {
		emailAdCheckImg.prop({ src: checked });
	} else {
		emailAdCheckImg.prop({ src: unchecked });
	}
});

let flags = [false, false, false, false];

const regexes = [
	/^[0-9a-z]{5,15}$/,
	/^[가-힣 a-zA-Z]{2,15}$/,
	/^[0-9ㄱ-ㅎa-zA-Z가-힣\s]{2,10}$/,
	/^\d{3}-\d{3,4}-\d{4}$/,

];
function submitBtnChanger() {
	if (flags.indexOf(false) == -1) {
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
function statusChanger(index) {
	if (flags[index]) {
		$($(".icons")[index]).css({ "background-color": "var(--main-yellow)" });
		$($(".message-row")[index]).addClass("opacity0");
		
	} else {
		$($(".icons")[index]).css({ "background-color": "#C4C4C4" });
		$($(".message-row")[index]).removeClass("opacity0");

	}
}



function regexCheck(order){
  let flag = regexes[order].test(regForm[order].value);
  if(!flag){
    flags[order] = false;
    statusChanger(order);
    submitBtnChanger();
    return;
  }

  switch (order) {
    case 0:
      ajaxForm(order, "id");
      break;
    case 2:
      ajaxForm(order, "nickname");
      break;
    case 3:
      ajaxForm(order, "phone");
      break;
    default:
      flags[order] = true;
      statusChanger(order);
      submitBtnChanger();
      break;
  }
}

function ajaxForm(order, target) {
  if(regForm[order].value == originalVal[order]){
    flags[order] = true;
    statusChanger(order);
    submitBtnChanger();
    return;
  }

  $.ajax({
    url: path + "/rest/member/signup/"+target,
    method: "POST",
    data: {data : regForm[order].value},
    success: (result) =>{
      flags[order] = result;
      statusChanger(order);
      submitBtnChanger();
    }
  })
}

regForm.each((i,v)=>{
  originalVal[i] = $(v).val();
  $(v).keyup((e)=>{
    regexCheck(i);
  })
  regForm.trigger("keyup");
})


submitBtnChanger();

