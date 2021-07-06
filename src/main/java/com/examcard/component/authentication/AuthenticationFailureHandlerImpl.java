package com.examcard.component.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	Logger logger = Logger.getLogger(AuthenticationFailureHandlerImpl.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String loginId = request.getParameter("mailAddress");
		logger.info("ログインに失敗しました。ログインID：" + loginId + " エラーメッセージ：" + exception.getMessage());
		response.sendRedirect(request.getContextPath() + "/login?mailAddress=" + loginId);
	}
}
