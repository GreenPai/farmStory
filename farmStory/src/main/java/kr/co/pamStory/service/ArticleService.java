package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.ArticleDAO;
import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.dto.PageGroupDTO;

public enum ArticleService {
	
	INSTANCE;
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public int registeArticle(ArticleDTO dto) {
		return dao.insertArticle(dto);
	}
	
	public ArticleDTO findArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public int getCountArticle() {
		return dao.selectCountArticle();
	}
	
	public List<ArticleDTO> findAllArticle(int start) {
		return dao.selectAllArticle(start);
	}
	
	//게시글 수정
	public void modifyArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	}
	
	//글 정보 조회
	public ArticleDTO getArticle(int no) {
		return dao.selectArticle(no);
	}

	
	//페이지 시작번호 구하기(LIMIT용)
	public int getStartNum(int currentPage){
		return (currentPage -1) *10;
	}
	
	//현재 페이지 번호 구하기
	public int getCurrentPage(String pg) {
		int currentPage= 1;
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	//페이지 그룹 계산하기
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
		int currentPageGroup =(int)Math.ceil(currentPage/ 10.0);
		int pageGroupStart= (currentPageGroup - 1)* 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	//페이지 시작번호구하기
	public int getPageStartNum(int total, int currentPage) {
		int start=(currentPage -1) * 10;
		return total - start;
	} 
	
	//마지막 페이지 번호 계산
	public int getLastPageNum(int total) {
		int lastPageNum =0;
		
		if(total %10 ==0) {
			lastPageNum = total/10;
		}else {
			lastPageNum=total/10+1;
		}
		return lastPageNum;
	}
	
	public int getCountArticleBySearch(ArticleDTO dto) {
		return dao.selectCountArticleBySearch(dto);
	}
	
	public List<ArticleDTO> searchAllArticle(ArticleDTO dto, int start) {
		return dao.selectAllArticleBySearch(dto,start);
	}
	
	//게시글 삭제 서비스 메서드
	public void deleteArticle(String no) {	
			dao.deleteArticle(no);
	}

}