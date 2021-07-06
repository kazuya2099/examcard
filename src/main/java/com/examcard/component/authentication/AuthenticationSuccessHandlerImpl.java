package com.examcard.component.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	Logger logger = Logger.getLogger(AuthenticationFailureHandlerImpl.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String loginId = request.getParameter("mailAddress");
		logger.info("ログインに成功しました。ログインID：" + loginId);
		response.sendRedirect(request.getContextPath() + "/top");
	}
}
