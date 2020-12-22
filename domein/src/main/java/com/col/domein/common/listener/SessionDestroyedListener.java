package com.col.domein.common.listener;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import com.col.domein.member.model.service.MemberService;
import com.col.domein.member.model.vo.Member;

@Component(value = "sessionDestroyedListener")
public class SessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {

	@Autowired
	private MemberService ms;

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		// TODO Auto-generated method stub
		HttpSessionDestroyedEvent httpEvent = (HttpSessionDestroyedEvent) event;
		HttpSession session = httpEvent.getSession();
//		파괴되기 직전의 세션
		
//		로그아웃하는 멤버 로그 남기기
		Member m = (Member) session.getAttribute("signedInMember");
		if (m != null) {
			int loginSource = (int) session.getAttribute("loginSource");
			ms.logoutMember(m, loginSource);
		}
	}
}
