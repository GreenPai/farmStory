package kr.co.pamStory.controller.article.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
		String cate = req.getParameter("cate");
		
		if(cate==null) {
			// 카테고리 수신
			HttpSession session = req.getSession();
			cate = (String) session.getAttribute("cate");
		}
		
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
			RequestDispatcher dispatcher;
			if(cate.equals("grow") ) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_grow.jsp");			
			}else if(cate.equals("story")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_story.jsp");
			}else if(cate.equals("school")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_school.jsp");
			}else if(cate.equals("food")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_food.jsp");
			}else if(cate.equals("cook")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_cook.jsp");
			}else if(cate.equals("qna1")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_qna1.jsp");
			}else if(cate.equals("qna2")) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_qna2.jsp");
			}else {
				dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/view/view_notice.jsp");
			}
			
			dispatcher.forward(req, resp);

			}catch(NumberFormatException e) {
				resp.sendRedirect("/farmStory/myinfo/list.do");
			}
	}

}