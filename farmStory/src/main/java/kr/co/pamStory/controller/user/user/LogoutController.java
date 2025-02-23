package kr.co.pamStory.controller.user.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/logout.do")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 2267721817036680982L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션 해제
		HttpSession session = req.getSession();
		
		session.removeAttribute("sessUser");
		session.invalidate();
		
		// 로그인 이동
		resp.sendRedirect("/farmStory/user/login.do?result=101");
	
	}
	
}
