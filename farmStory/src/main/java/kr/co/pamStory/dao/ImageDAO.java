package kr.co.pamStory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ImageDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.PRODUCT_SQL;
import kr.co.pamStory.util.SQL2;

public class ImageDAO extends DBHelper {
	private static final ImageDAO INSTANCE = new ImageDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static ImageDAO getInstance() {
		return INSTANCE;
	}

	public void insertImage(ImageDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL2.INSERT_IMAGE);
			psmt.setInt(1, dto.getProdNo());
			psmt.setString(2, dto.getoName());
			psmt.setString(3, dto.getsName());
			psmt.executeUpdate();
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
			
		}
		
	}

	public String selectSnameByProdNo(String prodNo) {
		
		String sname = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(PRODUCT_SQL.SELECT_SNAME_BY_PRODNO);
			psmt.setString(1, prodNo);
		
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sname = rs.getString(1);
			}
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
			
		}
		
		return sname;
	}
	
	
}
