package kr.co.pamStory.service;

import kr.co.pamStory.dao.PointDAO;
import kr.co.pamStory.dto.PointDTO;

public enum PointService {
	INSTANCE;
	private PointDAO dao = PointDAO.getInstance();

	public void registerPoint(PointDTO pointDTO) {
		dao.insertPoint(pointDTO);
	}
	
	
}
