	$("#deleteAccount").click(e=>{
		signOut();
		location.href = path + "/member/myPage/account/deleteEnd.do";
	})
	
	$("#remainAccount").click(e=>{
		location.href = path + "/member/myPage/account";
	})