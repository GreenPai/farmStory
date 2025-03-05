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

/*
 * 장바구니 리스트 출력 컨트롤러
 * */
@WebServlet("/basket/basket.do")
public class basketController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	private BasketService service = BasketService.INSTANCE;
	private CartService cartservice = CartService.INSTANCE; 
	
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
		
		req.setAttribute("carts", cartDTOS);
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("prodDeliveryFee", prodDeliveryFee);
		req.setAttribute("Price", Price);
		req.setAttribute("discountPrice", discountPrice);
		req.setAttribute("finalPrice", Price - discountPrice);
		req.setAttribute("point", point);
		req.setAttribute("tot", cartDTOS.size());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/basket.jsp");
		dispatcher.forward(req, resp);
	}
	
}
