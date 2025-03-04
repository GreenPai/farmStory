package kr.co.pamStory.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/admin/user/list.do")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<UserDTO> userDTOS = userservice.findAllUser();
		System.out.println(userDTOS.toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/user_list.jsp");
		dispatcher.forward(req, resp);
	}
}
