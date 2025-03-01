package kr.co.pamStory.controller.basket;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/basket/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 112322313L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cateNo = req.getParameter("cateNo");

		
		/*
		 * 카테고리 종목 별로 데이터 출력
		 * null: 전체, 1번 : 과일. 2번. 야채. 3번 곡류
		 * */
		
		if(cateNo == null) {
			System.out.println("비어있습니다.");
			
		}else {
			switch(cateNo) {
				case "1" : 
					System.out.println("1번"); break;
				case "2" :
					System.out.println("2번"); break;
				case "3" :
					System.out.println("3번"); break;
				default :
 			}
		}
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/basket/list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
