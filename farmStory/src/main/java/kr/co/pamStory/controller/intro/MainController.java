package kr.co.pamStory.controller.intro;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.ArticleService;
import kr.co.pamStory.service.ProductService;

@WebServlet(urlPatterns = {"/index.do"})
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1123123L;
	private ProductService productservice = ProductService.INSTANCE;
	private ArticleService articleserice = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String error = req.getParameter("result");
		
		List<ProductDTO> productDTOS = productservice.findBest6Products();
		List<ArticleDTO> storys = articleserice.findByCateLimit5("story");
		List<ArticleDTO> grows = articleserice.findByCateLimit5("grow");
		List<ArticleDTO> schools = articleserice.findByCateLimit5("school");
		List<ArticleDTO> notices = articleserice.findByCateLimit5("notice");
		
		req.setAttribute("products", productDTOS);
		req.setAttribute("grows", grows);
		req.setAttribute("schools", schools);
		req.setAttribute("storys", storys);
		req.setAttribute("notices", notices);
		req.setAttribute("result", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/intro/main.jsp");
		dispatcher.forward(req, resp);
	
	}

}
