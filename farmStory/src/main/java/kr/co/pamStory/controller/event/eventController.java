package kr.co.pamStory.controller.event;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.pamStory.dto.EventDTO;
import kr.co.pamStory.service.EventService;

@WebServlet("/event.do")
public class eventController extends HttpServlet {

	private static final long serialVersionUID = 1123213L;
	
	private EventService service= EventService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//모든 일정 조회
		List<EventDTO> events= service.findAllEvents();
		req.setAttribute("events", events);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/event/event.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//일정 등록
		String title= req.getParameter("title");
		String regDate= req.getParameter("regDate");
		
		EventDTO dto= new EventDTO();
		dto.setTitle(title);
		dto.setRegDate(regDate);
		
		//이벤트 등록 서비스 호출
		service.registerEvent(dto);
		
		List<EventDTO> events = service.findAllEvents();
		req.setAttribute("events", events);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/event/event.jsp");
		dispatcher.forward(req, resp);
	}
	
}
