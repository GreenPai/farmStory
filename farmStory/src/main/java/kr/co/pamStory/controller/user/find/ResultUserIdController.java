package kr.co.pamStory.controller.user.find;

import java.io.IOException;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/find/resultUserId.do")
public class ResultUserIdController extends HttpServlet {
	
	private static final long serialVersionUID = 1275653365653325736L;
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserDTO userdto = (UserDTO) session.getAttribute("sessUser");
		
		req.setAttribute("dto", userdto);
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/resultUserId.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("email");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/resultUserId.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
