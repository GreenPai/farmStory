package kr.co.pamStory.dao;

import kr.co.pamStory.dto.TermsDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class TermsDAO extends DBHelper {
	private static final TermsDAO INSTANCE = new TermsDAO();
	public static TermsDAO getInstance() {
		return INSTANCE;
	}
	private TermsDAO() {}
	
	public void insertTerms(TermsDTO dto) {
		
	}
	
	public TermsDTO selectTerms(int no) {
		
		TermsDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_TERMS);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new TermsDTO();
				dto.setNo(rs.getInt(1));
				dto.setTerms(rs.getString(2));
				dto.setPrivacy(rs.getString(3));
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}