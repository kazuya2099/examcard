package com.examcard.component.authentication;

import com.examcard.dto.common.UserDto;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AuthenticationUtil {

	public static UserDto getUserDto() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		return userDetailsImpl.getUserDto();
	}
}
