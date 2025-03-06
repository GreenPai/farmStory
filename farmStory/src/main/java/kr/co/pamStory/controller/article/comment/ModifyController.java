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
	    
	    System.out.println(cnoStr);
	    System.out.println(content);
	   
	    service.modifyComment(cnoStr, content);
	    
	    /*
	    System.out.println("서버에서 받은 댓글id(cno):"+cnoStr);

	    // cno가 null이거나 빈 값이면 오류 응답
	    if (cnoStr == null || cnoStr.isEmpty()) {
	    	System.out.println("서버에서 cno값이 없음!");
	        resp.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = resp.getWriter();
	        out.write("{\"status\":\"error\", \"message\":\"cno 값이 없습니다.\"}");
	        out.flush();
	        out.close();
	        return;
	    }
		
		// 데이터 수신
		int cno = Integer.parseInt(cnoStr);
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();

		// dto 생성
		CommentDTO dto = new CommentDTO();
		dto.setCno(cno);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);

		System.out.println(dto.toString());

		try {
		// 글 수정 서비스 호출
		service.modifyComment(dto);
		
		//성공 응답
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("{\"status\":\"success\",\"message\":\"댓글 수정이 완료되었습니다.\"}");
		out.flush();
		out.close();
		}catch(Exception e) {
			//실패 응답
			resp.setContentType("application/json;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write("{\"status\":\"error\",\"message\":\"댓글 수정이 실패되었습니다.\"}");
			out.flush();
			out.close();
		}
		
*/
	}
}
