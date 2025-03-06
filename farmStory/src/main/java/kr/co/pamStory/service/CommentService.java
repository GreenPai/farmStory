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

	public void modifyComment(CommentDTO dto) throws Exception{
		try {
		dao.updateComment(dto);
		}catch(Exception e) {
			throw new Exception("댓글 수정 실패", e);
		}
	}

	public void deleteComment(String cno) {
		dao.deleteComment(cno);
	}

	public void modifyComment(String cnoStr, String content) {
		dao.updateCommnet(cnoStr, content);
	}
}