package com.examcard;


import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;

import com.examcard.component.authentication.AuthenticationFailureHandlerImpl;
import com.examcard.component.authentication.AuthenticationSuccessHandlerImpl;
import com.examcard.component.authentication.LogoutSuccessHandlerImpl;
import com.examcard.service.authentication.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl loginService;

	@Override
	public void configure(WebSecurity web) {
		web
			.ignoring()
			.antMatchers("/css/**")
			.antMatchers("/images/**")
			.antMatchers("/js/**")
			.antMatchers("/font/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/login/**", "/login/index", "/login/error", "/logout", "/logout/**").permitAll()
				.antMatchers("/top").hasAnyRole("1000", "1100", "2000", "2100", "9000")
				.antMatchers("/application/search-sa/**").hasAnyRole("1000", "1100", "9000")
				.antMatchers("/application/detail-sa/**").hasAnyRole("1000", "1100", "9000")
				.antMatchers("/application/search-cr/**").hasAnyRole("2000", "2100", "9000")
				.antMatchers("/application/detail-cr/**").hasAnyRole("2000", "2100", "9000")
				.anyRequest().authenticated()
				.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler())
				.and()
			.rememberMe()
				.and()
			.formLogin()
				.loginProcessingUrl("/login/login")
				.loginPage("/login")
				.usernameParameter("mailAddress")
				.passwordParameter("password")
				.failureHandler(authenticationFailureHandler())
				.successHandler(authenticationSuccessHandler())
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout/complete")
				.invalidateHttpSession(true)
				.and();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		AuthenticationFailureHandler handler = new AuthenticationFailureHandlerImpl();
		return handler;
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		AuthenticationSuccessHandler handler = new AuthenticationSuccessHandlerImpl();
		return handler;
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		LogoutSuccessHandler handler = new LogoutSuccessHandlerImpl();
		return handler;
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		AccessDeniedHandlerImpl invalidCsrfToken = new AccessDeniedHandlerImpl();
		invalidCsrfToken.setErrorPage("/WEB-INF/views/error/badRequest.jsp");
		AccessDeniedHandlerImpl accessDeniedError = new AccessDeniedHandlerImpl();
		accessDeniedError.setErrorPage("/WEB-INF/views/error/accessDenied.jsp");
		AccessDeniedHandlerImpl defaultHandler = new AccessDeniedHandlerImpl();
		defaultHandler.setErrorPage("/WEB-INF/views/error/systemError.jsp");

		LinkedHashMap<Class<? extends AccessDeniedException>, AccessDeniedHandler> handlers = new LinkedHashMap<>();
		handlers.put(InvalidCsrfTokenException.class, invalidCsrfToken);
		handlers.put(AccessDeniedException.class, accessDeniedError);

		DelegatingAccessDeniedHandler handler = new DelegatingAccessDeniedHandler(handlers, defaultHandler);
		return handler;
	}
}
