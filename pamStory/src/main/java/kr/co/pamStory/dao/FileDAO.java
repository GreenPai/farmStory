package kr.co.pamStory.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.FileDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class FileDAO extends DBHelper {
	private static final FileDAO INSTANCE = new FileDAO();
	public static FileDAO getInstance() {
		return INSTANCE;
	}
	private FileDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertFile(FileDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_FILE);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getoName());
			psmt.setString(3, dto.getsName());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public FileDTO selectFile(int fno) {
		return null;
	}
	
	public List<FileDTO> selectAllFile() {
		return null;
	}
	
	public void updateFile(FileDTO dto) {
		
	}
	
	public void deleteFile(int fno) {
		
	}
}