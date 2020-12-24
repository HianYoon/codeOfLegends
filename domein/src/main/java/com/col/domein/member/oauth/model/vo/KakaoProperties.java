package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class KakaoProperties {
	
	private String nickname;
	private String profile_image;
	private String thumbnail_image;
	
	public KakaoProperties() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((profile_image == null) ? 0 : profile_image.hashCode());
		result = prime * result + ((thumbnail_image == null) ? 0 : thumbnail_image.hashCode());
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
		KakaoProperties other = (KakaoProperties) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (profile_image == null) {
			if (other.profile_image != null)
				return false;
		} else if (!profile_image.equals(other.profile_image))
			return false;
		if (thumbnail_image == null) {
			if (other.thumbnail_image != null)
				return false;
		} else if (!thumbnail_image.equals(other.thumbnail_image))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KakaoProperties [nickname=" + nickname + ", profile_image=" + profile_image + ", thumbnail_image="
				+ thumbnail_image + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getThumbnail_image() {
		return thumbnail_image;
	}

	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}

	public KakaoProperties(String nickname, String profile_image, String thumbnail_image) {
		super();
		this.nickname = nickname;
		this.profile_image = profile_image;
		this.thumbnail_image = thumbnail_image;
	}
	
}
