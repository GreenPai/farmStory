package kr.co.pamStory.controller.article.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.dto.CommentDTO;
import kr.co.pamStory.dto.FileDTO;
import kr.co.pamStory.service.ArticleService;
import kr.co.pamStory.service.CommentService;
import kr.co.pamStory.service.FileService;

@WebServlet("/article/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1271261225653325736L;
	private ArticleService service= ArticleService.INSTANCE;
	private FileService fileservice= FileService.INSTANCE;
	private CommentService commentservice = CommentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		
	try {
		ArticleDTO articledto = service.findArticle(Integer.parseInt(no)); 
		List<FileDTO> filedtos= fileservice.findFile(no);
		articledto.setFiles(filedtos);
		
		// 댓글 조회 서비스 호출
		List<CommentDTO> comments = commentservice.findAllComment(no);
		System.out.println(comments.toString());
		
		
		req.setAttribute("fileDTOS", filedtos);
		req.setAttribute("articleDTO", articledto);
		req.setAttribute("comments", comments);
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view.jsp");
		dispatcher.forward(req, resp);
		}catch(NumberFormatException e) {
			resp.sendRedirect("/farmStory/article/list.do");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}