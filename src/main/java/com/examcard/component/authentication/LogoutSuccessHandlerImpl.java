package com.examcard.component.authentication;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class LogoutSuccessHandlerImpl extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {

	Logger logger = Logger.getLogger(LogoutSuccessHandlerImpl.class);

	@Override
	public void onLogoutSuccess(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Authentication authentication)
			throws IOException, jakarta.servlet.ServletException {
		logger.info("ログアウトに成功しました。");
		super.handle(request, response, authentication);
	}

}
