package kr.co.pamStory.controller.basket;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.service.CartService;

@WebServlet("/basket/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1123123L;
	private CartService service = CartService.INSTANCE; 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] cartNos = req.getParameterValues("cartNos");
		
		
		if (cartNos != null) {
		    for (String cartNo : cartNos) {
		        service.deleteCart(cartNo); // 삭제 수행
		    }

		    // 성공 메시지 전송
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write("{\"status\": \"success\"}"); // JSON 형식으로 응답
		} else {
		    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 에러
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write("{\"status\": \"error\", \"message\": \"Invalid cartNos\"}");
		}
	
	}

}
