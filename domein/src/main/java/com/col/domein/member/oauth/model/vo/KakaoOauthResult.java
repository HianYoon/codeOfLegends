package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class KakaoOauthResult {
	
	private String id;
	private String connected_at;
	private KakaoProperties properties;
	private KakaoAccount kakao_account;
	
	public KakaoOauthResult() {
		// TODO Auto-generated constructor stub
	}

	public KakaoOauthResult(String id, String connected_at, KakaoProperties properties, KakaoAccount kakao_account) {
		super();
		this.id = id;
		this.connected_at = connected_at;
		this.properties = properties;
		this.kakao_account = kakao_account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConnected_at() {
		return connected_at;
	}

	public void setConnected_at(String connected_at) {
		this.connected_at = connected_at;
	}

	public KakaoProperties getProperties() {
		return properties;
	}

	public void setProperties(KakaoProperties properties) {
		this.properties = properties;
	}

	public KakaoAccount getKakao_account() {
		return kakao_account;
	}

	public void setKakao_account(KakaoAccount kakao_account) {
		this.kakao_account = kakao_account;
	}

	@Override
	public String toString() {
		return "KakaoOauthResult [id=" + id + ", connected_at=" + connected_at + ", properties=" + properties
				+ ", kakao_account=" + kakao_account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connected_at == null) ? 0 : connected_at.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kakao_account == null) ? 0 : kakao_account.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
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
		KakaoOauthResult other = (KakaoOauthResult) obj;
		if (connected_at == null) {
			if (other.connected_at != null)
				return false;
		} else if (!connected_at.equals(other.connected_at))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kakao_account == null) {
			if (other.kakao_account != null)
				return false;
		} else if (!kakao_account.equals(other.kakao_account))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		return true;
	}

	
}
