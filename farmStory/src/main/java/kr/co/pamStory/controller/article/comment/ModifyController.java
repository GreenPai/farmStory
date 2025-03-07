package kr.co.pamStory.controller.article.comment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.CommentDTO;
import kr.co.pamStory.service.CommentService;

@WebServlet("/comment/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 552060625690683996L;
	private CommentService service = CommentService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String noParam = req.getParameter("cno");
		if (noParam == null || noParam.isEmpty()) {
			resp.sendRedirect("/farmStroy/article/view.do");
			return;
		}

		int cno = Integer.parseInt(noParam);

		// 댓글 정보 조회 서비스 호출
		CommentDTO comment = service.findComment(cno);

		if (comment == null) {
			resp.sendRedirect("/farmStory/article/view.do");
			return;
		}

		// 댓글 정보 req에 담기
		req.setAttribute("comment", comment);

		// view forward
		RequestDispatcher dispatcher = req.getRequestDispatcher(noParam);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 수신
	    String cnoStr = req.getParameter("cno");
	    String content = req.getParameter("content");
	    
	    service.modifyComment(cnoStr, content);
	    
	    
	}
}
