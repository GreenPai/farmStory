package kr.co.jboard.service;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {
	
	INSTANCE;	
	private FileDAO dao = FileDAO.getInstance();
	
	public void registeFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	public FileDTO findFile(int fno) {
		return dao.selectFile(fno);
	}
	
	public List<FileDTO> findAllFile() {
		return dao.selectAllFile();
	}
	
	public void modifyFile(FileDTO dto) {
		dao.updateFile(dto);
	}
	
	public void deleteFile(int fno) {
		dao.deleteFile(fno);
	}
	
	
	// 파일 업로드
	public void uploadFile(HttpServletRequest req) {
		
		// 파일 업로드 경로 구하기
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/uploads");
		
		// 파일 업로드 디렉터리가 존재하지 않으면 디렉터리 생성
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// 첨부파일 객체 가져오기
			Collection<Part> parts = req.getParts();
			
			for(Part part : parts) {
				// 파일명 추출
				String oName = part.getSubmittedFileName();
				
				
				if(oName != null) {

					// 고유 파일명 생성
					int idx = oName.lastIndexOf(".");
					String ext = oName.substring(idx);
					String sName = UUID.randomUUID().toString() + ext;

					// 파일 저장
					part.write(uploadPath + File.separator + sName);
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 파일 다운로드
	
	
	
	
	
}
