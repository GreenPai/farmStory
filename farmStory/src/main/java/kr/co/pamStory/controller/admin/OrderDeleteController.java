package kr.co.pamStory.controller.admin;



import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.service.ImageService;
import kr.co.pamStory.service.ProductService;

@WebServlet
public class OrderDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService productservice = ProductService.INSTANCE;
	private ImageService imageservice = ImageService.INSTANCE
			;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		String[] prodNos = req.getParameterValues("prodNos");
		
		if (prodNos != null) {
			for(String prodNo : prodNos) {
				
				imageservice.deleteImage(prodNo);
				productservice.deleteProduct(prodNo);
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
