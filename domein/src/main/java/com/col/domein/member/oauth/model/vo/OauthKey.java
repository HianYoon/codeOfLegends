package com.col.domein.member.oauth.model.vo;

import javax.servlet.http.HttpServletRequest;


public class OauthKey {

	private HttpServletRequest request;
	
	private String serverUrl;
	
	private String googleClientId = "1048798785374-akhqjnf6p4g1fdo3mkf2pudg9ffh5ger.apps.googleusercontent.com";
	private String googleClientSecret = "uQdjQzU9KMQbYc2bx3TwFFDA";
	private String googleCallbackUri = "/member/oauth/google.do";
	
	private String kakaoClientId = "6a88db9a5a494eb2b45b1226ad76d34a";
	private String kakaoClientSecret = "aGCaAJV2nuVTenmFpDeMF1zZ2TDWfqga";
	private String kakaoCallbackUri = "/member/oauth/kakao.do";
	private String kakaoMyPageCallbackUri = "/member/oauth/kakao/addition.do";
	
	
	private String naverClientId = "SRI621amFGMTUu3kZVHJ";
	private String naverClientSecret = "sWGzb7TzkW";
	private String naverCallbackUri = "/member/oauth/naver.do";
	private String naverMyPageCallbackUri = "/member/oauth/naver/addition.do";
	
	public OauthKey(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		serverUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		googleCallbackUri = serverUrl + googleCallbackUri;
		kakaoCallbackUri = serverUrl + kakaoCallbackUri;
		naverCallbackUri = serverUrl + naverCallbackUri;
		kakaoMyPageCallbackUri = serverUrl + kakaoMyPageCallbackUri;
		naverMyPageCallbackUri = serverUrl + naverMyPageCallbackUri;
	}

	public String getGoogleClientId() {
		return googleClientId;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	public String getGoogleCallbackUri() {
		return googleCallbackUri;
	}

	public String getKakaoClientId() {
		return kakaoClientId;
	}

	public String getKakaoClientSecret() {
		return kakaoClientSecret;
	}

	public String getKakaoCallbackUri() {
		return kakaoCallbackUri;
	}

	public String getNaverClientId() {
		return naverClientId;
	}

	public String getNaverClientSecret() {
		return naverClientSecret;
	}

	public String getNaverCallbackUri() {
		return naverCallbackUri;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public String getKakaoMyPageCallbackUri() {
		return kakaoMyPageCallbackUri;
	}

	public String getNaverMyPageCallbackUri() {
		return naverMyPageCallbackUri;
	}
	
	
	
}
