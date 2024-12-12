package com.examcard.repository;

import com.examcard.repository.entity.UserCardEntity;

public interface UserCardRepository {
	UserCardEntity selectByUserId(String userId);
}
