package com.examcard.mapper;

import com.examcard.repository.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** ユーザーマスタマッパークラス */
@Mapper
public interface UserMapper {

  /**
   * メールアドレスで検索
   *
   * @param mailAddress
   * @return
   */
  public UserEntity selectUser(@Param("mail") String mail, @Param("password") String password);

  /**
   * IDで検索
   *
   * @param id
   * @return
   */
  public UserEntity selectUserById(@Param("id") String id);
}
