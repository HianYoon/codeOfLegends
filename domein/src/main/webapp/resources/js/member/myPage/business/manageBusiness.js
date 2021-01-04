function modifyBusiness(businessKey){
	location.href = path + "/member/myPage/account/business/modifyBusiness.do?businessKey="+businessKey;
}

function removeBusiness(businessKey){
	location.href = path + "/member/myPage/account/business/removeBusiness.do?businessKey="+businessKey;
}

$("#addBusinessBtn").click(e=>{
	location.href = path + "/member/myPage/account/business/addBusiness.do";
})