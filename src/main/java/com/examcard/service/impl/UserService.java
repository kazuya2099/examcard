package com.examcard.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.entity.User;
import com.examcard.repository.common.UserRepository;
import com.examcard.service.dto.UserDto;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDto getUser(String id) {
		User user = userRepository.selectUserById(id);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
}
