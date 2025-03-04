package kr.co.pamStory.controller.article.comment;

import java.io.IOException;

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
	private CommentService service= CommentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String noParam= req.getParameter("cno");
		if(noParam == null || noParam.isEmpty()) {
			resp.sendRedirect("/farmStroy/article/view.do");
			return;
		}
		
		int cno = Integer.parseInt(noParam);
		
		//댓글 정보 조회 서비스 호출
		//CommentDTO comment= service.getComment(cno);
		
		//if(comment == null) {
			resp.sendRedirect("/farmStory/article/view.do");
			return;
		}
		
		//댓글 정보 req에 담기
		//req.setAttribute("comment", comment);
		
		//view forward
		//RequestDispatcher dispatcher = req.getRequestDispatcher(noParam)
	//}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		int cno=Integer.parseInt(req.getParameter("cno"));
		String content= req.getParameter("content");
		String writer= req.getParameter("writer");
		String regip= req.getRemoteAddr();
		
		//dto 생성
		CommentDTO dto= new CommentDTO();
		dto.setCno(cno);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		System.out.println(dto.toString());
		
		
		
		// 글 수정 서비스 호출
		service.modifyComment(dto);
		
		resp.sendRedirect("/farmStory/article/view.do");
		
	}
}
