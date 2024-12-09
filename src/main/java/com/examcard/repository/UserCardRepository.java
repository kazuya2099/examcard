package com.examcard.repository;

import com.examcard.repository.entity.UserCard;

public interface UserCardRepository {
	UserCard selectByUserId(String userId);
}
