package kr.co.pamStory.controller.intro;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.ProductService;

@WebServlet(urlPatterns = {"/index.do"})
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1123123L;
	private ProductService productservice = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductDTO> productDTOS = productservice.findBest6Products();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/intro/main.jsp");
		dispatcher.forward(req, resp);
	
	}

}
