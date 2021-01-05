const regexes = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

const regForm = $(".reg-form");

let flags = [false, false];

regForm.each((i,v)=>{
  $(v).keyup(e=>{
    if(regexes.test($(v).val())){
      flags[i] = true;
    } else {
      flags[i] = false;
    }
    if(regForm[0].value == regForm[1].value){
      flags[1] = true;
    } else{
      flags[1] = false;
    }
    statusChanger(i);
    submitBtnChanger();
  })
});

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