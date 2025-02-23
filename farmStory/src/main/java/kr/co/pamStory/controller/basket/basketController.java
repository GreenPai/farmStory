package kr.co.pamStory.controller.basket;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/basket/basket.do")
public class basketController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/basket.jsp");
		dispatcher.forward(req, resp);
	}
	
}
