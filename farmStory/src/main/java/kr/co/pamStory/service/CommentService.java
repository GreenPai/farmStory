package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.CommentDAO;
import kr.co.pamStory.dto.CommentDTO;

public enum CommentService {

	INSTANCE;

	private CommentDAO dao = CommentDAO.getInstance();

	public CommentDTO registeComment(CommentDTO dto) {

		int generatedKey = dao.insertComment(dto);
		return dao.selectComment(generatedKey);
	}

	public CommentDTO findComment(int cno) {
		return dao.selectComment(cno);
	}

	public List<CommentDTO> findAllComment(String parent) {
		return dao.selectAllComment(parent);
	}

	public void modifyComment(CommentDTO dto) {
		dao.updateComment(dto);
	}

	public void deleteComment(String cno) {
		dao.deleteComment(cno);
	}
}