package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class KakaoAccountProfile {

	private String nickname;
	private String thumbnail_image_url;
	private String profile_image_url;
	
	public KakaoAccountProfile() {
		// TODO Auto-generated constructor stub
	}

	public KakaoAccountProfile(String nickname, String thumbnail_image_url, String profile_image_url) {
		super();
		this.nickname = nickname;
		this.thumbnail_image_url = thumbnail_image_url;
		this.profile_image_url = profile_image_url;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getThumbnail_image_url() {
		return thumbnail_image_url;
	}

	public void setThumbnail_image_url(String thumbnail_image_url) {
		this.thumbnail_image_url = thumbnail_image_url;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	@Override
	public String toString() {
		return "KakaoAccountProfile [nickname=" + nickname + ", thumbnail_image_url=" + thumbnail_image_url
				+ ", profile_image_url=" + profile_image_url + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((profile_image_url == null) ? 0 : profile_image_url.hashCode());
		result = prime * result + ((thumbnail_image_url == null) ? 0 : thumbnail_image_url.hashCode());
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
		KakaoAccountProfile other = (KakaoAccountProfile) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (profile_image_url == null) {
			if (other.profile_image_url != null)
				return false;
		} else if (!profile_image_url.equals(other.profile_image_url))
			return false;
		if (thumbnail_image_url == null) {
			if (other.thumbnail_image_url != null)
				return false;
		} else if (!thumbnail_image_url.equals(other.thumbnail_image_url))
			return false;
		return true;
	}
	
	
}
