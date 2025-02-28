package kr.co.pamStory.controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
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
		
		
		
		
		
	}


}
