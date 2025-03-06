package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.EventDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class EventDAO extends DBHelper{
	private static final EventDAO INSTANCE = new EventDAO();

	public static EventDAO getInstance() {
		return INSTANCE;
	}
	private EventDAO() {}
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	//모든 일정 조회
	public List<EventDTO> selectAllEvents() {
		List<EventDTO> events = new ArrayList<>();
		try {
			conn= getConnection();
			psmt= conn.prepareStatement(SQL.SELECT_ALL_EVENTS);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				EventDTO dto = new EventDTO();
				dto.setUid(rs.getInt("uid"));
				dto.setTitle(rs.getString("title"));
				dto.setRegDate(rs.getString("regDate"));
				events.add(dto);
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return events;
	}
	
	//일정 등록
	public void insertEvent(EventDTO dto) {
		try {
			conn= getConnection();
			psmt= conn.prepareStatement(SQL.INSERT_EVENT);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getRegDate());
			psmt.executeUpdate();
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	
}
