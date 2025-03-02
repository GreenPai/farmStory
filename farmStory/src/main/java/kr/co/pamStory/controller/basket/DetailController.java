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
import kr.co.pamStory.service.ProductService;

@WebServlet("/basket/detail.do")
public class DetailController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo = req.getParameter("prodNo");
		ProductDTO product = service.findProductByProdNo(prodNo); 
		
		
		
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/product_images");
		System.out.println(path);
		
		req.setAttribute("path", path + "/market_item1.jpg");
		req.setAttribute("product", product);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/detail.jsp");
		dispatcher.forward(req, resp);
	}
	
}
