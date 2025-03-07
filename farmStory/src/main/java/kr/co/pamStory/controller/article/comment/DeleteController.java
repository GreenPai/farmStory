package kr.co.pamStory.controller.article.comment;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.service.CommentService;

@WebServlet("/comment/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = -7517430128899236191L;
	private CommentService service= CommentService.INSTANCE;
	private Logger logger=  LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//댓글에 id 받기
		String cno = req.getParameter("cno");
		
		//삭제 서비스 호출
		service.deleteComment(cno);
		
		//삭제 후 댓글이 속한 페이지로 이동
		String parentId=req.getParameter("parent");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/article/view.do?no="+parentId);
		dispatcher.forward(req, resp);
}


}
