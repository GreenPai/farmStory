package kr.co.pamStory.controller.article.article;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.FileDTO;
import kr.co.pamStory.service.FileService;

@WebServlet("/file/download.do")
public class fileDownloadController extends HttpServlet{

	private static final long serialVersionUID = 5204917578597224250L;
	private FileService service= FileService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//다운로드할 파일 번호 데이터 수신
		String fno= req.getParameter("fno");
		
		//파일 정보 조회 서비스 호출& 다운로드 카운트 증가
		FileDTO fileDTO= service.checkFile(fno);
		service.downloadCountUp(fno);

		
		//파일 정보객체 공유 참조
		req.setAttribute("fileDTO", fileDTO);
		
		//파일 다운로드 서비스 호출
		service.downloadFile(req, resp);
		
		//다운로드 횟수 증가 후 클라이언트에 반환할 
	}

}
