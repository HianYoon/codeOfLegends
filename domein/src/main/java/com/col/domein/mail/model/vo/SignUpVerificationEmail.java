package com.col.domein.mail.model.vo;

import org.springframework.stereotype.Component;

import com.col.domein.member.model.vo.Member;

@Component
public class SignUpVerificationEmail {
	
	private Member newMember;
	private String contextPath;
	private String encodedRandomKey;
	
	public SignUpVerificationEmail() {
		// TODO Auto-generated constructor stub
	}
	
	public SignUpVerificationEmail(Member newMember,String contextPath, String encodedRandomKey) throws Exception {
		super();
		this.newMember = newMember;
		this.contextPath = contextPath;
		this.encodedRandomKey = encodedRandomKey;
		
		if(newMember== null || contextPath == null || contextPath.equals("") || encodedRandomKey == null || encodedRandomKey.equals("")) {
			throw new Exception("[[SYSTEM]]SignUpVerificationEmail의 생성자의 파라미터는 공란으로 둘 수 없습니다.");
		}
	}
	
	public String emailContent() {
		
		String content ="";
		
		content="<!DOCTYPE html>\r\n" + 
				"<html lang='en'>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset='UTF-8' />\r\n" + 
				"		<meta name='viewport' content='width=device-width, initial-scale=1.0' />\r\n" + 
				"		<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>\r\n" + 
				"		<title>도매인 이메일 주소 인증</title>\r\n" + 
				"		<style>\r\n" + 
				"			@charset 'UTF-8';\r\n" + 
				"\r\n" + 
				"			@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dokdo&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');\r\n" + 
				"\r\n" + 
				"			:root {\r\n" + 
				"				--main-yellow: #ffca28;\r\n" + 
				"				--second-yellow: #fffd61;\r\n" + 
				"				--third-yellow: #c79a00;\r\n" + 
				"				--main-grey: #b0bec5;\r\n" + 
				"				--second-grey: #e2f1f8;\r\n" + 
				"				--third-grey: #808e95;\r\n" + 
				"			}\r\n" + 
				"			body * {\r\n" + 
				"				margin: 0;\r\n" + 
				"				padding: 0;\r\n" + 
				"				font-family: 'Noto Sans KR', sans-serif;\r\n" + 
				"			}\r\n" + 
				"			.signup-email-boundary {\r\n" + 
				"				margin: 5%;\r\n" + 
				"				padding: 5%;\r\n" + 
				"				border: 1px solid var(--third-yellow);\r\n" + 
				"			}\r\n" + 
				"			.signup-logo-container {\r\n" + 
				"				width: 50%;\r\n" + 
				"				min-width: 100px;\r\n" + 
				"				max-width: 300px;\r\n" + 
				"			}\r\n" + 
				"			.signup-logo-container > img {\r\n" + 
				"				width: 100%;\r\n" + 
				"			}\r\n" + 
				"			.email-heavy-font {\r\n" + 
				"				font-weight: 900;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.signup-title {\r\n" + 
				"				color: var(--main-yellow);\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.btn {\r\n" + 
				"				height: 35px;\r\n" + 
				"				background: #eee;\r\n" + 
				"				border: 1px solid #d5d5d5;\r\n" + 
				"				border-radius: 4px;\r\n" + 
				"				/* display:inline-flex로 하게되면 안에 글자에 맞게 좌우로 크기가 변경됨ㄴ */\r\n" + 
				"				display: inline-flex;\r\n" + 
				"				align-items: center;\r\n" + 
				"				padding: 0 12px;\r\n" + 
				"				font-size: 14px;\r\n" + 
				"				font-weight: 1000;\r\n" + 
				"				line-height: 1.5;\r\n" + 
				"				/* 마우스가 올라갓을때 손가락모양으로 바뀌게 */\r\n" + 
				"				cursor: pointer;\r\n" + 
				"				/* 패딩이나 margin이 들어갓을때 커지는것을막아주는 css명령어 */\r\n" + 
				"				box-sizing: border-box;\r\n" + 
				"				position: relative;\r\n" + 
				"				z-index: 500;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.btn:hover::before {\r\n" + 
				"				content: '';\r\n" + 
				"				position: absolute;\r\n" + 
				"				top: 0;\r\n" + 
				"				left: 0;\r\n" + 
				"				width: 100%;\r\n" + 
				"				height: 100%;\r\n" + 
				"				background: rgba(0, 0, 0, 0.07);\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.btn.btn--primary {\r\n" + 
				"				border: 1px solid #ddd;\r\n" + 
				"				color: black;\r\n" + 
				"				background: #ffca28;\r\n" + 
				"			}\r\n" + 
				"			.signup-content a {\r\n" + 
				"				color: var(--third-grey);\r\n" + 
				"			}\r\n" + 
				"		</style>\r\n" + 
				"	</head>\r\n" + 
				"	<body class='signup-body'>\r\n" + 
				"		<div class='signup-email-boundary'>\r\n" + 
				"			<div class='signup-logo-container'>\r\n" + 
				"				<img\r\n" + 
				"					src='http://mightymosses.hopto.org:9090/domein/resources/images/logo/signature.png'\r\n" + 
				"					alt='로고'\r\n" + 
				"				/>\r\n" + 
				"			</div>\r\n" + 
				"			<div class='signup-content'>\r\n" + 
				"				<br />\r\n" + 
				"				<h2 class='signup-title'>이메일 주소 인증</h2>\r\n" + 
				"				<br />\r\n" + 
				"				<h4>\r\n" + 
				"					안녕하세요.\r\n" + 
				"					<span class='email-heavy-font'>도매-인(Dome-in)</span>입니다.\r\n" + 
				"				</h4>\r\n" + 
				"				<h4>"
				
				+ newMember.getUserName()
				
				+ " 님 본인 확인을 위해 다음 버튼을 클릭해주세요!</h4>\r\n" + 
				"				<br />\r\n" + 
				"				<a\r\n" + 
				"					href='"
				+ contextPath
				+ "/member/signUp/accountVerify.do?memberKey="
				+ newMember.getMemberKey()
				
				+ "&confirmationKey="
				
				+ encodedRandomKey
				
				+ "'\r\n" + 
				"				>\r\n" + 
				"				<button id='verificationBtn' class='btn btn--primary'>링크 클릭</button>\r\n</a>" + 
				"				<br />\r\n" + 
				"				<br />\r\n" + 
				"				<a\r\n" + 
				"					href='"
				+ contextPath 
				+"/member/signUp/accountVerify.do?memberKey="
				+ newMember.getMemberKey()
				
				+ "&confirmationKey="
				
				+ encodedRandomKey
				
				+ "'\r\n" + 
				"				>\r\n" + 
				"					버튼 미 작동 시 이 링크 클릭\r\n" + 
				"				</a>\r\n" + 
				"				<br />\r\n" + 
				"				<br />\r\n" + 
				"				<h4>본인이 아닐 시</h4>\r\n" + 
				"				<h4>이 이메일을 무시해 주세요!</h4>\r\n" + 
				"				<br />\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</body>\r\n" + 
				"	<script>\r\n" + 
				"		$('#verificationBtn').click((e) => {\r\n" + 
				"			location.href =\r\n" + 
				"				'"
				+ contextPath
				+ "/member/signUp/accountVerify.do?memberKey="
				
				+ newMember.getMemberKey()
				
				+ "&confirmationKey="
				
				+ encodedRandomKey
				
				+ "';\r\n" + 
				"		});\r\n" + 
				"	</script>\r\n" + 
				"</html>";
		
		return content;
	}
	
	
}
