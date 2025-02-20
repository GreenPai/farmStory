package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dto.ArticleDTO;

public enum ArticleService {
	
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public void registeArticle(ArticleDTO dto) {
		dao.insertArticle(dto);
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
