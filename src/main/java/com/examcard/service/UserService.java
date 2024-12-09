package com.examcard.service;

import org.springframework.stereotype.Service;

import com.examcard.service.dto.UserDto;

@Service
public interface UserService {

	public UserDto getUser(String id);
}
