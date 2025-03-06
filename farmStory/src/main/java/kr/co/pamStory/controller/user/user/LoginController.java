package kr.co.pamStory.controller.user.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1270462765653325712L;
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 수신
		String result = req.getParameter("result");
		
		// 데이터 공유 참조
		req.setAttribute("result", result);		
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/user/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("로그인 문제 확인");
		// 데이터 수신
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");

		// DTO 생성
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		
		// 서비스 호출	
		UserDTO userDTO = service.findUser(dto);

		if(userDTO != null) {
			// 회원이 맞을 경우 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", userDTO);
			
			// 게시판 목록 이동
			resp.sendRedirect("/farmStory/index.do");
		}else {
			// 회원이 아닐 경우 다시 로그인 페이지 이동
			resp.sendRedirect("/farmStory/user/login.do?result=100");			
		}
	}
}







