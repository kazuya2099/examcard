package com.examcard;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.DelegatingAccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.examcard.component.authentication.AuthenticationFailureHandlerImpl;
import com.examcard.component.authentication.AuthenticationSuccessHandlerImpl;
import com.examcard.component.authentication.LogoutSuccessHandlerImpl;
import com.examcard.service.authentication.UserDetailsServiceImpl; 

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsServiceImpl loginService;

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
	    return new MvcRequestMatcher.Builder(introspector);
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		http
			.formLogin(formLogin  -> formLogin
					.loginPage("/login")
					.loginProcessingUrl("/login/execute")
					.usernameParameter("mailAddress")
					.passwordParameter("password")
					.failureHandler(authenticationFailureHandler())
					.successHandler(authenticationSuccessHandler()));
//			.logout(logout -> logout.logoutUrl("/logout")
//					.logoutSuccessUrl("/logout/complete"))
//			.authorizeHttpRequests(authorize -> authorize
//				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//				.requestMatchers(mvc.pattern("/")).permitAll()
//				.anyRequest().authenticated()
//			)
//			.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()))
//			.rememberMe(Customizer.withDefaults());
			return http.build();
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
