package kr.co.pamStory.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ch.qos.logback.classic.Logger;
import kr.co.pamStory.dao.UserDAO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.PointDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.dto.UserDTO;

public enum UserService {
	INSTANCE;
	private UserDAO dao = UserDAO.getInstance();

	public void registeUser(UserDTO dto) {
		dao.insertUser(dto);
	}

	public int countUser(String type, String value) {
		return dao.selectCountUser(type, value);
	}

	public UserDTO findUser(String uid) {
		return dao.selectUser(uid);
	}

	public UserDTO findUser(UserDTO dto) {
		return dao.selectUser(dto);
	}

	public List<UserDTO> findAllUser() {
		return dao.selectAllUser();
	}

	public void modifyUser(UserDTO dto) {
		dao.updateUser(dto);
	}

	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}

	// 이메일 발송
	public String sendEmailCode(String receiver) {

		// 인증번호 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);

		// Gmail 기본정보
		String sender = "clsrntkdgh@gmail.com";
		String title = "pamStory 인증코드 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		String appPassword = "zaknwialsadkxiui";

		// Gmail SMTP 서버 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		// Gmail SMTP 세션 생성
		Session gmailSession = Session.getInstance(prop, new Authenticator(){

			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sender, appPassword);
			}
		});

		// 메일 발송
		Message message = new MimeMessage(gmailSession);

		try {
			message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=UTF-8");

			Transport.send(message);

			// 이메일로 전송한 인증코드를 세션에 저장
			//Session.setAttribute("authCode", String.valueOf(code));

		}catch(Exception e){
			e.printStackTrace();
		}

		return ""+code;
	}

	public UserDTO findUserByNameAndEmail(String name, String email) {
		return dao.selectUserByNameAndEmail(name, email);
	}
	
	public UserDTO findUserByUidAndEmail(String uid, String email) {
		return dao.selectUserByUidAndEmail(uid, email);
	}
/*
	public UserDTO resultFindId(String name, String uid, String email, String regDate) {
		return dao.selectResultFindId(name, uid, email, regDate);
	}
*/
	public List<UserDTO> findLatest3Users() {
		return dao.selectLatest3Users();
	}

	public int findUserPoint(String uid) {
		return dao.selectUserPoint(uid);
	}
	
	public int getCountUsers() {
			return dao.selectCountUser();
	}

	public int getLastPageNum(int total) {
		int lastPageNum =0;
		
		if(total %6 ==0){
			lastPageNum = total/6;
		}else {
			lastPageNum= total/6+1;
		}
		return lastPageNum;
		
		
	}

	public int getCurrentPage(String pg) {
		int currentPage=1;
		if(pg !=null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}

	public int getStartNum(int currentPage) {
		return (currentPage -1) * 6;
	}

	//페이지 그룹 계산하기
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
		int currentPageGroup =(int)Math.ceil(currentPage/ 6.0);
		int pageGroupStart= (currentPageGroup - 1)* 6 + 1;
		int pageGroupEnd = currentPageGroup * 6;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	//페이지 시작번호구하기
	public int getPageStartNum(int total, int currentPage) {
		int start=(currentPage -1) * 6;
		return total - start;
	}

	public List<UserDTO> findAllUsers(int start) {
		return dao.selectAllUsers(start);
	}

	public void modifyPoint(PointDTO pointDTO) {
		dao.modifyPoint(pointDTO);
		
	} 

	public boolean modifyPassword(String uid, String pass1) {
		return dao.updatePassword(uid, pass1);
	}

}



