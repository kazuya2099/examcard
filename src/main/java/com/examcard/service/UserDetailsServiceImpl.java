package com.examcard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examcard.component.authentication.UserDetailsImpl;
import com.examcard.entity.User;
import com.examcard.repository.common.UserRepository;
import com.examcard.service.dto.UserDto;

/**
 * DIコンテナに登録すると自動検出してくれるので紐づけ設定不要.
 * @author mhama
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> list = userRepository.selectUser(username);
		if (CollectionUtils.isEmpty(list)) {
			throw new UsernameNotFoundException(username + " is not exists!");
		}
		User user = list.get(0);
		List<GrantedAuthority> authorities = list.stream().map(e -> {return new SimpleGrantedAuthority(ROLE_PREFIX + e.getRole());}).collect(Collectors.toList());
		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		list.forEach(e -> {
//			authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + e.getRole()));
//		});
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user.getId(), user.getPassword(), authorities);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setRoleList(authorities.stream().map(e -> e.toString()).collect(Collectors.toList()));
		userDetailsImpl.setUserDto(userDto);
		return userDetailsImpl;
	}
}
