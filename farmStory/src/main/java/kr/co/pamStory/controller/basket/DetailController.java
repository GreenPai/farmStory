package kr.co.pamStory.controller.basket;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.ImageService;
import kr.co.pamStory.service.ProductService;

@WebServlet("/basket/detail.do")
public class DetailController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	private ProductService productservice = ProductService.INSTANCE;
	private ImageService imageservice =ImageService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		
		// 제품 탐색
		ProductDTO product = productservice.findProductByProdNo(prodNo); 
		
		// 이미지 탐색
		String imageName = imageservice.findImageSnameByProdNo(prodNo);
		System.out.println(product.getProdDeliveryFee());
		req.setAttribute("product", product);
		req.setAttribute("imageName", imageName);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/detail.jsp");
		dispatcher.forward(req, resp);
	}
	
}
