package com.examcard.dao.top;

public interface PointDao {

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
