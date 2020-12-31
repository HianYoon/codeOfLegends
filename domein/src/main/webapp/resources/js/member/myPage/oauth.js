function deleteOauth(loginSourceNo) {
	if (loginSourceNo == 1) signOut();
	location.href =
		path +
		"/member/myPage/account/oauth/delete.do?loginSource=" +
		loginSourceNo;
}

$("#btn-google-connect").click((e) => {
	$("#googleSignIn *").trigger("click");
});

function onSignIn(googleUser) {
	const id_token = googleUser.getAuthResponse().id_token;
	$.ajax({
		url: path + "/rest/member/oauth/google/addition",
		method: "POST",
		data: { idToken: id_token },
		success: (result) => {
			let uri = "";
			switch (result) {
				case 1:
					return;
				case 5:
					uri = "member/myPage/account/oauth.do";
					break;
				case 6:
					uri =
						"error.do?msg=해당 간편 인증 아이디가 이미 다른 계정에 존재합니다!&loc=/member/myPage/account/oauth.do";
					break;
				case 9:
				default:
					uri =
						"error.do?msg=무언가 잘못되었네요...&loc=/member/myPage/account/oauth.do";
			}
			location.href = path + "/" + uri;
		},
	});
}

$("#btn-kakao-connect").click((e) => {
	$.ajax({
		url: path + "/rest/member/oauth/kakao/addition",
		method: "POST",
		success: (result) => {
			location.href = result;
		},
	});
});

$("#btn-naver-connect").click((e) => {
	$.ajax({
		url: path + "/rest/member/oauth/naver/addition",
		method: "POST",
		success: (result) => {
			location.href = result;
		},
	});
});
