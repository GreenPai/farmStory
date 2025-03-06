package kr.co.pamStory.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

	// public FileDTO findFile(int fno) {
	// return dao.selectFile(fno);
	// }

	public List<FileDTO> findFile(String fno) {
		return dao.selectFile(fno);
	}

	public List<FileDTO> findAllFile() {
		return dao.selectAllFile();
	}

	public void modifyFile(FileDTO dto) {
		dao.updateFile(dto);
	}

	public void deleteFile(HttpServletRequest req, List<String> snames) {
		String no = req.getParameter("no");
		
		//디렉토리 파일 삭제
		ServletContext ctx= req.getServletContext();
		String path = ctx.getRealPath("/uploads");
		
		for(String sname : snames) {
			File target = new File(path+ File.separator + sname);
			
			target.delete();
		}
		//db file 데이터 삭제
		dao.deleteFile(no);
	}
	
	public List<String> findFileByAno(String no){
		return dao.selectFileByAno(no);
	} 

	// 파일 업로드
	public List<FileDTO> uploadFile(HttpServletRequest req) {

		List<FileDTO> files = new ArrayList<FileDTO>();

		// 파일 업로드 경로 구하기
		ServletContext ctx = req.getServletContext();
		String uploadPath = ctx.getRealPath("/uploads");

		// 파일 업로드 디렉터리가 존재하지 않으면 디렉터리 생성
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// 첨부파일 객체 가져오기
			Collection<Part> parts = req.getParts();

			for (Part part : parts) {
				logger.debug(part.toString());

				// 파일명 추출
				String oName = part.getSubmittedFileName();
				logger.debug(oName);

				// 파일을 첨부했으면
				if (oName != null && !oName.isEmpty()) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return files;
	}

	// 파일 다운로드
	public FileDTO checkFile(String fno) {
		return dao.chooseFile(fno);
	}

	public void downloadCountUp(String fno) {
		dao.updateFileDownloadCount(fno);
		
	}

	public void downloadFile(HttpServletRequest req, HttpServletResponse resp) {
		
		//공유 참조된 파일 정보객체 가져오기
		FileDTO fileDTO = (FileDTO) req.getAttribute("fileDTO");
		
		ServletContext ctx= req.getServletContext();
		String path = ctx.getRealPath("/uploads");
		File target= new File(path + File.separator + fileDTO.getsName()); //경로 + 구분자 +파일명
		
		try {
			//response 파일 다운로드 헤더 정보 설정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDTO.getoName(),"utf-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			BufferedInputStream bis= new BufferedInputStream(new FileInputStream(target));
			BufferedOutputStream bos= new BufferedOutputStream(resp.getOutputStream());
		
		//파일 전송
		bis.transferTo(bos);
		
		bos.flush();
		bos.close();
		bis.close();
		
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

}