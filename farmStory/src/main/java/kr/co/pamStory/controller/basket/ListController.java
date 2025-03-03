package kr.co.pamStory.controller.basket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.BasketService;

@WebServlet("/basket/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	private BasketService service = BasketService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cateNo = req.getParameter("cateNo");
		String pg = req.getParameter("pg");

		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		/*
		 * 카테고리 종목 별로 데이터 출력
		 * null: 전체, 1번 : 과일. 2번. 야채. 3번 곡류
		 * */
		
		// 전체 데이터 출력
		if(cateNo == null) {
			list = service.findAllProduct();			
		}else { 
		// 카테고리에 맞는 데이터 출력
			list = service.findProductByCateNo(cateNo);
		}
		
		// 전체 제품 갯수
		int total = list.size();
		
		// 현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg);

		// 마지막 페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
		
		// LIMIT용 start
		int start = service.getStartNum(currentPage);
		
		// 페이지 그룹 구하기
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);
		
		// 페이지 시작번호 구하기
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// 제품 페이지에 따라 분류하기
		List<ProductDTO> products = service.getPageProducts(list, start);

		req.setAttribute("products", products);
		req.setAttribute("total", total);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
