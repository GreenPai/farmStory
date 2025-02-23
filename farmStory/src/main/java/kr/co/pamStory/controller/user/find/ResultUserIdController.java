package kr.co.pamStory.controller.user.find;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/find/resultUserId.do")
public class ResultUserIdController extends HttpServlet {
	private static final long serialVersionUID = 1275653365653325736L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/resultUserId.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
