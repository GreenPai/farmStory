package kr.co.pamStory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.InfoDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class InfoDAO extends DBHelper {

	private static final InfoDAO INSTANCE = new InfoDAO();
	public static InfoDAO getInstance() {
		return INSTANCE;
	}
	private InfoDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean updateInfoPass(String pass, String passOK) {

		// 기본값 false
		boolean isUpdated = false;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_PASSWORD);
			psmt.setString(1, pass);
			psmt.setString(2, passOK);

			// 업데이트 행 수 반환
			int result = psmt.executeUpdate();

			// 1개 이상 변경되었으면 true
			isUpdated = result > 0;

			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}

		return isUpdated;
	}
	
	public boolean isCurrentPasswordCorrect(String uid, String pass) {
	    boolean isValid = false;

	    try {
	        conn = getConnection();
	        psmt = conn.prepareStatement(SQL.IS_CURRENT_PASSWORD_CORRECT);
	        psmt.setString(1, uid);

	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            String storedPass = rs.getString("pass");

	            // 비밀번호 비교
	            if (storedPass.equals(pass)) {
	                isValid = true;
	            }
	        }

	        closeAll();
	    } catch (Exception e) {
	        logger.error(e.getMessage());
	    }

	    return isValid;
	}
}

