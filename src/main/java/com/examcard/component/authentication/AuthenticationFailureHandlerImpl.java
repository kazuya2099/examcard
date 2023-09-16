package com.examcard.component.authentication;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	Logger logger = Logger.getLogger(AuthenticationFailureHandlerImpl.class);

	@Override
	public void onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, AuthenticationException exception)
			throws IOException, jakarta.servlet.ServletException {
		String loginId = request.getParameter("mailAddress");
		logger.info("ログインに失敗しました。ログインID：" + loginId + " エラーメッセージ：" + exception.getMessage());
		response.sendRedirect(request.getContextPath() + "/login?mailAddress=" + loginId);
	}
}
