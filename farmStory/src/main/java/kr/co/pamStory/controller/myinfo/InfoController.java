package kr.co.pamStory.controller.myinfo;

import java.io.IOException;
import java.security.Provider.Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.service.InfoService;

@WebServlet("/myinfo/info.do")
public class InfoController extends HttpServlet{

	private static final long serialVersionUID = 112323L;

	private InfoService infoService = InfoService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/info/info.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 인코딩을 UTF-8로 설정
	    req.setCharacterEncoding("UTF-8");
	    
	    // 응답 인코딩을 UTF-8로 설정
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");

	    String uid = req.getParameter("uid"); // 아이디
	    String pass1 = req.getParameter("pass1"); // 현재 비밀번호
	    String pass2 = req.getParameter("pass2"); // 새 비밀번호
	    String passOK = req.getParameter("passOK"); // 새 비밀번호 확인

	    // 아이디와 현재 비밀번호가 일치하는지 확인
	    boolean isValidUser = infoService.checkCurrentPassword(uid, pass1);

	    if (!isValidUser) {
	        // 현재 비밀번호가 일치하지 않으면 오류 메시지 출력
	        resp.getWriter().write("<script>alert('현재 비밀번호가 일치하지 않습니다.'); history.back();</script>");
	        return;
	    }

	    // 새 비밀번호와 비밀번호 확인이 일치하는지 확인
	    if (!pass2.equals(passOK)) {
	        resp.getWriter().write("<script>alert('새 비밀번호가 일치하지 않습니다.'); history.back();</script>");
	        return;
	    }

	    // 비밀번호 변경 실행
	    boolean success = infoService.modifyPass(uid, pass2);

	    if (success) {
	        resp.getWriter().write("<script>alert('비밀번호가 성공적으로 변경되었습니다!'); location.href='/farmStory/user/login.do';</script>");
	    } else {
	        resp.getWriter().write("<script>alert('비밀번호 변경 실패. 다시 시도해주세요.'); location.href='/farmStory/myinfo/info.do';</script>");
	    }

	    req.getSession().invalidate();  // 세션 종료
        
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/changePassword.jsp");
		//dispatcher.forward(req, resp);
	}
}
