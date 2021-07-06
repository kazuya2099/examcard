package com.examcard.service.top;

import java.util.Date;

import com.examcard.dao.top.Point;
import com.examcard.dao.top.UserCard;
import com.examcard.dao.top.UserCardDao;
import com.examcard.dto.top.TopDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopService {

	@Autowired
	private UserCardDao userCardDao;

	public TopDto getTopData(String userId) {
		UserCard userCardInfo = userCardDao.selectByUserId(userId);

		Point point = new Point();
		point.setUserId(userId);
		point.setSystemDate(new Date());
		TopDto topDto = new TopDto();
		BeanUtils.copyProperties(userCardInfo, topDto);

		return topDto;
	}
}
