package kr.co.pamStory.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dao.EventDAO;
import kr.co.pamStory.dto.EventDTO;

public enum EventService {

	INSTANCE;

	private EventDAO dao = EventDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<EventDTO> findAllEvents() {

		return dao.selectAllEvents();
	}

	public void registerEvent(EventDTO dto) {
		dao.insertEvent(dto);
	}
}
