package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class NaverAccessTokenRequest {
	
	private String access_token;
	private String refresh_token;
	private String token_type;
	private String expires_in;
	
	public NaverAccessTokenRequest() {
		// TODO Auto-generated constructor stub
	}

	public NaverAccessTokenRequest(String access_token, String refresh_token, String token_type, String expires_in) {
		super();
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "NaverAccessTokenRequest [access_token=" + access_token + ", refresh_token=" + refresh_token
				+ ", token_type=" + token_type + ", expires_in=" + expires_in + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((expires_in == null) ? 0 : expires_in.hashCode());
		result = prime * result + ((refresh_token == null) ? 0 : refresh_token.hashCode());
		result = prime * result + ((token_type == null) ? 0 : token_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NaverAccessTokenRequest other = (NaverAccessTokenRequest) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (expires_in == null) {
			if (other.expires_in != null)
				return false;
		} else if (!expires_in.equals(other.expires_in))
			return false;
		if (refresh_token == null) {
			if (other.refresh_token != null)
				return false;
		} else if (!refresh_token.equals(other.refresh_token))
			return false;
		if (token_type == null) {
			if (other.token_type != null)
				return false;
		} else if (!token_type.equals(other.token_type))
			return false;
		return true;
	}
	
}
