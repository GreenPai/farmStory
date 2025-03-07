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

@WebServlet("/article/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1271262765653325736L;

	private ArticleService service = ArticleService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// pg 데이터 수신
		String pg = req.getParameter("pg");
		
		// 카테고리 수신
		String cate = req.getParameter("cate");
		
		HttpSession session = req.getSession();

		// 글 기본 값을 공지사항으로 
		if((session.getAttribute("cate") == null)) {
			cate = "notice";
		}else {
			if(cate == null) {
				cate = (String) session.getAttribute("cate");				
			}
		}
		
		session.setAttribute("cate", cate);
		
		// 전체 게시물 갯수 구하기
		// int total = service.getCountArticle();
		int total = service.getCountArticleByCate(cate);
		
		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
		
		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg);
		
		// LIMIT용 start
		int start = service.getStartNum(currentPage);
		
		// 페이지 그룹 구하기
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);

		// 페이지 시작번호 구하기
		int pageStartNum = service.getPageStartNum(total, currentPage);

		// 글목록 데이터 조회
		// List<ArticleDTO> articles = service.findAllArticle(start);
		List<ArticleDTO> articles = service.findAllArticleByCate(start,cate);
		
		// 데이터 참조 공유
		req.setAttribute("articles", articles);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);

		// View forward
		
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