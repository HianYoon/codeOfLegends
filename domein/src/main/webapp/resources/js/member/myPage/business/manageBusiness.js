function modifyBusiness(businessKey){
	location.href = path + "/member/myPage/account/business/modifyBusiness.do?businessKey="+businessKey;
}

function removeBusiness(businessKey){
	let flag = confirm("정말로 해당 판매자를 삭제하시겠습니까?");
	if(flag) {
		location.href = path + "/member/myPage/account/business/deleteBusiness.do?businessKey="+businessKey;
	}
}

$("#addBusinessBtn").click(e=>{
	location.href = path + "/member/myPage/account/business/addBusiness.do";
})