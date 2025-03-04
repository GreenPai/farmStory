package kr.co.pamStory.controller.basket;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.UserDTO;

@WebServlet("/basket/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1123123L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String prodNo = req.getParameter("prodNo");
		String cartProdCount = req.getParameter("cartProdCount");
		
		HttpSession session = req.getSession();
		UserDTO userdto = (UserDTO) session.getAttribute("sessUser");
		System.out.println(userdto.getUid());
		
	}

}
