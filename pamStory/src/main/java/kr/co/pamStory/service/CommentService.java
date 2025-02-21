package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.CommentDAO;
import kr.co.pamStory.dto.CommentDTO;

public enum CommentService {
	
	INSTANCE;
	private CommentDAO dao = CommentDAO.getInstance();
	
	public void registeComment(CommentDTO dto) {
		dao.insertComment(dto);
	}
	
	public CommentDTO findComment(int cno) {
		return dao.selectComment(cno);
	}
	
	public List<CommentDTO> findAllComment() {
		return dao.selectAllComment();
	}
	
	public void modifyComment(CommentDTO dto) {
		dao.updateComment(dto);
	}
	
	public void deleteComment(int cno) {
		dao.deleteComment(cno);
	}
}