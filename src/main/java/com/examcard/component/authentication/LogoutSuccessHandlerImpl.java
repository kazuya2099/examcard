package com.examcard.component.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class LogoutSuccessHandlerImpl extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {

	Logger logger = Logger.getLogger(LogoutSuccessHandlerImpl.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO
		// セッションが削除されたあとに呼ばれるため、ログインIDが取得できない。
		logger.info("ログアウトに成功しました。");
		super.handle(request, response, authentication);
	}

}
