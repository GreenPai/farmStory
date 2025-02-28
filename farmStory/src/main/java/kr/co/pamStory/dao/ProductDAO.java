package kr.co.pamStory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL2;

public class ProductDAO extends DBHelper {
	private static final ProductDAO INSTANCE = new ProductDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static ProductDAO getInstance() {
		return INSTANCE;
	}

	private ProductDAO() {
	}

	public int insertProduct(ProductDTO dto) {
		int no = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL2.INSERT_PRODUCT);
			psmt.setInt(1, dto.getCateNo());
			psmt.setString(2, dto.getProdName());
			psmt.setInt(3, dto.getProdPrice());
			psmt.setInt(4, dto.getProdStock());
			psmt.setInt(5, dto.getProdDiscount());
			psmt.setInt(6, dto.getProdPoint());
			psmt.setInt(7, dto.getProdDeliveryFee());
			psmt.setString(8, dto.getProdcontent());
			psmt.executeUpdate();

			// 제품 번호 조회 쿼리 실행
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL2.SELECT_MAX_NO);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			closeAll();
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		
		return no;
		
	}

}
