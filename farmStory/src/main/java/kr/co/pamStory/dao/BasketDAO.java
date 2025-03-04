package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.util.BASKET_SQL;
import kr.co.pamStory.util.DBHelper;

public class BasketDAO extends DBHelper{
	
	private static final BasketDAO INSTANCE = new BasketDAO();
	
	public static BasketDAO getInstance() {
		return INSTANCE;
	}
	
	public BasketDAO() {
	};
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<ProductDTO> SelectAllProduct() {
		
		List<ProductDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(BASKET_SQL.SELECT_ALL_PRODUCT);
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCateNo(rs.getInt(2));
				dto.setProdName(rs.getString(3));
				dto.setProdPrice(rs.getInt(4));
				dto.setProdPoint(rs.getInt(5));
				dto.setProdStock(rs.getInt(6));
				dto.setProdSold(rs.getInt(7));
				dto.setProdDiscount(rs.getInt(8));
				dto.setProdDeliveryFee(rs.getInt(9));
				dto.setProdContent(rs.getString(10));
				dto.setImagesName(rs.getString(11));
				dto.setCateName(rs.getString(12));
				
				// 실제 할인된 판매 가격
				dto.setProdDiscountPrice(rs.getInt(4) * (100 - rs.getInt(8)) / 100);
				dtos.add(dto);
				
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return dtos;
	}

	public List<ProductDTO> SelectProductByCateNo(String cateNo) {
		
		List<ProductDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(BASKET_SQL.SELECT_ALL_PRODUCT_BY_CATENO);
			psmt.setString(1, cateNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setCateNo(rs.getInt(2));
				dto.setProdName(rs.getString(3));
				dto.setProdPrice(rs.getInt(4));
				dto.setProdPoint(rs.getInt(5));
				dto.setProdStock(rs.getInt(6));
				dto.setProdSold(rs.getInt(7));
				dto.setProdDiscount(rs.getInt(8));
				dto.setProdDeliveryFee(rs.getInt(9));
				dto.setProdContent(rs.getString(10));
				dto.setImagesName(rs.getString(11));
				dto.setCateName(rs.getString(12));
				
				// 실제 할인된 판매 가격
				dto.setProdDiscountPrice(rs.getInt(4) * (100 - rs.getInt(8)) / 100);
				dtos.add(dto);
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return dtos;

	}
	
}
