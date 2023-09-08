package com.examcard.repository.top;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointRepository {
	/**
	 * 保有ポイントを取得
	 * @param userId
	 * @return
	 */
	Point selectPoint(Point point);

	/**
	 * 獲得予定ポイントを取得
	 * @param userId
	 * @return
	 */
	Point selectFuturePoint(Point point);
}
