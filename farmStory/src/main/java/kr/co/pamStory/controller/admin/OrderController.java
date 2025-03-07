package kr.co.pamStory.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.OrderService;

@WebServlet("/admin/order/list.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OrderService service = OrderService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//pg 데이터 수신
		String pg = req.getParameter("pg");
		
		//전체 상품 갯수 구하기
		int total = service.getCountOrder();
		
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
		List<OrderDTO> orders = service.findAllOrder(start);
		
		req.setAttribute("orders", orders);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/order_list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
