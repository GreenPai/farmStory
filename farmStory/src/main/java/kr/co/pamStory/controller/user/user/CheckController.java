package kr.co.pamStory.controller.user.user;

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
import kr.co.pamStory.service.UserService;

@WebServlet("/user/check.do")
public class CheckController extends HttpServlet {

	private static final long serialVersionUID = -8567214395021632366L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String type = req.getParameter("type");
		String value = req.getParameter("value");
	
		// 수신된 데이터 반드시 출력해보기
		logger.debug("type : " + type + ", value : " + value); // 로거 이용
		
		// 카운트 조회하기
		int count = service.countUser(type, value);
		logger.debug("count : " + count);
		
		// 이메일 인증번호 발송
		if(type.equals("email") && count == 0) {
			String code = service.sendEmailCode(value);
			
			// 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessAuthCode", code);
		}
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count);
		logger.debug("json : " + json);
		
		// JSON 출력
		PrintWriter writer = resp.getWriter();
		writer.println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 전송 데이터 수신처리
		String authCode = req.getParameter("authCode");
		logger.debug("authCode : " + authCode);
		
		// 세션에 저장된 코드와 비교 후 JSON 출력
		HttpSession session = req.getSession();
		String sessAuthCode = (String) session.getAttribute("sessAuthCode");
		logger.debug("sessAuthCode : " + sessAuthCode);
		
		if(authCode.equals(sessAuthCode)){
			// 인증 성공
			JsonObject json = new JsonObject();
			json.addProperty("result", 1);
			resp.getWriter().println(json);			
			
		}else {
			// 인증 실패
			JsonObject json = new JsonObject();
			json.addProperty("result", 0);
			resp.getWriter().println(json);
		}
	
	}
}







