package kr.co.pamStory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.dto.CategoryDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class CategoryDAO extends DBHelper{
	private static final CategoryDAO INSTANCE = new CategoryDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static CategoryDAO getInstance() {
		return INSTANCE;
	}

	private CategoryDAO() {
	}

	public CategoryDTO selectcateNo(String cateName) {
		CategoryDTO dto = null;
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CATEGORY_BY_CATENAME);
			psmt.setString(1, cateName);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new CategoryDTO();
				dto.setCateNo(rs.getInt(1));
				dto.setCateName(rs.getString(2));
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	
	
	

}
