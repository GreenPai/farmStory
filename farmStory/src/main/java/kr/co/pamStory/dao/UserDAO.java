package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.util.BASKET_SQL;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;
import kr.co.pamStory.util.SQL2;

public class UserDAO extends DBHelper {
	private static final UserDAO INSTANCE = new UserDAO();
	public static UserDAO getInstance() {
		return INSTANCE;
	}
	private UserDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getRegip());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int selectCountUser(String type, String value) {
		
		int count = 0;
		
		// String 불변성을 고려해 StringBuilder로 동적 SQL 생성 
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_USER);
		
		if(type.equals("uid")) {
			sql.append(SQL.WHERE_UID);
		}else if(type.equals("nick")) {
			sql.append(SQL.WHERE_NICK);
		}else if(type.equals("email")) {
			sql.append(SQL.WHERE_EMAIL);
		}else if(type.equals("hp")) {
			sql.append(SQL.WHERE_HP);
		}
		
		// String - 불변
		/* String name = "한결";
		 * name = "한결1";
		 * name = "한결2";
		 * 한결 -> 한결1 -> 한결2 -> 한결3 
		 * 
		 * StringBuilder 
		 * select COUNT(*) from `user` where `uid`=?   
		 * */
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, value);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return count;
	}
	
	public UserDTO selectUser(String uid) {
		return null;
	}
	
	public UserDTO selectUser(UserDTO dto) {
		
		UserDTO userDTO = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				userDTO = new UserDTO();
				userDTO.setUid(rs.getString(1));
				userDTO.setPass(rs.getString(2));
				userDTO.setName(rs.getString(3));
				userDTO.setNick(rs.getString(4));
				userDTO.setEmail(rs.getString(5));
				userDTO.setHp(rs.getString(6));
				userDTO.setRole(rs.getString(7));
				userDTO.setZip(rs.getString(8));
				userDTO.setAddr1(rs.getString(9));
				userDTO.setAddr2(rs.getString(10));
				userDTO.setRegip(rs.getString(11));
				userDTO.setRegDate(rs.getString(12));
				userDTO.setLeaveDate(rs.getString(13));
			}
			closeAll();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}
	
	public List<UserDTO> selectAllUser() {
		return null;
	}

	
	public void updateUser(UserDTO dto) {
		
	}
	
	public void deleteUser(String uid) {
		
	}
	public UserDTO selectUserByNameAndEmail(String name, String email) {
		
		UserDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER_BY_NAME_AND_EMAIL);
			psmt.setString(1, name);
			psmt.setString(2, email);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setName(rs.getString(1));
				dto.setUid(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setRegDate(rs.getString(4));
				
			}else {
				dto = new UserDTO();
				dto.setUid("인증실패");
			}
			
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	public UserDTO selectUserByUidAndEmail(String uid, String email) {
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER_BY_UID_AND_EMAIL);
			psmt.setString(1, uid);
			psmt.setString(2, email);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUid(rs.getString(1));
			}else {
				dto = new UserDTO();
				dto.setUid("인증실패");
			}
			
			closeAll();
			
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	/*
	public UserDTO selectResultFindId(String name, String uid, String email, String regDate) {
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_RESULT_FIND_ID);
			psmt.setString(1, name);
			psmt.setString(2, uid);
			psmt.setString(3, email);
			psmt.setString(4, regDate);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setName(rs.getString(1));
				dto.setUid(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setRegDate(rs.getString(4));
			}
			
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
		return dto;
	}
	*/
	public List<UserDTO> selectLatest3Users() {
		List<UserDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(SQL2.SELECT_USER_LIMIT_3);
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setUid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setNick(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setHp(rs.getString(6));
				dto.setRole(rs.getString(7));
				dto.setZip(rs.getString(8));
				dto.setAddr1(rs.getString(9));
				dto.setAddr2(rs.getString(10));
				dto.setRegip(rs.getString(11));
				dto.setRegDate(rs.getString(12));
				dto.setLeaveDate(rs.getString(13));
				dto.setUserPoint(rs.getInt(14));
				dto.setUserLevel(rs.getInt(15));
				dtos.add(dto);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}
	public int selectUserPoint(String uid) {
		int point = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(BASKET_SQL.SELECT_POINT_BY_UID);
			psmt.setString(1, uid);
			rs =  psmt.executeQuery();
			while(rs.next()) {
				point = rs.getInt(1);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return point;
	}
	/*
	public UserDTO updatePassWord(String uid, String pass, String pass1, String pass2) {
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_PASSWORD);
			psmt.setString(1, pass);
			psmt.setString(2, uid);
			
			int result = psmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("<script>alert('비밀번호가 성공적으로 변경되었습니다!');"
						+ "location.href='./login.do';</script>");
			}else {
				System.out.println("<script>alert('비밀번호 변경 실패. 다시 시도해주세요.');"
						+ "location.href='./password.do';</script>");
			}
			
			closeAll();
			
			
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dto;

	}
	*/
	public boolean updatePassword(String uid, String pass1) {
		// 기본값 false
		boolean isUpdated = false;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_PASSWORD);
			psmt.setString(1, pass1);
			psmt.setString(2, uid);
			
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
	

}




