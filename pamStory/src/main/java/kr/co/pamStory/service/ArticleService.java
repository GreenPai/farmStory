package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.ArticleDAO;
import kr.co.pamStory.dto.ArticleDTO;

public enum ArticleService {
	
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public int registeArticle(ArticleDTO dto) {
		return dao.insertArticle(dto);
	}
	
	public ArticleDTO findArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public List<ArticleDTO> findAllArticle() {
		return dao.selectAllArticle();
	}
	
	public void modifyArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	}
	
	public void deleteArticle(int no) {
		dao.deleteArticle(no);
	}
}