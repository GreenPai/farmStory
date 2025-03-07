package kr.co.pamStory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.PointDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class PointDAO extends DBHelper{
	private static final PointDAO INSTANCE = new PointDAO();

	public static PointDAO getInstance() {
		return INSTANCE;
	}

	private PointDAO() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 포인트 정보 (적립, 사용)
	public void insertPoint(PointDTO pointDTO) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_POINT);
			psmt.setString(1, pointDTO.getUid());
			psmt.setInt(2, pointDTO.getPoint());
			psmt.setString(3, pointDTO.getPointDesc());
			psmt.executeUpdate();
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}


	
}
