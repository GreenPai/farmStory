package kr.co.pamStory.controller.article.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.service.ArticleService;

@WebServlet("/article/search.do")
public class SearchController extends HttpServlet{

	private static final long serialVersionUID = -607773434902097415L;
	private ArticleService service= ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 수신
		String pg= req.getParameter("pg");
		String searchType= req.getParameter("searchType");
		String keyword= req.getParameter("keyword");
		
		// 카테고리 수신
		HttpSession session = req.getSession();
		String cate = (String) session.getAttribute("cate");
		
		// 
		//DTO 생성
		ArticleDTO dto= new ArticleDTO();
		dto.setSearchType(searchType);
		dto.setKeyword(keyword);
		dto.setCate(cate);
		
		//페이징 처리 관련 서비스 호출
		int total= service.getCountArticleBySearch(dto);
		int lastPageNum= service.getLastPageNum(total);
		int currentPage= service.getCurrentPage(pg);
		int start= service.getStartNum(currentPage);
		
		PageGroupDTO pageGroupDTO= service.getCurrentPageGroup(currentPage, lastPageNum);
		int pageStartNum= service.getPageStartNum(total, currentPage);
		
		//서비스 호출
		List<ArticleDTO> articles= service.searchAllArticle(dto, start);
		
		//데이터 참조공유
		req.setAttribute("articles", articles);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		req.setAttribute("searchType", searchType);
		req.setAttribute("keyword", keyword);
		
		RequestDispatcher dispatcher;
		if(cate.equals("grow") ) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_grow.jsp");			
		}else if(cate.equals("story")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_story.jsp");
		}else if(cate.equals("school")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_school.jsp");
		}else if(cate.equals("food")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_food.jsp");
		}else if(cate.equals("cook")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_cook.jsp");
		}else if(cate.equals("qna1")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_qna1.jsp");
		}else if(cate.equals("qna2")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_qna2.jsp");
		}else {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/list/list_notice.jsp");
		}
		
		dispatcher.forward(req, resp);
	}

}
