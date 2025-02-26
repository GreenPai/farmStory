package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class ArticleDAO extends DBHelper {	
	private static final ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}
	private ArticleDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleDTO dto) {
		
		int no = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			
			// 글 번호 조회 쿼리 실행
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return no;
	}
	
	public ArticleDTO selectArticle(int no) {
		return null;
	}
	
	public int selectCountArticle() {
		int total=0;
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(SQL.SELECT_COUNT_ARTICLE);
			if(rs.next()) {
				total= rs.getInt(1);
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	public List<ArticleDTO> selectAllArticle(int start) {
		
		List<ArticleDTO> articles = new ArrayList<ArticleDTO>();
		
		try {
			
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.SELECT_ALL_ARTICLE);
			psmt.setInt(1, start);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				articles.add(dto);
			}
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return articles;
		
		
	}
	
	public void updateArticle(ArticleDTO dto) {
		
	}
	
	public void deleteArticle(int no) {
		
	}
}