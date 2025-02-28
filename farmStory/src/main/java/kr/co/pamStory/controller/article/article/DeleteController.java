package kr.co.pamStory.controller.article.article;

import java.io.IOException;
import java.util.List;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.ArticleDTO;
import kr.co.pamStory.service.ArticleService;
import kr.co.pamStory.service.FileService;

@WebServlet("/article/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 5168543431470215588L;
	private ArticleService service= ArticleService.INSTANCE;
	private FileService fileservice= FileService.INSTANCE;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시글 id 받기
		String no= req.getParameter("no");

				
		//파일 삭제 서비스 호출
		fileservice.deleteFile(no);
	
		//게시글 삭제 서비스 호출
		service.deleteArticle(no);
				
		//삭제 후 목록 페이지로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/article/list.do");
		dispatcher.forward(req, resp);
	
	}
	

}
