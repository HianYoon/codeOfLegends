package com.col.domein.common.model.vo;

import javax.servlet.http.HttpServletRequest;

public class ErrorUriMaker {
	
	private HttpServletRequest request;
	private String msg;
	private String loc;
	private String locDesc;
	private String errorUri;
	private String redirectErrorUri;
	
	
	public ErrorUriMaker() {
		// TODO Auto-generated constructor stub
	}

	public ErrorUriMaker(HttpServletRequest request, String msg, String loc, String locDesc) {
		super();
		this.request = request;
		this.msg = msg;
		this.loc = loc;
		this.locDesc = locDesc;
		errorUri = request.getContextPath()+"/error.do?msg="+msg+"&loc="+loc+"&locDesc="+locDesc;
		redirectErrorUri = "redirect: " + errorUri;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public String getMsg() {
		return msg;
	}

	public String getLoc() {
		return loc;
	}

	public String getLocDesc() {
		return locDesc;
	}

	public String getErrorUri() {
		return errorUri;
	}

	public String getRedirectErrorUri() {
		return redirectErrorUri;
	}
	
	
}
