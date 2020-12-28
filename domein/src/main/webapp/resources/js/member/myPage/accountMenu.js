$(".account-logout-icon").click(e=>{
	signOut();
	location.href = path+"/member/logout.do";
})