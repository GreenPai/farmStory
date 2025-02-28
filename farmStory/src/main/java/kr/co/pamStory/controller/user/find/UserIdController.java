package kr.co.pamStory.controller.user.find;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/find/userId.do")
public class UserIdController extends HttpServlet {
	private static final long serialVersionUID = 1271233365653325766L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/userId.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		// DTO 생성
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setEmail(email);
		
		if(uid != null) {
			req.setAttribute("uid", uid);
		}else {
			req.setAttribute("error", "해당 정보에 일치하는 아이디가 없습니다.");
		}

		// 결과를 출력할 페이지로 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/resultUserId.jsp");
		dispatcher.forward(req, resp);
	}
}
