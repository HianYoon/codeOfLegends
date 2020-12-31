$(".sign-up").click((e) => {
	location.href = "${path}/member/signUp/signUp.do";
});
$("#btn-google").click((e) => {
	$("#googleSignIn *").trigger("click");
});

function onSignIn(googleUser) {
	const id_token = googleUser.getAuthResponse().id_token;
	$.ajax({
		url: path + "/rest/member/oauth/google",
		method: "POST",
		data: { idToken: id_token },
		success: (result) => {
			let uri = "";
			switch (result) {
				case 1:
					uri = "";
					break;
				case 2:
					uri = "member/oauth/emailFound.do";
					break;
				case 3:
					uri = "member/oauth/newOauthMember.do";
					break;
				case 9:
				default:
					"error.do";
			}
			location.href = path + "/" + uri;
		},
	});
}

$("#btn-kakao").click((e) => {
	$.ajax({
		url: path + "/rest/member/oauth/kakao",
		method: "POST",
		success: (result) => {
			location.href = result;
		},
	});
});

$("#btn-naver").click((e) => {
	$.ajax({
		url: path + "/rest/member/oauth/naver",
		method: "POST",
		success: (result) => {
			location.href = result;
		},
	});
});
