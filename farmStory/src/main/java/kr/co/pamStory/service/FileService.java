package kr.co.pamStory.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.co.pamStory.dao.FileDAO;
import kr.co.pamStory.dto.FileDTO;

public enum FileService {
	
	INSTANCE;	
	private FileDAO dao = FileDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void registeFile(FileDTO dto) {
		dao.insertFile(dto);
	}
	
	//public FileDTO findFile(int fno) {
		//return dao.selectFile(fno);
	// }

	public List<FileDTO> findFile(String no) {
		return dao.selectFile(no);
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
	
	public void deleteFile(String ano) {
		dao.deleteFile(ano);
	}
	
	
	
	// 파일 업로드
	public List<FileDTO> uploadFile(HttpServletRequest req) {
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		
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
				logger.debug(part.toString());
				
				// 파일명 추출
				String oName = part.getSubmittedFileName();
				logger.debug(oName);
				
				// 파일을 첨부했으면
				if(oName != null && !oName.isEmpty()) {
					// 고유 파일명 생성
					int idx = oName.lastIndexOf(".");
					String ext = oName.substring(idx);
					String sName = UUID.randomUUID().toString() + ext;

					// 파일 저장
					part.write(uploadPath + File.separator + sName);
					
					// FileDTO 객체 생성
					FileDTO dto = new FileDTO();
					dto.setoName(oName);
					dto.setsName(sName);
					
					files.add(dto);
				}				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return files;
	}	
	
	// 파일 다운로드
	
	
	
	
	
}