package com.col.domein.member.oauth.model.vo;

import org.springframework.stereotype.Component;

@Component
public class KakaoAccount {
	
	private boolean profile_needs_agreement;
	private KakaoAccountProfile profile;
	private boolean has_email;
	private boolean email_needs_agreement;
	private boolean is_email_valid;
	private boolean is_email_verified;
	private String email;
	
	public KakaoAccount() {
		// TODO Auto-generated constructor stub
	}

	public KakaoAccount(boolean profile_needs_agreement, KakaoAccountProfile profile, boolean has_email,
			boolean email_needs_agreement, boolean is_email_valid, boolean is_email_verified, String email) {
		super();
		this.profile_needs_agreement = profile_needs_agreement;
		this.profile = profile;
		this.has_email = has_email;
		this.email_needs_agreement = email_needs_agreement;
		this.is_email_valid = is_email_valid;
		this.is_email_verified = is_email_verified;
		this.email = email;
	}

	public boolean isProfile_needs_agreement() {
		return profile_needs_agreement;
	}

	public void setProfile_needs_agreement(boolean profile_needs_agreement) {
		this.profile_needs_agreement = profile_needs_agreement;
	}

	public KakaoAccountProfile getProfile() {
		return profile;
	}

	public void setProfile(KakaoAccountProfile profile) {
		this.profile = profile;
	}

	public boolean isHas_email() {
		return has_email;
	}

	public void setHas_email(boolean has_email) {
		this.has_email = has_email;
	}

	public boolean isEmail_needs_agreement() {
		return email_needs_agreement;
	}

	public void setEmail_needs_agreement(boolean email_needs_agreement) {
		this.email_needs_agreement = email_needs_agreement;
	}

	public boolean isIs_email_valid() {
		return is_email_valid;
	}

	public void setIs_email_valid(boolean is_email_valid) {
		this.is_email_valid = is_email_valid;
	}

	public boolean isIs_email_verified() {
		return is_email_verified;
	}

	public void setIs_email_verified(boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KakaoAccount [profile_needs_agreement=" + profile_needs_agreement + ", profile=" + profile
				+ ", has_email=" + has_email + ", email_needs_agreement=" + email_needs_agreement + ", is_email_valid="
				+ is_email_valid + ", is_email_verified=" + is_email_verified + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (email_needs_agreement ? 1231 : 1237);
		result = prime * result + (has_email ? 1231 : 1237);
		result = prime * result + (is_email_valid ? 1231 : 1237);
		result = prime * result + (is_email_verified ? 1231 : 1237);
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + (profile_needs_agreement ? 1231 : 1237);
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
		KakaoAccount other = (KakaoAccount) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_needs_agreement != other.email_needs_agreement)
			return false;
		if (has_email != other.has_email)
			return false;
		if (is_email_valid != other.is_email_valid)
			return false;
		if (is_email_verified != other.is_email_verified)
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (profile_needs_agreement != other.profile_needs_agreement)
			return false;
		return true;
	}
	
	
}
