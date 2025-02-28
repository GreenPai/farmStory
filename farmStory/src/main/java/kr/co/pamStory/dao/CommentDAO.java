package kr.co.pamStory.dao;



import java.sql.Statement;
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
		return null;
	}
	
	public List<CommentDTO> selectAllComment() {
		return null;
	}
	
	public void updateComment(CommentDTO dto) {
		
	}
	
	public void deleteComment(int cno) {
		
	}
}