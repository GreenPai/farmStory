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
import kr.co.pamStory.dao.ImageDAO;
import kr.co.pamStory.dto.FileDTO;
import kr.co.pamStory.dto.ImageDTO;

public enum ImageService {
	
	INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ImageDAO dao = ImageDAO.getInstance();
	

	public List<ImageDTO> uploadImage(HttpServletRequest req) {
		
		List<ImageDTO> images = new ArrayList<ImageDTO>();
		
		// 이미지 업로드 경로 구하기
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/product_images");
		
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
					
					// ImageDTO 객체 생성
					ImageDTO dto = new ImageDTO();
					dto.setoName(oName);
					dto.setsName(sName);
					
					images.add(dto);
				}				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return images;
	}

	public void registerImage(ImageDTO dto) {
		dao.insertImage(dto);
		
	}

	public String findImageSnameByProdNo(String prodNo) {
		return dao.selectSnameByProdNo(prodNo);
	}

	public void deleteImage(String prodNo) {
		dao.deleteImage(prodNo);
		
	}
	
}
