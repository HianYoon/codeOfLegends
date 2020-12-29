package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class KakaoToken {

	private String token_type;
	private String access_token;
	private int expires_in;
	private String refresh_token;
	private int refresh_token_expires_in;
	private String scope;
	
	public KakaoToken() {
		// TODO Auto-generated constructor stub
	}

	public KakaoToken(String token_type, String access_token, int expires_in, String refresh_token,
			int refresh_token_expires_in, String scope) {
		super();
		this.token_type = token_type;
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.refresh_token_expires_in = refresh_token_expires_in;
		this.scope = scope;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getRefresh_token_expires_in() {
		return refresh_token_expires_in;
	}

	public void setRefresh_token_expires_in(int refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "KakaoToken [token_type=" + token_type + ", access_token=" + access_token + ", expires_in=" + expires_in
				+ ", refresh_token=" + refresh_token + ", refresh_token_expires_in=" + refresh_token_expires_in
				+ ", scope=" + scope + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + expires_in;
		result = prime * result + ((refresh_token == null) ? 0 : refresh_token.hashCode());
		result = prime * result + refresh_token_expires_in;
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
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
		KakaoToken other = (KakaoToken) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (expires_in != other.expires_in)
			return false;
		if (refresh_token == null) {
			if (other.refresh_token != null)
				return false;
		} else if (!refresh_token.equals(other.refresh_token))
			return false;
		if (refresh_token_expires_in != other.refresh_token_expires_in)
			return false;
		if (scope == null) {
			if (other.scope != null)
				return false;
		} else if (!scope.equals(other.scope))
			return false;
		if (token_type == null) {
			if (other.token_type != null)
				return false;
		} else if (!token_type.equals(other.token_type))
			return false;
		return true;
	}
	
	
}
