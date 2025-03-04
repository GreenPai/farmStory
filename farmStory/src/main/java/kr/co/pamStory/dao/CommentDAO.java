package kr.co.pamStory.dao;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.CommentDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class CommentDAO extends DBHelper {
	private static final CommentDAO INSTANCE = new CommentDAO();
	public static CommentDAO getInstance() {
		return INSTANCE;
	}
	private CommentDAO() {}
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	public int insertComment(CommentDTO dto) {
		int generatedKey= 0;
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.INSERT_COMMENT,Statement.RETURN_GENERATED_KEYS);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			
			psmt.executeUpdate();
			
			//자동생성된 댓글번호 조회
			rs=psmt.getGeneratedKeys();
			if(rs.next()) {
				generatedKey=rs.getInt(1);
			}
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return generatedKey;
	}
	
	public CommentDTO selectComment(int cno) {
		
		CommentDTO dto= null;
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.SELECT_COMMENT_BY_CNO);
			psmt.setInt(1, cno);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				dto= new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setRegip(rs.getString(5));
				dto.setWdate(rs.getString(6).substring(0, 10));
				dto.setNick(rs.getString(7));
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	public List<CommentDTO> selectAllComment(String parent) {
		
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.SELECT_ALL_COMMENT_BY_PARENT);
			psmt.setString(1, parent);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("dto실행");
				CommentDTO dto= new CommentDTO();
				dto.setCno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setRegip(rs.getString(5));
				dto.setWdate(rs.getString(6).substring(0,10));
				dto.setNick(rs.getString(7));
				comments.add(dto);
			}
			closeAll();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return comments;
	}
	
	public void updateComment(CommentDTO dto) {
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.UPDATE_BY_CNO);
			psmt.setString(1, dto.getContent());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getRegip());
			psmt.setInt(4, dto.getCno());
			
			int result = psmt.executeUpdate();
			
			if(result > 0) {
				logger.info("댓글 수정 완료, cno="+dto.getCno());
			}else {
				logger.warn("게시글 수정 실패, cno="+dto.getCno());
			}
			closeAll();
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	public void deleteComment(String cno) {
		
		System.out.println("dao :" + cno);
		try {
			conn=getConnection();
			psmt= conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, cno);
			psmt.executeUpdate();
			closeAll();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}