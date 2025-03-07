package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

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
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT);
			psmt.setInt(1, dto.getCateNo());
			psmt.setString(2, dto.getProdName());
			psmt.setInt(3, dto.getProdPrice());
			psmt.setInt(4, dto.getProdStock());
			psmt.setInt(5, dto.getProdDiscount());
			psmt.setInt(6, dto.getProdPoint());
			psmt.setInt(7, dto.getProdDeliveryFee());
			psmt.setString(8, dto.getProdContent());
			psmt.executeUpdate();

			// 제품 번호 조회 쿼리 실행
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO_PRODUCT);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			closeAll();
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		
		return no;
		
	}

	public ProductDTO selectProductByProdNo(String prodNo) {
		
		ProductDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT_BY_PRODNO);
			psmt.setString(1, prodNo);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				dto = new ProductDTO();
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
				dto.setProdDiscountPrice(rs.getInt(4) * (100 - rs.getInt(8)) / 100);
			
			}
			closeAll();
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		
		return dto;
	}

	public List<ProductDTO> selectLatest3Products() {
		
		List<ProductDTO> dtos = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_PRODUCT_LIMIT_3);
			
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
				dto.setRegDate(rs.getString(11).substring(0, 10));
				dto.setCateNo(rs.getInt(12));
				dto.setCateName(rs.getString(13));
				dtos.add(dto);
			}

			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}

	public List<ProductDTO> selectAllProducts() {
		List<ProductDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_PRODUCT_ALL);
			
			while (rs.next()) {
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
				dto.setRegDate(rs.getString(11).substring(0, 10));
				dto.setCateName(rs.getString(12));
				dto.setImagesName(rs.getString(13));
				
				dtos.add(dto);
			} 
			
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}return dtos;
	}

	public void deleteProduct(String prodNo) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_PRODUCT);
			psmt.setString(1, prodNo);
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	public int selectCountProduct() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_COUNT_PRODUCT);
			if (rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}

	public List<ProductDTO> selectAllProducts(int start) {
		
		List<ProductDTO> dtos = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT_LIMIT_6);
			psmt.setInt(1, start);
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
				dto.setRegDate(rs.getString(11).substring(0, 10));
				dto.setCateName(rs.getString(12));
				dto.setImagesName(rs.getString(13));
				dtos.add(dto);
			}

			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}

	public void ModifProductStock(int prodNo, int cartProdCount) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.MODIFY_PRODUCT_STOCK);
			psmt.setInt(1, cartProdCount);
			psmt.setInt(2, cartProdCount);
			psmt.setInt(3, prodNo);
			psmt.executeUpdate();
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	public List<ProductDTO> selectBest6Products() {
		List<ProductDTO> dtos = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_BEST_PRODUCT_6);
			
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
				dto.setRegDate(rs.getString(11).substring(0, 10));
				dto.setCateName(rs.getString(12));
				dto.setImagesName(rs.getString(13));
				dto.setProdDiscountPrice(dto.getProdPrice() * (100-dto.getProdDiscount()) / 100);
				dtos.add(dto);
			}

			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}
}
