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
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.OrderService;
import kr.co.pamStory.service.ProductService;
import kr.co.pamStory.service.UserService;

@WebServlet("/admin/main.do")
public class MainController extends HttpServlet{

	private static final long serialVersionUID = 112322313L;
	private ProductService productservice = ProductService.INSTANCE;
	private UserService userservice = UserService.INSTANCE;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 상품 리스트 3개
		List<ProductDTO> productDTOS = productservice.findLatest3Products();
		//System.out.println(productDTOS.toString());
		
		// 유저 리스트 3개
		List<UserDTO> userDTOS = userservice.findLatest3Users();
		System.out.println(userDTOS.toString());
		
		// 주문 리스트 3개
		List<OrderDTO> orderDTOS = OrderService.findLatest3Orders();
		//System.out.println(orderDTOS.toString());
		
		// 데이터 뷰로 전달
		req.setAttribute("products", productDTOS);
		req.setAttribute("users", userDTOS);
		req.setAttribute("orders", orderDTOS);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/main.jsp");
		dispatcher.forward(req, resp);
	}


}
