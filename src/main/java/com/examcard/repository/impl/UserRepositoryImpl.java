package com.examcard.repository.impl;

import com.examcard.mapper.UserMapper;
import com.examcard.repository.UserRepository;
import com.examcard.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private UserMapper userMapper;

  public UserEntity selectUser(String mail, String password) {
    return userMapper.selectUser(mail, password);
  }

  public UserEntity selectUserById(String id) {
    return userMapper.selectUserById(id);
  }
}
