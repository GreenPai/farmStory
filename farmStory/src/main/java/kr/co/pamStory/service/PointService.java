package kr.co.pamStory.service;

import kr.co.pamStory.dao.PointDAO;
import kr.co.pamStory.dto.PointDTO;

public enum PointService {
	INSTANCE;
	private PointDAO dao = PointDAO.getInstance();

	// 포인트 사용 내용 기록 : 적립, 사용
	public void registerPoint(PointDTO pointDTO) {
		dao.insertPoint(pointDTO);
	}


	
	
}
