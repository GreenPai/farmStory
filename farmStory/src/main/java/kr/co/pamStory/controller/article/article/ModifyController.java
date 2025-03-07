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
import kr.co.pamStory.dto.FileDTO;
import kr.co.pamStory.service.ArticleService;
import kr.co.pamStory.service.FileService;

@WebServlet("/article/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1271261235653325736L;
	private ArticleService service = ArticleService.INSTANCE;
	private FileService fileservice= FileService.INSTANCE;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		// 카테고리 수신
		HttpSession session = req.getSession();
		String cate = (String) session.getAttribute("cate");
		
		// 게시글 번호 받아오기
	    String noParam = req.getParameter("no");
	    System.out.println("modify.do 요청됨, noParam:");
	    if (noParam == null || noParam.isEmpty()) {
	        resp.sendRedirect("/farmStory/article/list.do");
	        return;
	    }

	    int no = Integer.parseInt(noParam);

	    // 글 정보 조회 서비스 호출
	    ArticleDTO article = service.getArticle(no);

	    if (article == null) {
	        resp.sendRedirect("/farmStory/article/list.do");
	        return;
	    }
	    
	    

	    // 게시글 정보 req에 담기
	    req.setAttribute("article", article);
	    
	    
	    // View forward
		RequestDispatcher dispatcher;
		if(cate.equals("grow") ) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_grow.jsp");			
		}else if(cate.equals("story")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_story.jsp");
		}else if(cate.equals("school")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_school.jsp");
		}else if(cate.equals("food")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_food.jsp");
		}else if(cate.equals("cook")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_cook.jsp");
		}else if(cate.equals("qna1")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_qna1.jsp");
		}else if(cate.equals("qna2")) {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_qna2.jsp");
		}else {
			dispatcher = req.getRequestDispatcher("/WEB-INF/view/article/modify/modify_notice.jsp");
		}

	    dispatcher.forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 수신
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();

		// DTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		
		// 글 수정 서비스 호출
		service.modifyArticle(dto);
		
		List<FileDTO> files= fileservice.uploadFile(req);

		resp.sendRedirect("/farmStory/article/list.do");
	}
}