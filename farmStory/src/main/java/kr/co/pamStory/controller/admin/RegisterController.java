package kr.co.pamStory.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.CategoryDTO;
import kr.co.pamStory.dto.ImageDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.service.CategoryService;
import kr.co.pamStory.service.ImageService;
import kr.co.pamStory.service.ProductService;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ImageService imageservice = ImageService.INSTANCE;
	private CategoryService categoryservice = CategoryService.INSTANCE;
	private ProductService productservice = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/product_register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String name = req.getParameter("name");
		String cateName = req.getParameter("cateName");
		String price = req.getParameter("price");
		String point = req.getParameter("point");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("delivery");
		String stock = req.getParameter("stock");
		String other = req.getParameter("other");
		
		// 이미지 업로드 서비스 호출
		List<ImageDTO> imageDTOS = imageservice.uploadImage(req);
		System.out.println("imageDTO : "+imageDTOS.toString());
		
		// 카테고리 번호 구하기
		CategoryDTO cateDTO = categoryservice.findCateNo(cateName);
		System.out.println("cateDTO : " + cateDTO.toString());
		
		// Product DTO 저장
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdName(name);
		productDTO.setCateName(cateName);
		productDTO.setProdPrice(Integer.parseInt(price));
		productDTO.setProdPoint(Integer.parseInt(point));
		productDTO.setProdDiscount(Integer.parseInt(discount));
		productDTO.setProdDeliveryFee(Integer.parseInt(delivery));
		productDTO.setProdStock(Integer.parseInt(stock));
		productDTO.setProdContent(other);
		productDTO.setCateNo(cateDTO.getCateNo());
		
		int prodNo = productservice.registerProduct(productDTO);

		// 이미지 dto 저장 
		for(ImageDTO imageDTO : imageDTOS) {
			imageDTO.setProdNo(prodNo);
			imageservice.registerImage(imageDTO);
		}
		
		resp.sendRedirect("/farmStory/admin/product/list.do");
	}


}
