package kr.co.pamStory.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.ProductService;

@WebServlet("/admin/product/list.do")
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 113546543L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//pg 데이터 수신
		String pg = req.getParameter("pg");
		
		//전체 게시물 갯수 구하기
		int total = service.getCountProduct();
		
		//마지막페이지 번호 구하기
		int lastPageNum = service.getLastPageNum(total);
		
		//현재 페이지 번호 구하기
		int currentPage = service.getCurrentPage(pg);
		
		//Limit용 start
		int start = service.getStartNum(currentPage);
		
		//페이지 그룹 구하기
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);
		
		// 페이지 시작번호 구하기 
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// 제품목록 데이터 조회
		List<ProductDTO> products = service.findAllProduct(start);
		
		req.setAttribute("products", products);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/product_list.jsp");
		dispatcher.forward(req, resp);
	}

}
