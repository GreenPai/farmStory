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

@WebServlet("/find/resultUserId.do")
public class ResultUserIdController extends HttpServlet {
	
	private static final long serialVersionUID = 1275653365653325736L;
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/resultUserId.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("email");
		/*
		// 데이터 수신
		String name = req.getParameter("name");
		String uid = req.getParameter("uid");
		String email = req.getParameter("email");
		String regDate = req.getParameter("regDate");
		
		// DTO 생성
		UserDTO dto = new UserDTO();
		dto.setName(name);
		dto.setUid(uid);
		dto.setEmail(email);
		dto.setRegDate(regDate);
		
		// 서비스 호출
		UserDTO userDTO = service.resultFindId(name, uid, email, regDate);
		
		if(userDTO != null) {
			req.setAttribute("name", userDTO.getName());
			req.setAttribute("uid", userDTO.getUid());
			req.setAttribute("email", userDTO.getEmail());
			req.setAttribute("regDate", userDTO.getRegDate());
			
			resp.sendRedirect("/find/resultUserId.jsp");
		}else {
			resp.sendRedirect("/find/userId.jsp");
		}
		
		*/
		
	}
}
