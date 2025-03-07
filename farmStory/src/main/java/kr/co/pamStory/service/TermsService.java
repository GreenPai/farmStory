package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.TermsDAO;
import kr.co.pamStory.dto.TermsDTO;

public enum TermsService {
	
	INSTANCE;
	private TermsDAO dao = TermsDAO.getInstance();
	
	public void registeArticle(TermsDTO dto) {
		dao.insertTerms(dto);
	}
	
	public TermsDTO findTerms(int no) {
		return dao.selectTerms(no);
	}
	
}