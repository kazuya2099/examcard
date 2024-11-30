package com.examcard.component.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.examcard.service.dto.UserDto;

public abstract class AuthenticationUtil {

	public static UserDto getUserDto() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		return userDetailsImpl.getUserDto();
	}
}
