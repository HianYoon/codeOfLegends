package com.col.domein.member.oauth.model.vo;

public class NaverOauthResult {

	private String resultcode;
	private String message;
	private NaverProfile response;
	
	public NaverOauthResult() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((resultcode == null) ? 0 : resultcode.hashCode());
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
		NaverOauthResult other = (NaverOauthResult) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (resultcode == null) {
			if (other.resultcode != null)
				return false;
		} else if (!resultcode.equals(other.resultcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NaverOauthResult [resultcode=" + resultcode + ", message=" + message + ", response=" + response + "]";
	}

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NaverProfile getResponse() {
		return response;
	}

	public void setResponse(NaverProfile response) {
		this.response = response;
	}

	public NaverOauthResult(String resultcode, String message, NaverProfile response) {
		super();
		this.resultcode = resultcode;
		this.message = message;
		this.response = response;
	}
	
}
