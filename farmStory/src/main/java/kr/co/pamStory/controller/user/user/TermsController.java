package kr.co.pamStory.controller.user.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.TermsDTO;
import kr.co.pamStory.service.TermsService;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet {
	private static final long serialVersionUID = 1270462712653325736L;
	
	private TermsService service = TermsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 약관 조회
		TermsDTO dto = service.findTerms(1);
		
		// request 데이터 공유
		req.setAttribute("dto", dto);
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/user/terms.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
