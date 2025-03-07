package kr.co.pamStory.controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.ArticleService;
import kr.co.pamStory.service.ProductService;
import kr.co.pamStory.service.UserService;

@WebServlet("/admin/detail.do")
public class UserDetailController extends HttpServlet{

	private static final long serialVersionUID = 112312L;
	private UserService service = UserService.INSTANCE;
	private ArticleService articleservice = ArticleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid =  req.getParameter("uid");
		UserDTO dto = service.findUser(uid);
		
		// 해당 사용자가 작성한 게시글 수 가져오기
	    int postCount = articleservice.getUserArticleCount(uid);

	    // DTO에 게시글 수 설정
	    dto.setPostCount(postCount);

		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/userDetail.jsp");
		dispatcher.forward(req, resp);
	
	}

}
