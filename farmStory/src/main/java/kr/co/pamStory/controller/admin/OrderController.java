package kr.co.pamStory.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.service.OrderService;

@WebServlet("/admin/order/list.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OrderService orderservice = OrderService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// List<OrderDTO> orderDTOS = orderservice.findAllOrder();
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/order_list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
