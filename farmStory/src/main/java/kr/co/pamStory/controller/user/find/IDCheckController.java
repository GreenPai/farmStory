package kr.co.pamStory.controller.user.find;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.pamStory.dto.UserDTO;
import kr.co.pamStory.service.UserService;

@WebServlet("/find/check/userid.do")
public class IDCheckController extends HttpServlet{

	private static final long serialVersionUID = 11231245521L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String code = "";

		UserDTO dto = userservice.findUserByNameAndEmail(name,email);
		
		if(dto.getUid().equals("인증실패")) {
			System.out.println("검증 오류");
		}else {
			// 인증번호 전송
			code = userservice.sendEmailCode(email);
			
			// 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessAuthCode", code);
		}
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("uid", dto.getUid());
		json.addProperty("code", code);
		logger.debug("json : " + json);
				
		// JSON 출력
		PrintWriter writer = resp.getWriter();
		writer.println(json);

	}

}
