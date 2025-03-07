package kr.co.pamStory.controller.user.find;

import java.io.Console;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/find/changePassword.do")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1271233365653325736L;
	private UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserDTO userdto = (UserDTO) session.getAttribute("sessUser");
		
		req.setAttribute("dto", userdto);
		
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/changePassword.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 요청 인코딩을 UTF-8로 설정
	    req.setCharacterEncoding("UTF-8");
	    
	    // 응답 인코딩을 UTF-8로 설정
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
		
		String uid = req.getParameter("uid");
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		
		// 비밀번호 불일치 시 경고창 후 이전 페이지로 이동
        if (!pass1.equals(pass2)) {
        	resp.getWriter().write("<script>alert('비밀번호가 일치하지 않습니다.'); history.back();</script>");
            return;
        }

        // 비밀번호 변경 실행 (boolean 반환)
        boolean success = userservice.modifyPassword(uid, pass1);

        if (success) {
        	resp.getWriter().write("<script>alert('비밀번호가 성공적으로 변경되었습니다!'); location.href='/farmStory/user/login.do';</script>");
        } else {
        	resp.getWriter().write("<script>alert('비밀번호 변경 실패. 다시 시도해주세요.'); location.href='/farmStory/find/changePassword.do';</script>");
        }

        req.getSession().invalidate();  // 세션 종료
        
	}
}














