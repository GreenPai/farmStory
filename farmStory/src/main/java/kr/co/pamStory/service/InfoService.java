package kr.co.pamStory.service;

import kr.co.pamStory.dao.InfoDAO;

public enum InfoService {

	INSTANCE;
	private InfoDAO dao = InfoDAO.getInstance();

	public boolean modifyPass(String pass, String passOK) {
		return dao.updateInfoPass(pass, passOK);
	}
	
	public boolean checkCurrentPassword(String uid, String pass) {
	    return dao.isCurrentPasswordCorrect(uid, pass);
	}
}
