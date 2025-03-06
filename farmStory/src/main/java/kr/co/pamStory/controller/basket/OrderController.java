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
import kr.co.pamStory.dto.CreditDTO;
import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.dto.OrderItemDTO;
import kr.co.pamStory.dto.PointDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.BasketService;
import kr.co.pamStory.service.CartService;
import kr.co.pamStory.service.OrderItemService;
import kr.co.pamStory.service.OrderService;
import kr.co.pamStory.service.PointService;
import kr.co.pamStory.service.ProductService;
import kr.co.pamStory.service.UserService;

@WebServlet("/basket/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 11232322313L;
	private BasketService service = BasketService.INSTANCE;
	private CartService cartservice = CartService.INSTANCE;
	private UserService userservice = UserService.INSTANCE;
	private OrderService orderservice = OrderService.INSTANCE;
	private OrderItemService orderitemservice = OrderItemService.INSTANCE;
	private PointService pointservice = PointService.INSTANCE;
	private ProductService productsevice= ProductService.INSTANCE;
	
	
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
		
		CreditDTO dto = new CreditDTO();
		dto.setTotalCnt(totalCnt);
		dto.setProdDeliveryFee(prodDeliveryFee);
		dto.setPrice(Price);
		dto.setDiscountPrice(discountPrice);
		dto.setFinalPrice(Price - discountPrice);
		dto.setPoint(point);
		dto.setUserPoint(userPoint);
		dto.setTot(cartDTOS.size());
		

		session.setAttribute("creditdto", dto);
		session.setAttribute("cartdtos", cartDTOS);
		
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

		HttpSession session = req.getSession();
		UserDTO userdto = (UserDTO) session.getAttribute("sessUser");
		CreditDTO creditdto = (CreditDTO) session.getAttribute("creditdto");

		String uid = userdto.getUid();
		List<CartDTO> cartDTOS = cartservice.findCartByUid(uid);;
		String orderSender = req.getParameter("name");
		String senderHp = req.getParameter("hp");
		
		int usePoint = 0;
		if(req.getParameter("usePoint") != "" ) {
			usePoint = Integer.parseInt(req.getParameter("usePoint"));			
		}
		
		String receiver = req.getParameter("receiver");
		String receiverHp = req.getParameter("receiverHp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String payment = req.getParameter("payment");
		String orderContent = req.getParameter("other_info");
		
		// OrderDTO
		OrderDTO dto = new OrderDTO();
		dto.setUid(uid);
		dto.setOrderTotalPrice(creditdto.getFinalPrice());
		dto.setOrderAddr(addr1 + addr2);
		dto.setOrderSender(orderSender);
		dto.setOrderHp(senderHp);
		dto.setOrderReceiver(receiver);
		dto.setReceiverHp(receiverHp);
		dto.setOrderContent(orderContent);
		dto.setPayment(payment);
		
		// 포인트 적립
		PointDTO pointDTO = new PointDTO();
		pointDTO.setUid(uid);
		pointDTO.setPoint(creditdto.getPoint());
		pointDTO.setPointDesc("상품구매 포인트 적립 : " + creditdto.getPoint() + "P");
		pointservice.registerPoint(pointDTO);
		userservice.modifyPoint(pointDTO);
		
		// 포인트 사용
		if(usePoint > 0) {
			// 포인트 사용 내역 저장
			PointDTO delPointDTO = new PointDTO();
			pointDTO.setUid(uid);
			pointDTO.setPoint(usePoint);
			pointDTO.setPointDesc("상품구매 포인트 사용 : " + usePoint + "P");
			pointservice.registerPoint(pointDTO);
			
			// User 포인트 총량 수정
			pointDTO.setPoint(usePoint * -1);
			userservice.modifyPoint(pointDTO);
			
		}
		
		// 주문 데이터 입력
		int orderNo = orderservice.registerOrder(dto);
		
		// 주문 상세 데이터 입력 / 제품 재고 줄이기
		for(CartDTO cartDTO : cartDTOS) {
			// 상세 데이터 입력
			OrderItemDTO orderItemDTO = new OrderItemDTO();
			System.out.println("ProdNO" + cartDTO.getProdNo());
			ProductDTO productDTO = productsevice.findProductByProdNo(String.valueOf(cartDTO.getProdNo()));
			
			orderItemDTO.setOrderNo(orderNo);
			orderItemDTO.setProdNo(cartDTO.getProdNo());
			orderItemDTO.setItemCount(cartDTO.getCartProdCount());
			orderItemDTO.setItemPrice(productDTO.getProdPrice());
			orderItemDTO.setItemDiscount(productDTO.getProdDiscount());
			
			orderitemservice.register(orderItemDTO);
			
			// 제품 재고 줄이기 / 제품 판매량 늘리기
			productsevice.minusProduct(cartDTO.getProdNo(), cartDTO.getCartProdCount());
		}


		// 카테고리 비우기
		cartservice.deleteCartByUid(uid);
		
		resp.sendRedirect("/farmStory/myinfo/list.do");
		
	}
	
}
