package kr.co.pamStory.controller.admin;

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

@WebServlet("/admin/product/list.do")
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 113546543L;
	private ProductService productservice = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductDTO> productDTOS = productservice.findAllProduct();
		System.out.println(productDTOS.toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/product_list.jsp");
		dispatcher.forward(req, resp);
	}

}
