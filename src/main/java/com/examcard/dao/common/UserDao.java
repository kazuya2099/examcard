package com.examcard.dao.common;

import java.util.List;

public interface UserDao {

	public List<User> selectUser(String mailAddress);
	public User selectUserById(String id);
}
