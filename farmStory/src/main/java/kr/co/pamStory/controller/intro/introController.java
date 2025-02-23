package kr.co.pamStory.controller.intro;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/intro.do")
public class introController extends HttpServlet{

	private static final long serialVersionUID = 134343434L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/intro/intro.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
