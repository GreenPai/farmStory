package kr.co.jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class ArticleDAO extends DBHelper {	
	private static final ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}
	private ArticleDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertArticle(ArticleDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public ArticleDTO selectArticle(int no) {
		return null;
	}
	
	public List<ArticleDTO> selectAllArticle() {
		return null;
	}
	
	public void updateArticle(ArticleDTO dto) {
		
	}
	
	public void deleteArticle(int no) {
		
	}
}
