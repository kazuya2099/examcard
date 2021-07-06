package com.examcard.service.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.dao.common.User;
import com.examcard.dao.common.UserDao;
import com.examcard.dto.common.UserDto;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserDto getUser(String id) {
		User user = userDao.selectUserById(id);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
}
