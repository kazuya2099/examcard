package com.examcard.service.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examcard.component.authentication.UserDetailsImpl;
import com.examcard.dao.common.User;
import com.examcard.dao.common.UserDao;
import com.examcard.dto.common.UserDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> list = userDao.selectUser(username);
		if (list == null) {
			throw new UsernameNotFoundException(username + " is not exists!");
		}

		User user = list.get(0);
		List<GrantedAuthority> authorities = new ArrayList<>();
		list.forEach(e -> {
			authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + e.getRole()));
		});

		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user.getId(), user.getPassword(), authorities);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setRoles(authorities.stream().map(e -> e.toString()).collect(Collectors.toList()));
		userDetailsImpl.setUserDto(userDto);
		return userDetailsImpl;
	}
}
