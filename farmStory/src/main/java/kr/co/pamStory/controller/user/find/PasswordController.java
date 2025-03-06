package kr.co.pamStory.controller.user.find;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.service.UserService;

@WebServlet("/find/password.do")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1277863365653325736L;
	private UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/find/password.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("email");  // 사용자가 입력한 이메일

        // 서비스에서 이메일로 인증번호 발송
        String authCode = userservice.sendEmailCode(email);

        // 인증번호와 이메일 정보를 request에 저장
        req.setAttribute("authCode", authCode);
        req.setAttribute("email", email);

        // 결과를 "/find/password.do"로 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("/find/password.do");
        dispatcher.forward(req, resp);
		
        
        String inputCode = req.getParameter("authCode");  // 사용자가 입력한 인증번호
        String correctCode = (String) req.getAttribute("authCode");  // 서버에서 발송한 인증번호

        boolean isValid = inputCode.equals(correctCode);  // 인증번호 확인

        // 결과에 따라 처리
        if (isValid) {
        	req.setAttribute("message", "인증번호가 확인되었습니다.");
        } else {
        	req.setAttribute("message", "유효하지 않은 인증번호입니다.");
        }

        // 인증결과를 /find/password.do로 전달
        RequestDispatcher reqdispatcher = req.getRequestDispatcher("/find/password.do");
        reqdispatcher.forward(req, resp);
	}
}
