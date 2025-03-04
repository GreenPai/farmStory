package kr.co.pamStory.controller.basket;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.CartDTO;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.BasketService;
import kr.co.pamStory.service.CartService;
import kr.co.pamStory.service.UserService;

@WebServlet("/basket/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 11232322313L;
	private BasketService service = BasketService.INSTANCE;
	private CartService cartservice = CartService.INSTANCE;
	private UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserDTO userdto = (UserDTO) session.getAttribute("sessUser");
		
		String uid = userdto.getUid();
		
		List<CartDTO> cartDTOS = cartservice.findCartByUid(uid);
		
		// 전체 상품 수 
		int totalCnt = cartservice.countProduct(cartDTOS);
		
		// 총 배송비
		// 제품 3만원 이상 구매시 무료
		int prodDeliveryFee = cartservice.calculateDeliveryFee(cartDTOS);
		
		// 총 금액
		int Price = cartservice.calculatePrice(cartDTOS);
		
		// 할인된 총 금액
		int discountPrice = cartservice.calculateDiscount(cartDTOS);
		
		// 총 포인트
		int point = cartservice.calculatePoint(cartDTOS);
		
		// 유저가 가진 포인트
		int userPoint = userservice.findUserPoint(uid);
		
		System.out.println("포인트" + userPoint);
		
		
		req.setAttribute("carts", cartDTOS);
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("prodDeliveryFee", prodDeliveryFee);
		req.setAttribute("Price", Price);
		req.setAttribute("discountPrice", discountPrice);
		req.setAttribute("finalPrice", Price - discountPrice);
		req.setAttribute("point", point);
		req.setAttribute("userPoint", userPoint);
		req.setAttribute("tot", cartDTOS.size());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("포스트");
	}
	
}
